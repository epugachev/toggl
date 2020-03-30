package com.toggl.collector.config;

import com.toggl.collector.client.TogglClient;
import com.toggl.collector.property.TogglClientProperty;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class TogglClientConfig {
    private final TogglClientProperty property;

    @Bean
    public TogglClient togglClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(TogglClient.class))
                .logLevel(Logger.Level.FULL)
                .target(TogglClient.class, property.getApiUrl());
    }
}