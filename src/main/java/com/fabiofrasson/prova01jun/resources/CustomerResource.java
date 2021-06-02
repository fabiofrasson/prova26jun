package com.fabiofrasson.prova01jun.resources;

import com.fabiofrasson.prova01jun.services.CustomerService;
import com.fabiofrasson.prova01jun.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerResource {

  private final CustomerService customerService;

  public CustomerResource(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public ResponseEntity<List<Customer>> list() {
    return ResponseEntity.ok(customerService.listAll());
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Customer> findById(@PathVariable Long id) {
    return ResponseEntity.ok(customerService.findByIdOrThrowBadRequestException(id));
  }

  @PostMapping
  public ResponseEntity<Customer> save(@RequestBody Customer customer) {
    return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    customerService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping
  public ResponseEntity<Void> replace(@RequestBody Customer customer) {
    customerService.replace(customer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
