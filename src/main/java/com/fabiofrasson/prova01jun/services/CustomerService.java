package com.fabiofrasson.prova01jun.services;

import com.fabiofrasson.prova01jun.entities.Customer;
import com.fabiofrasson.prova01jun.exceptions.BadRequestException;
import com.fabiofrasson.prova01jun.mappers.CustomerMapper;
import com.fabiofrasson.prova01jun.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> listAll() {
    return customerRepository.findAll();
  }

  public Customer findByIdOrThrowBadRequestException(Long id) {
    return customerRepository
        .findById(id)
        .orElseThrow(() -> new BadRequestException("Customer not found."));
  }

  @Transactional
  public Customer save(Customer customer) {
    return customerRepository.save(CustomerMapper.INSTANCE.toCustomer(customer));
  }

  public void delete(Long id) {
    customerRepository.delete(findByIdOrThrowBadRequestException(id));
  }

  @Transactional
  public void replace(Customer customer) {
    Customer savedCustomer = findByIdOrThrowBadRequestException(customer.getId());
    Customer customer1 = CustomerMapper.INSTANCE.toCustomer(customer);
    customer1.setId(savedCustomer.getId());
    customer1.setFullName(savedCustomer.getFullName());
    customer1.setEmail(savedCustomer.getEmail());
    customer1.setRegDate(savedCustomer.getRegDate());
    customerRepository.save(customer1);
  }
}
