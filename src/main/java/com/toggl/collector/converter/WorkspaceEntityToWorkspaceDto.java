package com.toggl.collector.converter;

import com.toggl.collector.controller.dto.WorkspaceDto;
import com.toggl.collector.db.entity.WorkspaceEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WorkspaceEntityToWorkspaceDto implements Converter<WorkspaceEntity, WorkspaceDto> {
    @Override
    public WorkspaceDto convert(WorkspaceEntity source) {
        var record = new WorkspaceDto();
        record.setName(source.getName());
        return record;
    }
}