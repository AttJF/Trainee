package com.orion.trainee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @Column
    private String description;
    @Column
    private String author;
    @ManyToMany(mappedBy = "rentedBooks")
    private List<User> users = new ArrayList<>();
}
