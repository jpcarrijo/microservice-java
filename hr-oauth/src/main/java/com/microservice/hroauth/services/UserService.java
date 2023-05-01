package com.microservice.hroauth.services;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  final UserFeignClient userFeignClient;

  public User findUserByEmail(String email) {
    User user = userFeignClient.findByEmail(email);
    if (user == null) {
      LOGGER.info("Email not found!");
      throw new IllegalArgumentException("Email not found!");
    }
    LOGGER.info("Email found: " + user.getEmail());
    return user;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User user = userFeignClient.findByEmail(userName);
    if (user == null) {
      LOGGER.info("Email not found!");
      throw new UsernameNotFoundException("Email not found!");
    }
    LOGGER.info("Email found: " + user.getEmail());
    return (UserDetails) user;
  }
}
