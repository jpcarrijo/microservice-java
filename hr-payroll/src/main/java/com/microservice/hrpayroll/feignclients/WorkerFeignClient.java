package com.microservice.hrpayroll.feignclients;

import com.microservice.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "hr-worker")
public interface WorkerFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/worker/{id}")
  Worker findById(@PathVariable("id") Long id);
}
