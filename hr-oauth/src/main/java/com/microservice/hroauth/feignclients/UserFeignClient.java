package com.microservice.hroauth.feignclients;

import com.microservice.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user")
public interface UserFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/user/search")
  User findByEmail(@RequestParam(value = "email") String email);
}
