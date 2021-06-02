package com.fabiofrasson.prova01jun.repositories;

import com.fabiofrasson.prova01jun.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
