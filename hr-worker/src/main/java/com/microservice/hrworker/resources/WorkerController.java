package com.microservice.hrworker.resources;

import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.exception.NotFoundException;
import com.microservice.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
@Scope("prototype")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerController {

  final WorkerRepository workerRepository;

  @GetMapping
  public ResponseEntity<List<Worker>> findAll() {

    List<Worker> list = workerRepository.findAll();

    return ResponseEntity.status(200).body(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {

    try {

      Worker worker = workerRepository.findById(id).get();

      return ResponseEntity.status(200).body(worker);

    } catch (RuntimeException ex) {
      throw new NotFoundException("Worker Not Found!");
    }
  }
}
