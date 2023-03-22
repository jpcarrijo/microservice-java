package com.microservice.hrpayroll.exceptions.details;

import java.util.Date;

public class ExceptionDetails {

  private String title;

  private int status;

  private Date timestamp;

  private String methodService;

  private String message;

  public ExceptionDetails(String title, int status, Date timestamp, String methodService, String message) {
    this.title = title;
    this.status = status;
    this.timestamp = timestamp;
    this.methodService = methodService;
    this.message = message;
  }

  public ExceptionDetails() {
  }

  public String getTitle() {
    return title;
  }

  public int getStatus() {
    return status;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMethodService() {
    return methodService;
  }

  public String getMessage() {
    return message;
  }


  public static final class ExceptionDetailsBuilder {
    private String title;
    private int status;
    private Date timestamp;
    private String methodService;
    private String message;

    private ExceptionDetailsBuilder() {
    }

    public static ExceptionDetailsBuilder builder() {
      return new ExceptionDetailsBuilder();
    }

    public ExceptionDetailsBuilder title(String title) {
      this.title = title;
      return this;
    }

    public ExceptionDetailsBuilder status(int status) {
      this.status = status;
      return this;
    }

    public ExceptionDetailsBuilder timestamp(Date timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public ExceptionDetailsBuilder methodService(String methodService) {
      this.methodService = methodService;
      return this;
    }

    public ExceptionDetailsBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ExceptionDetails build() {
      return new ExceptionDetails(title, status, timestamp, methodService, message);
    }
  }
}