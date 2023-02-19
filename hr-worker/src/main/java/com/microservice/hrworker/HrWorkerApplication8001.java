package com.microservice.hrworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrWorkerApplication8001 {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrWorkerApplication8001.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrWorker8001");

    SpringApplication.run(HrWorkerApplication8001.class, args);

    LOGGER.info("Aplicação HrWorker8001 iniciada com sucesso!");

  }

}
