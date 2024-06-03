package com.allconcepts.controller;

import com.allconcepts.domain.Customer;
import com.allconcepts.repository.CustomerRepository;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody List<Customer> customerList) {

        customerList.stream()
                .forEach(customer -> customerRepository.createCustomer(customer));

        JSONObject json = new JSONObject();

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @GetMapping("/getCustomers")
    public ResponseEntity<String> getCustomers() {

        JSONObject json = new JSONObject();
        List<String> nameList = new LinkedList<>();

        Set<Customer> customerSet = customerRepository.getCustomers();
        nameList = customerSet.stream()
                .map(customer -> customer.getFirstName() + " " + customer.getLastName())
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(nameList);
        json.put("names", nameList);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<String> getCustomer() {

        JSONObject json = new JSONObject();
        List<Customer> customer = customerRepository.getCustomer();
        System.out.println(customer);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
