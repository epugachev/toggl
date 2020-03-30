package com.toggl.collector.client.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TogglMeWorkspaceDto {
    private Long id;
    private String name;
    @SerializedName("api_token")
    private String apiToken;
}