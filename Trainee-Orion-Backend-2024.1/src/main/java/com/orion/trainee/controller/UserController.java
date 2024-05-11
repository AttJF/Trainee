package com.orion.trainee.controller;

import com.orion.trainee.dto.UserDto;
import com.orion.trainee.model.User;
import com.orion.trainee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping("/{id_user}/{id_book}")
    public ResponseEntity<UserDto> rentBook(@PathVariable("id_user") Long idUser,
                                            @PathVariable("id_book") Long idBook) {
        return ResponseEntity.ok(userService.rentBook(idUser, idBook));
    }
}
