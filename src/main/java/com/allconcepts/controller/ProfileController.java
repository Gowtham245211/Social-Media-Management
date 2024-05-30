package com.allconcepts.controller;

import com.allconcepts.entity.Profile;
import com.allconcepts.entity.User;
import com.allconcepts.repository.ProfileRepository;
import com.allconcepts.repository.UserRepository;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addProfile")
    public ResponseEntity<String> addProfile() {

        JSONObject json = new JSONObject();

        List<String> stringList = userRepository.getAllUserNames();

        String[] bios = {"Graphic Designer and art lover.", "Software Developer and tech enthusiast.",
                "Technology enthusiast and avid coder.", "Fitness enthusiast and marathon runner.",
                "Travel addict and adventure seeker."};

        for (String username : stringList) {
            User user = userRepository.findByUserName(username);
            int randomNum = new Random().nextInt(5);
            Profile profile = new Profile(bios[randomNum], user);
            profileRepository.save(profile);
        }

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }
}
