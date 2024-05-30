package com.allconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    public Post(String content) {
        this.content = content;
    }

    public Post(String content, LocalDateTime updateTime, List<User> usersList) {
        this.content = content;
        this.updateTime = updateTime;
        this.usersList = usersList;
    }

    public Post(String content, LocalDateTime updateTime, List<User> usersList, List<Categories> categoryList) {
        this.content = content;
        this.updateTime = updateTime;
        this.usersList = usersList;
        this.categoryList = categoryList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", sequenceName = "post_sequence", allocationSize = 1)
    private Long postId;

    @Column(
            unique = true
    )
    private String content;

    private LocalDateTime updateTime;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "user_post",
            joinColumns = @JoinColumn(
                    name = "post_Id",
                    referencedColumnName = "postId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "userId"
            )
    )
    private List<User> usersList;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;*/

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "post_category",
            joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "postId"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    )
    private List<Categories> categoryList;
}
