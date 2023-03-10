package com.microservice.hrconfigserver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

  @Value("${spring.cloud.config.server.git.username}")
  private String username;

  @Value("${spring.cloud.config.server.git.password}")
  private String password;

  private static final Logger LOGGER = LoggerFactory.getLogger(HrConfigServerApplication.class);


  public static void main(String[] args) {


    LOGGER.info("Iniciando aplicação HrConfigServer");

    SpringApplication.run(HrConfigServerApplication.class, args);

    LOGGER.info("Aplicação HrConfigServer iniciada com sucesso!");
  }

  @Override
  public void run(String... args) throws Exception {

    System.out.println("USERNAME = " + username);

    System.out.println("PASSWORD = " + password);

  }
}
