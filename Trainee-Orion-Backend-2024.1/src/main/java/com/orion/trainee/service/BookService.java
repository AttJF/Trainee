package com.orion.trainee.service;

import com.orion.trainee.exception.ResourceNotFoundException;
import com.orion.trainee.model.Book;
import com.orion.trainee.model.User;
import com.orion.trainee.repository.BookRepository;
import com.orion.trainee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(Map<String, String> title) {
        return bookRepository.findBookByTitle(title.get("title")).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }
}
