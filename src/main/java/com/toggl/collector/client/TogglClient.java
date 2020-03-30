package com.toggl.collector.client;

import com.toggl.collector.client.dto.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface TogglClient {
    @RequestLine("GET /me")
    @Headers({"authorization: {authorization}"})
    TogglMeDto me(@Param("authorization") String authorization);

    @RequestLine("GET /me/workspaces")
    @Headers({"authorization: {authorization}"})
    List<TogglMeWorkspaceDto> meWorkspaces(@Param("authorization") String authorization);

    @RequestLine("GET /me/projects")
    @Headers({"authorization: {authorization}"})
    List<TogglMeProjectDto> meProjects(@Param("authorization") String authorization);

    @RequestLine("GET /me/tags")
    @Headers({"authorization: {authorization}"})
    List<TogglMeTagDto> meTags(@Param("authorization") String authorization);

    @RequestLine("GET /me/time_entries")
    @Headers({"authorization: {authorization}"})
    List<TogglMeTimeEntryDto> meTimeEntries(@Param("authorization") String authorization);
}