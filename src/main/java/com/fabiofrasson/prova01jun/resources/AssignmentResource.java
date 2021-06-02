package com.fabiofrasson.prova01jun.resources;

import com.fabiofrasson.prova01jun.entities.Assignment;
import com.fabiofrasson.prova01jun.services.AssignmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assignments")
public class AssignmentResource {

  private final AssignmentService assignmentService;

  public AssignmentResource(AssignmentService assignmentService) {
    this.assignmentService = assignmentService;
  }

  @GetMapping
  public ResponseEntity<List<Assignment>> list() {
    return ResponseEntity.ok(assignmentService.listAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Assignment> findById(@PathVariable Long id) {
    return ResponseEntity.ok(assignmentService.findByIdOrThrowBadRequestException(id));
  }

  @PostMapping
  public ResponseEntity<Assignment> save(@RequestBody Assignment assignment) {
    return new ResponseEntity<>(assignmentService.save(assignment), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    assignmentService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody Assignment assignment) {
    assignmentService.replace(assignment);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
