package com.example.hrpayroll.services;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentService {

  @Value("${hr-worker.host}")
  private String host;

  final RestTemplate restTemplate;

  public Payment getPayment(Long workerId, Integer days) throws HttpClientErrorException {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("id", "" + workerId);

    Worker worker = restTemplate.getForObject(host + "/worker/{id}", Worker.class, uriVariables);

    try {

      assert worker != null;

      return new Payment(worker.getName(), worker.getDailyIncome(), days);

    } catch (HttpClientErrorException ex) {
      throw new NotFoundException(ex.getMessage());
    }
  }
}
