package com.orion.trainee.service;

import com.orion.trainee.dto.UserDto;
import com.orion.trainee.exception.ResourceNotFoundException;
import com.orion.trainee.mapper.UserMapper;
import com.orion.trainee.model.Book;
import com.orion.trainee.model.User;
import com.orion.trainee.repository.BookRepository;
import com.orion.trainee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public UserDto rentBook(Long idUser, Long idBook) {
        User user = userRepository.findById(idUser).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        user.getRentedBooks().add(book);

        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }
}
