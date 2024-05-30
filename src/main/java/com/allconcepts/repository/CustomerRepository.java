package com.allconcepts.repository;

import com.allconcepts.domain.Customer;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final MongoOperations operations;

    public CustomerRepository(MongoOperations operations) {
        this.operations = operations;
    }

    public void createCustomer(Customer customer) {

        try {
            this.operations.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {

        List<Customer> customerList = null;
                
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("city").is("Springfield"));
            customerList = this.operations.find(query, Customer.class, "customer");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
