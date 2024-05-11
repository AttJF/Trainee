package com.orion.trainee.repository;

import com.orion.trainee.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book WHERE title = ?1", nativeQuery = true)
    Optional<Book> findBookByTitle(String title);
}
