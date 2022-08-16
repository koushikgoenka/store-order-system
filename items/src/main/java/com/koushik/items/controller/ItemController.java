package com.koushik.items.controller;

import com.koushik.items.model.Item;
import com.koushik.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PostMapping("/items")
    public Item createItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @GetMapping("/items/{itemId}")
    public Optional<Item> getItemById(@PathVariable long itemId) {
        return itemService.getItemById(itemId);
    }

    @PutMapping("items/{itemId}")
    public Optional<Item> updateItem(@PathVariable long itemId, @RequestBody Item item){
        return itemService.updateItem(itemId, item);
    }

    @DeleteMapping("/items/{itemId}")
    public ResponseEntity deleteItem(@PathVariable long itemId){
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("The item is deleted successfully", HttpStatus.OK);
    }
}
