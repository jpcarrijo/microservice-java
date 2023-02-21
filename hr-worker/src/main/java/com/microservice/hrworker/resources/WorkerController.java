package com.microservice.hrworker.resources;

import com.microservice.hrworker.data.WorkerDTO;
import com.microservice.hrworker.entities.Worker;
import com.microservice.hrworker.exception.NotFoundException;
import com.microservice.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
@Scope("prototype")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);

  // REPOSITORY
  final WorkerRepository workerRepository;
  final Environment env;

  // INJECTION
  final WorkerDTO workerDTO;

  @GetMapping
  public ResponseEntity<List<WorkerDTO>> findAll() {

    List<Worker> list = workerRepository.findAll();

    return ResponseEntity.status(200).body(workerDTO.convertForDTO(list));
  }

  @GetMapping("/{id}")
  public ResponseEntity<WorkerDTO> findById(@PathVariable("id") Long id) {

//    Thread.sleep(3000L);

    LOGGER.info("PORT = " + env.getProperty("local.server.port"));

    try {

      Worker worker = workerRepository.findBy(id);

      return ResponseEntity.status(200).body(workerDTO.convertForDTO(worker));

    } catch (RuntimeException ex) {
      throw new NotFoundException("Worker Not Found!");
    }
  }
}
