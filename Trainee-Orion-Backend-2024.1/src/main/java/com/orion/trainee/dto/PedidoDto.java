package com.orion.trainee.dto;

import com.orion.trainee.model.Item;
import com.orion.trainee.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class PedidoDto implements Serializable {
    private Long id;
    private int valor ;
    private Long idUser;
    private List<Item> pedidoItem;



}
