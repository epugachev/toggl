package com.toggl.collector.converter;

import com.toggl.collector.client.dto.TogglMeWorkspaceDto;
import com.toggl.collector.db.entity.WorkspaceEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TogglMeWorkspaceDtoToWorkspaceEntity implements Converter<TogglMeWorkspaceDto, WorkspaceEntity> {
    @Override
    public WorkspaceEntity convert(TogglMeWorkspaceDto source) {
        var record = new WorkspaceEntity();
        record.setId(source.getId());
        record.setName(source.getName());
        record.setApiToken(source.getApiToken());
        return record;
    }
}