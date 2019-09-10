package com.xjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//加了可以拥有发现服务的权利
@EnableCircuitBreaker//histrix服务熔断
public class ProviderApplication_Histrix {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication_Histrix.class, args);
    }

}
