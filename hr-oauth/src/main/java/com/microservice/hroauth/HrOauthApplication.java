package com.microservice.hroauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrOauthApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrOauth");

    SpringApplication.run(HrOauthApplication.class, args);

    LOGGER.info("Aplicação HrOauth iniciada com sucesso!");
  }

}
