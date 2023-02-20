package com.microservice.hrpayroll.config;

import com.microservice.hrpayroll.entities.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public Payment getPayment() {
    return new Payment();
  }
 }
