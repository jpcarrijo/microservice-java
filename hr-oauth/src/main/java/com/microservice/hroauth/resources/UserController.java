package com.microservice.hroauth.resources;

import com.microservice.hroauth.entities.User;
import com.microservice.hroauth.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  final UserService userService;


  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam(value = "email") String email) {

    try {
      User user = userService.findUserByEmail(email);
      return ResponseEntity.status(200).body(user);
    } catch (IllegalArgumentException ex) {
      throw new IllegalArgumentException(ex.getMessage());
    }
  }
}
