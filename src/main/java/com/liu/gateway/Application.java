package com.liu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/6/14.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableCircuitBreaker
@ComponentScan(basePackages = "com.liu")
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
