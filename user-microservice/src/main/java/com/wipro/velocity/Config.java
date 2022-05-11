package com.wipro.velocity;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	/*
     * Once you have this Load balanced restTemplate instance then you can use the
     * logical name of the service, in the URL, that was used to register it with Eureka.
     */
    @Bean
    @LoadBalanced  //Rest Template has client load balancing capabilities
    RestTemplate restTemplate() {
        return new RestTemplate();
      }
}
