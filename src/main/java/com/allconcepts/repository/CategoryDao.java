package com.allconcepts.repository;

import com.allconcepts.domain.Category;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    private final MongoOperations operations;


    public CategoryDao(MongoOperations operations) {
        this.operations = operations;
    }

    public void createCategory(Category category) {

        try {
            this.operations.save(category);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Category> getAllCategories() {

        try {
            return this.operations.findAll(Category.class, "category");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
