package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {

  final WorkerFeignClient workerFeignClient;

  @GetMapping(value = "{id}")
  public Payment getPayment(@PathVariable(value = "id") Long workerId, Integer days) {

    Worker worker = workerFeignClient.findById(workerId);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);

  }
}
