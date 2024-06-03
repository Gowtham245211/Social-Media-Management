package com.allconcepts.repository;

import com.allconcepts.domain.Category;
import com.allconcepts.domain.Customer;
import com.allconcepts.domain.Product;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private final MongoOperations operations;


    public ProductRepository(MongoOperations operations) {
        this.operations = operations;
    }

    public void createProduct(Product product) {

        try {
            this.operations.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {

        try {
            return this.operations.findAll(Product.class, "product");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCategoryId(String productName, String id) {

        Update update = new Update();
        Query query  = new Query();

        update.set("categoryId", Long.valueOf(id));
        query.addCriteria(Criteria.where("productName").is(productName));
        this.operations.updateFirst(query, update, Product.class);
    }
}
