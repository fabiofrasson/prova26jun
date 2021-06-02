package com.fabiofrasson.prova01jun.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String fullName;
  private String email;

  @OneToMany(mappedBy = "customer")
  private List<Assignment> assignments = new ArrayList<>();

  @CreationTimestamp private LocalDateTime regDate;

  public Customer() {}

  public Customer(Long id, String fullName, String email) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Assignment> getAssignments() {
    return assignments;
  }

  public LocalDateTime getRegDate() {
    return regDate;
  }

  public void setRegDate(LocalDateTime regDate) {
    this.regDate = regDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Customer{"
        + "id="
        + id
        + ", fullName='"
        + fullName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", assignments="
        + assignments
        + ", regDate="
        + regDate
        + '}';
  }
}
