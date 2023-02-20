package com.microservice.hrpayroll.resources;

import com.microservice.hrpayroll.entities.Payment;
import com.microservice.hrpayroll.services.PaymentService;
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

  @GetMapping("/{worker-id}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable("worker-id") Long workerId,
                                            @PathVariable("days") Integer days) {

    Payment payment = paymentService.getPayment(workerId, days);

    return ResponseEntity.status(200).body(payment);
  }
}
