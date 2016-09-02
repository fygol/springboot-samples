package io.samples.data.jpa.repository;

import io.samples.data.jpa.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstName(String firstName);
}
