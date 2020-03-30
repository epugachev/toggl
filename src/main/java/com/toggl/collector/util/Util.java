package com.toggl.collector.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

import static java.util.Objects.isNull;

@UtilityClass
public class Util {
    public static String apiTokenToAuthorizationHeader(String apiToken) {
        return "Basic " + new String(Base64.getEncoder().encode((apiToken + ":api_token").getBytes()));
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return (isNull(date)) ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}