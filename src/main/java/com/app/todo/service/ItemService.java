package com.app.todo.service;

import com.app.todo.model.Item;
import com.app.todo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> read() {
        return repository.findAll();
    }

    public List<Item> create(Item item) {
        repository.save(item);
        return this.read();
    }

    public List<Item> update(Item item) {
        Item newItem = repository.findById(item.getId()).orElse(null);
        assert newItem != null;
        newItem.setDescription(item.getDescription());
        repository.save(newItem);
        return this.read();
    }

    public List<Item> delete(int id) {
        repository.deleteById(id);
        return this.read();
    }
}
