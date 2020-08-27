package com.app.todo.controller;

import com.app.todo.model.Item;
import com.app.todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService service;

    @GetMapping("/")
    public List<Item> read() {
        return service.read();
    }

    @PostMapping("/create")
    public List<Item> create(@RequestBody Item item) {
        return service.create(item);
    }

    @PutMapping("/update")
    public List<Item> update(@RequestBody Item item) {
        return service.update(item);
    }

    @DeleteMapping("/delete/{id}")
    public List<Item> delete(@PathVariable int id) {
        return service.delete(id);
    }
}
