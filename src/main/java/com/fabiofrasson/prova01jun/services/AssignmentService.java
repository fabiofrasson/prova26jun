package com.fabiofrasson.prova01jun.services;

import com.fabiofrasson.prova01jun.entities.Assignment;
import com.fabiofrasson.prova01jun.exceptions.BadRequestException;
import com.fabiofrasson.prova01jun.mappers.AssignmentMapper;
import com.fabiofrasson.prova01jun.repositories.AssignmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentService {

  private final AssignmentRepository assignmentRepository;

  public AssignmentService(AssignmentRepository assignmentRepository) {
    this.assignmentRepository = assignmentRepository;
  }

  public List<Assignment> listAll() {
    return assignmentRepository.findAll();
  }

  public Assignment findByIdOrThrowBadRequestException(Long id) {
    return assignmentRepository
        .findById(id)
        .orElseThrow(() -> new BadRequestException("Assignment not found."));
  }

  @Transactional
  public Assignment save(Assignment assignment) {
    return assignmentRepository.save(AssignmentMapper.INSTANCE.toAssignment(assignment));
  }

  public void delete(Long id) {
    assignmentRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  @Transactional
  public void replace(Assignment assignment) {
    Assignment savedAssignment = findByIdOrThrowBadRequestException(assignment.getId());
    Assignment assignment1 = AssignmentMapper.INSTANCE.toAssignment(assignment);
    assignment1.setId(savedAssignment.getId());
    assignmentRepository.save(assignment1);
  }
}
