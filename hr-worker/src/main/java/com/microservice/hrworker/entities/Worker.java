package com.microservice.hrworker.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "daily_income")
  private Double dailyIncome;


  public Worker(Long id, String name, Double dailyIncome) {
    this.id = id;
    this.name = name;
    this.dailyIncome = dailyIncome;
  }


  public Worker() {
  }

  public Long getId() { return id; }

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


  @Override
  public String toString() {
    return "Worker{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", dailyIncome=" + dailyIncome +
        '}';
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Worker)) return false;
    Worker worker = (Worker) o;
    return id.equals(worker.id);
  }


  @Override
  public int hashCode() {
    return Objects.hash(id);
  }


  public static final class WorkerBuilder {
    private Long id;
    private String name;
    private Double dailyIncome;

    private WorkerBuilder() {
    }

    public static WorkerBuilder builder() {
      return new WorkerBuilder();
    }

    public WorkerBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public WorkerBuilder name(String name) {
      this.name = name;
      return this;
    }

    public WorkerBuilder dailyIncome(Double dailyIncome) {
      this.dailyIncome = dailyIncome;
      return this;
    }

    public Worker build() {
      return new Worker(id, name, dailyIncome);
    }
  }

}
