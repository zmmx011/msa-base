package com.invenia.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class LicensingServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(LicensingServiceApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

}
