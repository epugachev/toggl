package com.toggl.collector.client.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TogglMeDto {
    Long id;
    String email;
    @SerializedName("fullname")
    String fullName;
    @SerializedName("api_token")
    private String apiToken;
    @SerializedName("default_workspace_id")
    Long defaultWorkspaceId;
}