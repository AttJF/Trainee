package com.orion.trainee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Data
public class BookDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private String author;
}
