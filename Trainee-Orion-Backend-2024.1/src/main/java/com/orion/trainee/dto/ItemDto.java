package com.orion.trainee.dto;

import com.orion.trainee.model.Item;
import com.orion.trainee.model.Pedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
@Getter
@Setter
@Data
public class ItemDto implements Serializable {
    private Long id;
    private int valor;
    private String name;
    private String description;





}
