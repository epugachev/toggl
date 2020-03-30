package com.toggl.collector.service;

import com.toggl.collector.db.entity.*;
import com.toggl.collector.db.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.toggl.collector.util.Util.toLocalDateTime;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final WorkspaceRepository workspaceRepository;
    private final TogglService togglService;
    private final ConversionService conversionService;
    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;
    private final TimeEntryRepository timeEntryRepository;

    public List<UserEntity> users() {
        return userRepository.findAll();
    }

    public void syncUsers() {
        for (var user : users()) {
            syncUser(user.getApiToken());
        }
    }

    public void syncUser(String apiToken) {
        //sync workspaces
        Map<Long, WorkspaceEntity> workspaceMap = new HashMap();
        for (var workspace : togglService.meWorkspaces(apiToken)) {
            workspaceMap.put(workspace.getId(), conversionService.convert(workspace, WorkspaceEntity.class));
        }
        workspaceRepository.saveAll(workspaceMap.values());

        //sync user
        var userFromToggl = togglService.me(apiToken);
        var userEntity = new UserEntity();
        userEntity.setId(userFromToggl.getId());
        userEntity.setApiToken(userFromToggl.getApiToken());
        userEntity.setFullName(userFromToggl.getFullName());
        userEntity.setDefaultWorkspace(workspaceMap.get(userFromToggl.getDefaultWorkspaceId()));
        userEntity = userRepository.save(userEntity);

        //sync tags
        Map<Long, TagEntity> tagMap = new HashMap();
        for (var tag : togglService.meTags(apiToken)) {
            var tagEntity = new TagEntity();
            tagEntity.setId(tag.getId());
            tagEntity.setName(tag.getName());
            tagEntity.setWorkspace(workspaceMap.get(tag.getWorkspaceId()));
            tagMap.put(tag.getId(), tagEntity);
        }
        tagRepository.saveAll(tagMap.values());

        //sync projects
        Map<Long, ProjectEntity> projectMap = new HashMap();
        for (var project : togglService.meProjects(apiToken)) {
            var projectEntity = new ProjectEntity();
            projectEntity.setId(project.getId());
            projectEntity.setName(project.getName());
            projectEntity.setWorkspace(workspaceMap.get(project.getWorkspaceId()));
            projectMap.put(project.getId(), projectEntity);
        }
        projectRepository.saveAll(projectMap.values());

        //sync timeEntry
        var timeEntryList = new ArrayList();
        for (var timeEntry : togglService.meTimeEntries(apiToken)) {
            if (!Objects.equals(userEntity.getId(), timeEntry.getUserId())) {
                continue;
            }
            var timeEntryEntity = new TimeEntryEntity();
            timeEntryEntity.setId(timeEntry.getId());
            timeEntryEntity.setWorkspace(workspaceMap.get(timeEntry.getWorkspaceId()));
            timeEntryEntity.setProject(projectMap.get(timeEntry.getProjectId()));
            timeEntryEntity.setUser(userEntity);
            timeEntryEntity.setDuration(timeEntry.getDuration());
            timeEntryEntity.setDescription(timeEntry.getDescription());
            timeEntryEntity.setAt(toLocalDateTime(timeEntry.getAt()));
            timeEntryEntity.setStart(toLocalDateTime(timeEntry.getStart()));
            timeEntryEntity.setStop(toLocalDateTime(timeEntry.getStop()));
            timeEntryList.add(timeEntryEntity);
        }
        timeEntryRepository.saveAll(timeEntryList);
    }
}