package com.example.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class HealthCheck {

    @GetMapping("/health-check")
    public ArrayList<String> healthCheck(){
        return new ArrayList<>(Arrays.asList("Server is running", "go"));
    }
}
