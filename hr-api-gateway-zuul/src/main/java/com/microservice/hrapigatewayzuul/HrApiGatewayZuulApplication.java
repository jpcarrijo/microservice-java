package com.microservice.hrapigatewayzuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class HrApiGatewayZuulApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(HrApiGatewayZuulApplication.class);

  public static void main(String[] args) {

    LOGGER.info("Iniciando aplicação HrApiGatewayZuul");

    SpringApplication.run(HrApiGatewayZuulApplication.class, args);

    LOGGER.info("Aplicação HrApiGatewayZuul iniciada com sucesso!");
  }

}
