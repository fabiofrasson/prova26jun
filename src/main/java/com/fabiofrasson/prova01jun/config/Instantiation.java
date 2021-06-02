package com.fabiofrasson.prova01jun.config;

import com.fabiofrasson.prova01jun.entities.Assignment;
import com.fabiofrasson.prova01jun.entities.Customer;
import com.fabiofrasson.prova01jun.repositories.AssignmentRepository;
import com.fabiofrasson.prova01jun.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Instantiation implements CommandLineRunner {

  private final CustomerRepository customerRepository;

  private final AssignmentRepository assignmentRepository;

  public Instantiation(
      CustomerRepository customerRepository, AssignmentRepository assignmentRepository) {
    this.customerRepository = customerRepository;
    this.assignmentRepository = assignmentRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    customerRepository.deleteAll();
    Customer customer = new Customer(null, "Ricardo Silva", "ricardo.s@gmail.com");
    Customer customer1 = new Customer(null, "Joana Pereira", "joana.p@gmail.com");
    Customer customer2 = new Customer(null, "Júlio César", "julio.c@gmail.com");
    customerRepository.saveAll(Arrays.asList(customer, customer1, customer2));

    assignmentRepository.deleteAll();
    Assignment assignment = new Assignment(null, "Estudar Java", customer);
    Assignment assignment1 = new Assignment(null, "Estudar Java", customer1);
    Assignment assignment2 = new Assignment(null, "Estudar Java", customer2);
    Assignment assignment3 = new Assignment(null, "Estudar Java", customer);
    Assignment assignment4 = new Assignment(null, "Estudar Java", customer1);
    Assignment assignment5 = new Assignment(null, "Estudar Java", customer2);
    Assignment assignment6 = new Assignment(null, "Estudar Java", customer);
    Assignment assignment7 = new Assignment(null, "Estudar Java", customer1);
    Assignment assignment8 = new Assignment(null, "Estudar Java", customer2);
    assignmentRepository.saveAll(
        Arrays.asList(
            assignment,
            assignment1,
            assignment2,
            assignment3,
            assignment4,
            assignment5,
            assignment6,
            assignment7,
            assignment8));
  }
}
