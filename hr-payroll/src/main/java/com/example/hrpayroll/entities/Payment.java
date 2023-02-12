package com.example.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable {

  private static final long serialVersionUID = 1L;


  private String name;

  private Double dailyIncome;

  private Integer days;

  public Payment(String name, Double dailyIncome, Integer days) {
    this.name = name;
    this.dailyIncome = dailyIncome;
    this.days = days;
  }

  public Payment() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getDailyIncome() {
    return dailyIncome;
  }

  public void setDailyIncome(Double dailyIncome) {
    this.dailyIncome = dailyIncome;
  }

  public Integer getDays() {
    return days;
  }

  public void setDays(Integer days) {
    this.days = days;
  }


  public static final class PaymentBuilder {
    private String name;
    private Double dailyIncome;
    private Integer days;

    private PaymentBuilder() {
    }

    public static PaymentBuilder builder() {
      return new PaymentBuilder();
    }

    public PaymentBuilder name(String name) {
      this.name = name;
      return this;
    }

    public PaymentBuilder dailyIncome(Double dailyIncome) {
      this.dailyIncome = dailyIncome;
      return this;
    }

    public PaymentBuilder days(Integer days) {
      this.days = days;
      return this;
    }

    public Payment build() {
      Payment payment = new Payment();
      payment.setName(name);
      payment.setDailyIncome(dailyIncome);
      payment.setDays(days);
      return payment;
    }
  }

  public Double getTotal() {
    return days * dailyIncome;
  }
}
