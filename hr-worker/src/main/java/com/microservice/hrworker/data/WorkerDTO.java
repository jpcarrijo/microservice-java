package com.microservice.hrworker.data;

import com.microservice.hrworker.entities.Worker;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


public class WorkerDTO implements Serializable {

  private Long id;

  private String name;

  private Double dailyIncome;


  public WorkerDTO(Long id, String name, Double dailyIncome) {
    this.id = id;
    this.name = name;
    this.dailyIncome = dailyIncome;
  }


  public WorkerDTO() {
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

    public WorkerDTO build() {
      return new WorkerDTO(id, name, dailyIncome);
    }
  }


  public WorkerDTO convertForDTO(Worker worker) {
    return WorkerDTO.WorkerBuilder.builder()
        .id(worker.getId())
        .name(worker.getName())
        .dailyIncome(worker.getDailyIncome())
        .build();
  }

  public List<WorkerDTO> convertForDTO(List<Worker> workerList) {
    return workerList.stream().map(e -> {

      return WorkerBuilder.builder()
          .id(e.getId())
          .name(e.getName())
          .dailyIncome(e.getDailyIncome())
          .build();

    }).collect(Collectors.toList());
  }
}
