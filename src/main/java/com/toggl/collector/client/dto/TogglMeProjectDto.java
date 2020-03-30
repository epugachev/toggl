package com.toggl.collector.client.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TogglMeProjectDto {
    private Long id;
    @SerializedName("workspace_id")
    private Long workspaceId;
    private String name;
}