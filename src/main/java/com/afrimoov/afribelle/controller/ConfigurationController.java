package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.dto.ConfigDto;
import com.afrimoov.afribelle.service.impl.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/configurations")
@Slf4j
public class ConfigurationController {

    @Autowired
    ConfigService configService;

    @GetMapping(value = "/getConfigs")
    public ResponseEntity<List<ConfigDto>> getAll() {

        return ResponseEntity.ok(configService.getConfig());
    }
}
