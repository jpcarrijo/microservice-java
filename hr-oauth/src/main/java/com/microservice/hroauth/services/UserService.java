package com.microservice.hroauth.services;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  final UserFeignClient userFeignClient;

  @Transactional
  public User findUserByEmail(String email) {

    User user = userFeignClient.findByEmail(email);

    if (user == null) {

      LOGGER.info("Email not found!");
      throw new IllegalArgumentException("Email not found!");

    }

    LOGGER.info("Email found: " + user.getEmail());
    return user;
  }
}
