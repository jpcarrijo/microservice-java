package com.example.hrpayroll.feignclients;

import com.example.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/worker")
public interface WorkerFeignClient {

  @GetMapping(value = "/{id}")
  Worker findById(@PathVariable("id") Long id);
}
