package com.allconcepts.controller;

import com.allconcepts.domain.Category;
import com.allconcepts.domain.Customer;
import com.allconcepts.domain.Product;
import com.allconcepts.repository.CategoryDao;
import com.allconcepts.repository.CategoryRepository;
import com.allconcepts.repository.CustomerRepository;
import com.allconcepts.repository.ProductRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryDao categoryDao;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody List<Product> productList) {

        productList.stream()
                .forEach(product -> productRepository.createProduct(product));

        JSONObject json = new JSONObject();

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @PutMapping("/modifyProductCategory")
    public ResponseEntity<String> modifyProductCategory() {

        JSONObject json = new JSONObject();

        List<Product> productList = productRepository.getAllProducts();

        LinkedHashMap<String, List<String>> categoryMap = new LinkedHashMap<>();
        categoryMap.put("Beverages-1", new LinkedList<>(Arrays.asList("Chai", "Chang")));
        categoryMap.put("Condiments and Sauces-2", new LinkedList<>(Arrays.asList("Aniseed Syrup", "Grandma's Boysenberry Spread", "Northwoods Cranberry Sauce")));
        categoryMap.put("Seasonings and Spices-3", new LinkedList<>(Arrays.asList("Chef Anton's Cajun Seasoning", "Chef Anton's Gumbo Mix")));
        categoryMap.put("Snacks and Sweets-4", new LinkedList<>(Arrays.asList("Uncle Bob's Organic Dried Pears")));
        categoryMap.put("Meat and Seafood-5", new LinkedList<>(Arrays.asList("Mishi Kobe Niku", "Ikura")));

        productList.stream()
                .forEach(product -> {
                       for (Map.Entry entry : categoryMap.entrySet()) {
                           String key = (String) entry.getKey();
                           LinkedList<String> valuesList = (LinkedList<String>) entry.getValue();

                           if (valuesList.contains(product.getProductName())) {
                               productRepository.updateCategoryId(product.getProductName(), key.split("-")[1]);
                           }
                       }
                });

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
