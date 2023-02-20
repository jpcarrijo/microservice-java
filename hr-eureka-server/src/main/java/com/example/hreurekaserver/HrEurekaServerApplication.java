package com.example.hreurekaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServerApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrEurekaServerApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrEurekaServer");

    SpringApplication.run(HrEurekaServerApplication.class, args);

    LOGGER.info("Aplicação HrEurekaServer iniciada com sucesso!");
  }

}
