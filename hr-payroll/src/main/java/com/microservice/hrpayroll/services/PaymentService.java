package com.microservice.hrpayroll.services;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.entities.Worker;
import com.microservice.hrpayroll.feignclients.WorkerFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {

  final WorkerFeignClient workerFeignClient;

  public Payment getPayment(Long workerId, Integer days) {

    Worker worker = workerFeignClient.findById(workerId);

    return new Payment(worker.getName(), worker.getDailyIncome(), days);

  }
}
