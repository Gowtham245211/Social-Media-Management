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

        List<String> stringList = userRepository.getAllUserNames();
        String[] usernamesArray = stringList.toArray(new String[stringList.size()]);
        List<String> categoryList = new LinkedList<>(Arrays.asList("Technology", "Art", "Lifestyle", "Science", "Fashion"));
        
        String[] postsArray = {"New discoveries in quantum mechanics.", "The impact of artificial intelligence on healthcare.",
                "Exploring the mysteries of the universe.", "Advancements in genetic engineering.", "Climate change and its effects on biodiversity.",
                "Latest trends in streetwear fashion.",
                "Tips for building a sustainable wardrobe.",
                "Iconic fashion moments in history.",
                "DIY fashion projects for beginners.",
                "Interview with a fashion designer.",
                "Review of the latest smartphone.",
                "Blockchain technology and its applications.",
                "Cybersecurity best practices for businesses.",
                "The future of augmented reality.",
                "Interview with a tech entrepreneur.",
                "Analyzing the works of Picasso.",
                "Exploring different art movements.",
                "Tips for starting an art collection.",
                "Art therapy and mental health.",
                "Interview with a contemporary artist.",
                "Healthy eating habits for a balanced lifestyle.",
                "Travel destinations off the beaten path.",
                "Mindfulness techniques for stress relief.",
                "Parenting tips for new parents.",
                "Interview with a wellness coach.",
                "The intersection of art and technology.",
                "Fashion-forward cities around the world.",
                "Innovations in sustainable living.",
                "Science fiction book recommendations.",
                "DIY home decor ideas."
        };

        LocalDateTime time = LocalDateTime.now().plusDays(15);

        // User user1 = userRepository.findByUserName("charlie_davis");
        User user2 = userRepository.findByUserName("diana_evans");

        Post postObj = new Post("DIY home decor ideas.", time, new LinkedList<>(Arrays.asList(user2)));

        postRepository.save(postObj);

        return new ResponseEntity<>(json.toString(), HttpStatus.OK);
    }

}
