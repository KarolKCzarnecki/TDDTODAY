package com.tddtoday.tddtoday.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/env-values")
public class EnvValuesController {

    @Value("${example.value}")
    private String exampleValue;

    @GetMapping("/")
    public String get() {
        return exampleValue;
    }

}
