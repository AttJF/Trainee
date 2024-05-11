package com.orion.trainee.controller;

import com.orion.trainee.model.Item;
import com.orion.trainee.model.User;
import com.orion.trainee.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Item>> findAllItem() {
        return ResponseEntity.ok(itemService.findAllItem());
    }

}
