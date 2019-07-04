package com.jql.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/provider")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    public String test(){
        restTemplate.getForObject(getServiceUrl("zookeeper-provider"),String.class);
        return "zookeeper-provider-in-service";
    }

    @RequestMapping(value = "/getServices")
    public List<String> getServices(){
        return discoveryClient.getServices();
    }

    @RequestMapping(value = "/getServiceUrls")
    public List<String> getServiceUrls(String name){
        List<ServiceInstance> instances = discoveryClient.getInstances(name);
        List<String> urlList = new ArrayList<>();
        instances.stream().forEach((instance)->urlList.add(instance.getHost()));
        return urlList;
    }

    @RequestMapping(value = "/getServiceUrl")
    public String getServiceUrl(String name){
        List<ServiceInstance> instances = discoveryClient.getInstances(name);
        List<String> urlList = new ArrayList<>();
        instances.stream().forEach((instance)->urlList.add(instance.getHost()));
        return urlList.get((int)System.currentTimeMillis()%urlList.size());
    }
}
