package com.example.githubactionsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from Spring Boot!welcome back");
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of(
                "status", "Application is running",
                "version", "1.0.0"
        );
    }
}

