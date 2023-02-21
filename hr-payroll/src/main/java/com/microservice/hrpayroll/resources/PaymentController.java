package com.microservice.hrpayroll.resources;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
@Scope("prototype")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentController {

  final PaymentService paymentService;

  @HystrixCommand(fallbackMethod = "getPaymentAlternative")
  @GetMapping("/{worker-id}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable("worker-id") Long workerId,
                                            @PathVariable("days") Integer days) {

    Payment payment = paymentService.getPayment(workerId, days);

    return ResponseEntity.status(200).body(payment);
  }


  public ResponseEntity<Payment> getPaymentAlternative(Long workerId,
                                                       Integer days) {

    Payment payment = new Payment("Brann", 400.0, days);

    return ResponseEntity.status(200).body(payment);
  }
}
