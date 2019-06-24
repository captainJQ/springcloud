package com.jql.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class TestController {
    @RequestMapping(value = "/test")
    public String test(){
        System.out.println("provider-two in service");
        return "provider-two in service";
    }
}
