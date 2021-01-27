package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author abserver
 * @date 2020/11/22
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableEurekaClient
@EnableJpaAuditing
@SpringBootApplication
public class HomepageUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(HomepageUserApplication.class, args);
    }
}