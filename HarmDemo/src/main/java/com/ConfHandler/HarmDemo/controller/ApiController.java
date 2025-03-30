package com.ConfHandler.HarmDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/endpoint")
    public String getEndpointData() {
        return "Dane z API";
    }
}
