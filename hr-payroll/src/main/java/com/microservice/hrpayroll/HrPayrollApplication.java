package com.microservice.hrpayroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
// @RibbonClient(name = "hr-worker")   // identificar quem será o client, no caso: hr-worker      ( BALANCEAMENTO DE CARGA DE FORMA MANUAL )
public class HrPayrollApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(HrPayrollApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrPayroll");

    SpringApplication.run(HrPayrollApplication.class, args);

    LOGGER.info("Aplicação HrPayroll iniciada com sucesso!");
  }

}
