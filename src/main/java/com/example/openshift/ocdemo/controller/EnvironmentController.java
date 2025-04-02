package com.example.openshift.ocdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.openshift.ocdemo.config.AppConfig;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/environment")
public class EnvironmentController {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Environment environment;

    @GetMapping
    public Map<String, String> getEnvironmentInfo() {
        Map<String, String> response = new HashMap<>();
        response.put("message", appConfig.getMessage());
        response.put("version", appConfig.getVersion());
        response.put("activeProfile", String.join(", ", environment.getActiveProfiles()));
        return response;
    }
}
