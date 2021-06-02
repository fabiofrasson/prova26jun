package com.fabiofrasson.prova01jun.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Assignment implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String assigmentName;

  @CreationTimestamp private LocalDateTime regDate;

  @ManyToOne
  @JoinColumn(name = "customerId")
  @JsonIgnore
  private Customer customer;

  public Assignment() {}

  public Assignment(Long id, String assigmentName, Customer customer) {
    this.id = id;
    this.assigmentName = assigmentName;
    this.customer = customer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAssigmentName() {
    return assigmentName;
  }

  public void setAssigmentName(String assigmentName) {
    this.assigmentName = assigmentName;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Assignment that = (Assignment) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Assignment{"
        + "id="
        + id
        + ", assigmentName='"
        + assigmentName
        + '\''
        + ", regDate="
        + regDate
        + ", customer="
        + customer
        + '}';
  }
}
