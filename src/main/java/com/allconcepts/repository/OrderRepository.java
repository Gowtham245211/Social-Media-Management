package com.allconcepts.repository;

import com.allconcepts.domain.Order;
import com.allconcepts.domain.Product;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    private final MongoOperations operations;

    public OrderRepository(MongoOperations operations) {
        this.operations = operations;
    }

    public void createOrder(Order order) {

        try {
            this.operations.save(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
