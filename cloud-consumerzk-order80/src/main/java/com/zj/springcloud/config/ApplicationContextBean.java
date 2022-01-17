package com.zj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextBean {

    @Bean
    @LoadBalanced  //多个zookeeper服务器时，负载均衡使用
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
