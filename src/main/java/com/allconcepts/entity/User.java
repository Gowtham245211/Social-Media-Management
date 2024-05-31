package com.allconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Builder
public class User {

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Long userId;

    @Column(
            name = "user_name", nullable = false
    )
    private String userName;

    @Column(
            name = "email", nullable = false
    )
    private String email;

    private String password;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Profile profile;

    /*@OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private List<Post> postsList;*/

    @ManyToMany(
            mappedBy = "usersList",
            cascade = CascadeType.ALL
    )
    private List<Post> postsList;
}
