package com.toggl.collector.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "client.toggl", ignoreUnknownFields = false)
public class TogglClientProperty {
    private String apiUrl;
}