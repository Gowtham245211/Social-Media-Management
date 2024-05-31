package com.allconcepts.controller;

import com.allconcepts.domain.Category;
import com.allconcepts.entity.Categories;
import com.allconcepts.entity.Post;
import com.allconcepts.entity.Profile;
import com.allconcepts.entity.User;
import com.allconcepts.repository.CategoryRepository;
import com.allconcepts.repository.PostRepository;
import com.allconcepts.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/addPost")
    public ResponseEntity<String> addPost() {

        JSONObject json = new JSONObject();

        Random random  = new Random();

        

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

}
