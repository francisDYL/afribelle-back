package com.afrimoov.afribelle.controller;

import com.afrimoov.afribelle.domain.Coiffure;
import com.afrimoov.afribelle.service.ICoiffureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@Slf4j
public class CoiffureController {

    private ICoiffureService service;

    public CoiffureController(@Autowired ICoiffureService coiffureService) {
        super();
        this.service = coiffureService;
    }

    @GetMapping("/")
    public String sayHello() {
        log.info("This is a call to base url");
        return "Hello, Welcome to coiffure app";
    }

    @GetMapping("/coiffures")
    public List<Coiffure> getAllCoiffure() {
        log.info("This is a call to get all coiffure");
        return this.service.getAll();
    }
}
