package com.orion.trainee.service;

import com.orion.trainee.dto.ItemDto;
import com.orion.trainee.exception.ResourceNotFoundException;
import com.orion.trainee.mapper.ItemMapper;
import com.orion.trainee.mapper.UserMapper;
import com.orion.trainee.model.Book;
import com.orion.trainee.model.Item;
import com.orion.trainee.model.Item;
import com.orion.trainee.model.User;
import com.orion.trainee.repository.ItemRepository;
import com.orion.trainee.repository.ItemRepository;
import com.orion.trainee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}