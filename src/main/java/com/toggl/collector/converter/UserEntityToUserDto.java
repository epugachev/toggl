package com.toggl.collector.converter;

import com.toggl.collector.controller.dto.UserDto;
import com.toggl.collector.db.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUserDto implements Converter<UserEntity, UserDto> {
    @Override
    public UserDto convert(UserEntity source) {
        var record = new UserDto();
        record.setFullName(source.getFullName());
        return record;
    }
}
