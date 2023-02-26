package com.microservice.hruser;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HrUserApplication implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrUserApplication.class);

  final BCryptPasswordEncoder passwordEncoder;

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrUser");

    SpringApplication.run(HrUserApplication.class, args);

    LOGGER.info("Aplicação HrUser iniciada com sucesso!");
  }

  @Override
  public void run(String... args) throws Exception {

//    System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));

  }
}
