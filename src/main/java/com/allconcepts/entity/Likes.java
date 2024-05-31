package com.allconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_seq")
    @SequenceGenerator(name = "like_seq", sequenceName = "like_sequence", allocationSize = 1)
    private Long likeId;

    private Long likeCount;

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private Post post;
}
