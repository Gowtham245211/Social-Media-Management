package com.allconcepts.repository;

import com.allconcepts.entity.Post;
import com.allconcepts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

    @Query(
            // value = "select user_name from user where user_name != 'diana_evans'",
            value = "select user_name from user",
            nativeQuery = true
    )
    List<String> getAllUserNames();
}
