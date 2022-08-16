package com.koushik.items.service.serviceImpl;

import com.koushik.items.model.Item;
import com.koushik.items.repository.ItemRepository;
import com.koushik.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public Optional<Item> updateItem(Long itemId, Item item) {

        Optional<Item> savedItemOptional = itemRepository.findById(itemId);
        if(savedItemOptional.isPresent()){
            Item savedItem = savedItemOptional.get();
            savedItem.setName(item.getName());
            savedItem.setDescription(item.getDescription());
            savedItem.setPrice(item.getPrice());
            savedItem.setAvailable_count(item.getAvailable_count());
            itemRepository.save(savedItem);
            return Optional.of(savedItem);
        }

        return Optional.empty();
    }

    @Override
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
