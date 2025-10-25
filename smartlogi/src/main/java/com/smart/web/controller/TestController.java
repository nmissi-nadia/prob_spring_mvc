package com.smart.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class TestController {

    private static final Log log = LogFactory.getLog(TestController.class);

    @GetMapping
    public String testConnection() {
        log.error("Hello");
        return "Spring MVC fonctionne !";
    }
}
