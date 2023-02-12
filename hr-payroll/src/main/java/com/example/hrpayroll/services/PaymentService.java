package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  public Payment getPayment(Long workerId, Integer days) {

    return new Payment("Alice", 255.0, days);

  }
}
