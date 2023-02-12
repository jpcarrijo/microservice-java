package com.example.hrpayroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrPayrollApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrPayrollApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrPayroll");

    SpringApplication.run(HrPayrollApplication.class, args);

    LOGGER.info("Aplicação HrPayroll iniciada com sucesso!");
  }

}
