package com.toggl.collector.service;

import com.toggl.collector.client.TogglClient;
import com.toggl.collector.client.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.toggl.collector.util.Util.apiTokenToAuthorizationHeader;

@Service
@AllArgsConstructor
public class TogglService {
    private final TogglClient togglClient;

    public TogglMeDto me(String apiToken) {
        return togglClient.me(apiTokenToAuthorizationHeader(apiToken));
    }

    public List<TogglMeWorkspaceDto> meWorkspaces(String apiToken) {
        return togglClient.meWorkspaces(apiTokenToAuthorizationHeader(apiToken));
    }

    public List<TogglMeProjectDto> meProjects(String apiToken) {
        return togglClient.meProjects(apiTokenToAuthorizationHeader(apiToken));
    }

    public List<TogglMeTagDto> meTags(String apiToken) {
        return togglClient.meTags(apiTokenToAuthorizationHeader(apiToken));
    }

    public List<TogglMeTimeEntryDto> meTimeEntries(String apiToken) {
        return togglClient.meTimeEntries(apiTokenToAuthorizationHeader(apiToken));
    }
}