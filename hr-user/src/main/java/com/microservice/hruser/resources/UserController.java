package com.microservice.hruser.resources;

import com.microservice.hruser.entities.User;
import com.microservice.hruser.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

  final UserRepository userRepository;

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable(value = "id") Long id) {

    User user = userRepository.findById(id).get();

    return ResponseEntity.ok(user);
  }


  @GetMapping(value = "/search")
  public ResponseEntity<User> findByEmail(@RequestParam(value = "email") String email) {

    User user = userRepository.findByEmail(email);

    return ResponseEntity.ok(user);
  }
}
