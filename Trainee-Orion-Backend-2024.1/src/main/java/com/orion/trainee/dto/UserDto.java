package com.orion.trainee.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.orion.trainee.model.User}
 */
@Getter
@Setter
@Data
public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private List<BookDto> rentedBooks;
}