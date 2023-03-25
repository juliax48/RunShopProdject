package com.runshop.service.serviceItem;

import com.runshop.entity.Item;
import com.runshop.entity.User;
import com.runshop.repository.implementItem.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    @Override
    public Optional<Item> findOne(Item item) {
        return Optional.empty();
    }

    @Override
    public Item findById(Long id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Item create(Item item) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<Item> searchItemByBrand(String query, String brand) {
        return null;
    }
    @Override
    public List<Item> searchItemBySize(String query, String size) {
        return null;
    }

}
