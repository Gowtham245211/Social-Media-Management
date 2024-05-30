package com.allconcepts.controller;

import com.allconcepts.entity.Categories;
import com.allconcepts.entity.Post;
import com.allconcepts.entity.User;
import com.allconcepts.repository.PostRepository;
import com.allconcepts.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/deleteTable")
    public ResponseEntity<String> deleteTable() {

        JSONObject json = new JSONObject();

        userRepository.deleteAll();

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<String> addUsers() {

        JSONObject json = new JSONObject();
        List<User> userList = new LinkedList<>(Arrays.asList(
                new User("john_doe", "john@example.com"),
                new User("jane_smith", "jane@example.com"),
                new User("alice_jones", "alice@example.com"),
                new User("bob_brown", "bob@example.com"),
                new User("charlie_davis", "charlie@example.com"),
                new User("diana_evans", "diana@example.com'"),
                new User("frank_green", "frank@example.com"),
                new User("grace_harris", "grace@example.com"),
                new User("henry_isaac", "henry@example.com"),
                new User("ivy_james", "ivy@example.com"),
                new User("jack_kelly", "jack@example.com"),
                new User("karen_lee", "karen@example.com"),
                new User("larry_miller", "larry@example.com"),
                new User("molly_nelson", "molly@example.com"),
                new User("nick_owen", "nick@example.com")
                ));

        userRepository.saveAll(userList);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
