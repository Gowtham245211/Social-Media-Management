package com.allconcepts.controller;

import com.allconcepts.entity.Categories;
import com.allconcepts.entity.Categories;
import com.allconcepts.repository.CategoryRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @PostMapping("/addCategories")
    public ResponseEntity<String> addCategories() {

        JSONObject json = new JSONObject();
        
        List<Categories> categoryList = new LinkedList<>(Arrays.asList(
                new Categories("Technology"),
                new Categories("Art"),
                new Categories("Lifestyle"),
                new Categories("Science"),
                new Categories("Fashion")
        ));

        categoryRepository.saveAll(categoryList);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
