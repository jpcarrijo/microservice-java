package com.microservice.hrworker.repositories;

import com.microservice.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

  @Query(nativeQuery = true, value = "SELECT * FROM tb_worker w WHERE w.id = ?1")
  Worker findBy(Long id);
}
