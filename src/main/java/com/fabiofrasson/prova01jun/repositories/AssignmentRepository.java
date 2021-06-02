package com.fabiofrasson.prova01jun.repositories;

import com.fabiofrasson.prova01jun.entities.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {}
