package com.toggl.collector.client.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class TogglMeTimeEntryDto {
    private Long id;
    @SerializedName("workspace_id")
    private Long workspaceId;
    @SerializedName("project_id")
    private Long projectId;
    @SerializedName("user_id")
    private Long userId;
    private Date at;
    private Date start;
    private Date stop;

    private Long duration;
    private String description;
    private List<String> tags = new ArrayList();
    @SerializedName("tag_ids")
    private List<Long> tagIds = new ArrayList();

    private Long uid; //user id
    private Long wid; //workspace id
    private Long pid; //project id
}