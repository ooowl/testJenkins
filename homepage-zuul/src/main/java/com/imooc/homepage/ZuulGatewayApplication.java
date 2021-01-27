package com.imooc.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 1. 网关应用程序
 * 2. @EnableZuulProxy: 标识应用是 Zuul Server
 * 3. @SpringCloudApplication: 用于简化配置的组合注解
 *
 * @author abserver
 * @date 2020/11/21
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
