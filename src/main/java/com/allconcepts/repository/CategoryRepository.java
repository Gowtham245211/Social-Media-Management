package com.allconcepts.repository;

import com.allconcepts.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

    Categories findByName(String category);
}
