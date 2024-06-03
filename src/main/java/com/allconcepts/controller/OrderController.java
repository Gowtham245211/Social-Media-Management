package com.allconcepts.controller;

import com.allconcepts.domain.Category;
import com.allconcepts.domain.Order;
import com.allconcepts.repository.CategoryDao;
import com.allconcepts.repository.OrderRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/addOrders")
    public ResponseEntity<String> addOrders(@RequestBody List<Order> orderList) {

        JSONObject json = new JSONObject();

        orderList.stream()
                .forEach(order -> orderRepository.createOrder(order));

        /*List<Categories> categoryList = new LinkedList<>(Arrays.asList(
                new Categories("Technology"),
                new Categories("Art"),
                new Categories("Lifestyle"),
                new Categories("Science"),
                new Categories("Fashion")
        ));

        categoryRepository.saveAll(categoryList);*/

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
