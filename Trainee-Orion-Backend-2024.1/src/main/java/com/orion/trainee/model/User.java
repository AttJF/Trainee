package com.orion.trainee.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Integer age;
    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Pedido> pedidos;
    @ManyToMany
    @JoinTable(name = "rented_book", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> rentedBooks = new ArrayList<>();

}
