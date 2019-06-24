package com.jql.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test")
    public String test(){
        String reqUrl = "http://ljq-provider/provider/test";
        String result = restTemplate.getForObject(reqUrl, String.class);

        System.out.println("consumer-one consumed by" + result);
        return "consumer-one consumed";
    }
}
