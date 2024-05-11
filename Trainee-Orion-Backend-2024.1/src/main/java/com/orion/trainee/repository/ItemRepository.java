package com.orion.trainee.repository;

import com.orion.trainee.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query(value = "SELECT * FROM item WHERE id = ?1", nativeQuery = true)
    Optional<Item> findById(long id);
}
