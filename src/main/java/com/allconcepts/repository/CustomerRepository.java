package com.allconcepts.repository;

import com.allconcepts.domain.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Set<Customer> getCustomers() {

        Set<Customer> customerSet = new TreeSet<>((a, b) -> {

            if (a.getFirstName().length() > b.getFirstName().length()) {
                return -1;
            }
            else if (a.getFirstName().length() < b.getFirstName().length()) {
                return 1;
            }
            else {
                return 0;
            }
        });


        try {
            Query query = new Query();
            
            // query.addCriteria(Criteria.where("city").is("Springfield"));
            // query.with(Sort.by(Sort.Direction.ASC));

            List<Customer> customerLinkedList = this.operations.findAll(Customer.class, "customer");
            customerSet.addAll(customerLinkedList);
            System.out.println(customerSet);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return customerSet;
    }

    public List<Customer> getCustomer() {

        Query query = new Query();

        /*query.addCriteria(Criteria.where("email").is("emily.johnson@example.com")
                .andOperator(Criteria.where("city").is("Houston")));*/

        query.addCriteria(new Criteria().orOperator(
                Criteria.where("email").is("emily.johnson@example.com"),
                Criteria.where("lastName").is("Williams")
        ));

        return this.operations.find(query, Customer.class, "customer");

    }
}
