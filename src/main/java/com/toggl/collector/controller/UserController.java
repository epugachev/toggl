package com.toggl.collector.controller;

import com.toggl.collector.controller.dto.UserDto;
import com.toggl.collector.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
@Api(tags = {"user"}, description = "пользователи")
@RequestMapping(path = "/user/v1",
        consumes = ALL_VALUE,
        produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;
    private final ConversionService conversionService;

    @ApiOperation("справочник пользователей")
    @GetMapping("/reference")
    public List<UserDto> users() {
        return userService.users()
                .stream()
                .map(userEntity -> conversionService.convert(userEntity, UserDto.class))
                .collect(Collectors.toList());
    }

    @ApiOperation("синхронизировать пользователя с toggl по его apiToken")
    @PostMapping("/sync-user/{apiToken}")
    public void syncUser(@PathVariable String apiToken) {
        userService.syncUser(apiToken);
    }

    @ApiOperation("синхронизировать пользователей с toggl")
    @PostMapping("/sync-users")
    public void syncAllUsers() {
        userService.syncUsers();
    }
}