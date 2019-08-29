package com.example.consulconsumer.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName DcController
 * @Description TODO
 * @Author GuanLS
 * @Date 2019/8/29 15:01
 * @Version 1.0
 **/

@RestController
public class DcController {
    @Autowired
    RestTemplate restTemplate;

   @Autowired
   LoadBalancerClient loadBalancerClient;

   @GetMapping("/consul")
   public String dc(){
       ServiceInstance serviceInstance = loadBalancerClient.choose("consul-client");
       String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/dc";
       System.out.println("url = " + url);
       return restTemplate.getForObject(url,String.class);
   }
}
