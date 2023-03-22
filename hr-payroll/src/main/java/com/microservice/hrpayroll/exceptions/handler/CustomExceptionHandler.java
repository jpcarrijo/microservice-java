package com.microservice.hrpayroll.exceptions.handler;

import com.microservice.hrpayroll.exceptions.NotFoundException;
import com.microservice.hrpayroll.exceptions.details.ExceptionDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

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


  protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                           HttpStatus status, WebRequest request) {

    Date date = new Date();

    if (ex instanceof HttpClientErrorException) {
      HttpClientErrorException exception = (HttpClientErrorException) ex;
      ExceptionDetails exceptionDetails = ExceptionDetails.ExceptionDetailsBuilder.builder()
          .timestamp(date)
          .status(status.value())
          .title("Algum dado inválido!")
          .methodService(exception.getStackTrace()[0].getMethodName())
          .message(exception.getMessage())
          .build();
      return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
    return null;
  }

}
