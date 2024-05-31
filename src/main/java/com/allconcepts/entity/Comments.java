package com.allconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comments_seq")
    @SequenceGenerator(name = "comments_seq", sequenceName = "comments_sequence", allocationSize = 1)
    private Long commentId;

    private String commentText;

    private LocalDateTime commentTime;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "postId"
    )
    private Post post;
}
