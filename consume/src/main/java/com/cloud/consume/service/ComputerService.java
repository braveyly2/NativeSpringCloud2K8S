package com.cloud.consume.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class ComputerService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback")
    public String add(){
        //return restTemplate.getForEntity("http://native-springcloud-produce-svc.ns-native-springcloud.svc.cluster.local/add?a=10&b=20", String.class).getBody();
        return restTemplate.getForEntity("http://COMPUTER-SERVICE/add?a=10&b=20", String.class).getBody();
        //return "liwei";
    }

    public String addFallback(){
        return "error";
    }
}
