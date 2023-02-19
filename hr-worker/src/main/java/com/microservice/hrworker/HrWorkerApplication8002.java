package com.microservice.hrworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrWorkerApplication8002 {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrWorkerApplication8002.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrWorker8002");

    SpringApplication.run(HrWorkerApplication8002.class, args);

    LOGGER.info("Aplicação HrWorker8002 iniciada com sucesso!");

  }

}
