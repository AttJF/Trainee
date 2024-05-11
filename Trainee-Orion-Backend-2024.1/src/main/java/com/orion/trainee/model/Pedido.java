package com.orion.trainee.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int valor;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToMany
    @JoinTable(name = "pedidoitem",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_item"))
    private List<Item> pedidoItem= new ArrayList<Item>();


    public List<Item> getItem() {
        return pedidoItem;
    }

}
