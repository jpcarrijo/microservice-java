package com.microservice.hrworker.exception.handler;

import com.microservice.hrworker.exception.NotFoundException;
import com.microservice.hrworker.exception.details.ExceptionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionDetails> handlerNotfound(NotFoundException notFound) {
    ExceptionDetails notFoundDetails = ExceptionDetails.ExceptionDetailsBuilder.builder()
        .timestamp(new Date())
        .status(HttpStatus.NOT_FOUND.value())
        .title("Resources Not Found!")
        .methodService(notFound.getStackTrace()[0].getMethodName())
        .message(notFound.getMessage())
        .build();

    return new ResponseEntity<>(notFoundDetails, HttpStatus.NOT_FOUND);
  }
}
