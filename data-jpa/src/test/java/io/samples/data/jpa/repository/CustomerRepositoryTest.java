package io.samples.data.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import io.samples.data.jpa.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repo;

    @Test
    public void testInjection() throws Exception {
        assertNotNull(repo);
    }

    @Test
    public void testSave() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Smith");

        repo.save(customer);

        Customer actualCustomer = repo.findByFirstName("John");
        assertNotNull("entity should exist", actualCustomer);
        assertEquals(customer, actualCustomer);

        assertNull("entity should not exist", repo.findByFirstName("Bob"));
    }

    @Test
    public void testFindByFirstAndLastName() throws Exception {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Smith");

        repo.save(customer);

        Customer actualCustomer = repo.findByFirstNameAndLastName("John", "Smith");
        assertEquals(customer, actualCustomer);
    }
}
