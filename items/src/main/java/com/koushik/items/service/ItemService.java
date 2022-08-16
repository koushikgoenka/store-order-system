package com.koushik.items.service;

import com.koushik.items.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    public Item addItem(Item item);

    public List<Item> getAllItems();

    public Optional<Item> getItemById(Long itemId);

    public Optional<Item> updateItem(Long itemId, Item item);

    public void deleteItem(Long itemId);

}
