package com.orion.trainee.controller;

import com.orion.trainee.model.Book;
import com.orion.trainee.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAllBooks() {

        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/title")
    public ResponseEntity<Book> findBookByTitle(@RequestBody Map<String, String> title) {
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }
}
