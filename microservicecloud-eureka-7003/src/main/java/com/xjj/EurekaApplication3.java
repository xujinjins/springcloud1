package com.xjj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //eureka服务端启动类
public class EurekaApplication3 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication3.class, args);
    }

}
