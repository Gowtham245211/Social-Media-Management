package com.allconcepts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Categories {

    public Categories(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @SequenceGenerator(name = "categories_seq", sequenceName = "categories_sequence", allocationSize = 1)
    private Long categoryId;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categoryList")
    private List<Post> postList;
}
