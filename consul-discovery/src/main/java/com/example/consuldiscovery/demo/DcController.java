package com.example.consuldiscovery.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DcController
 * @Description TODO
 * @Author GuanLS
 * @Date 2019/8/28 17:31
 * @Version 1.0
 **/

@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(){
        String service = "Service:"+discoveryClient.getServices();
        System.out.println(service);
        return service;
    }
}
