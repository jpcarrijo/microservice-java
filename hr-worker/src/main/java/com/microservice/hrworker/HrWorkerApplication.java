package com.microservice.hrworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrWorkerApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrWorkerApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrWorker");
    SpringApplication.run(HrWorkerApplication.class, args);
    LOGGER.info("Aplicação HrWorker iniciada com sucesso!");

  }

}
