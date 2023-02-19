package com.microservice.hrworker.config;

import com.microservice.hrworker.data.WorkerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

  @Bean
  public WorkerDTO convertForDTO() {
    return new WorkerDTO();
  }
}
