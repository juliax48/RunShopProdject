package com.runshop.service.serviceItem;

import com.runshop.entity.Item;
import com.runshop.repository.implementItem.ItemRepository;
import com.runshop.repository.implementUser.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    @Override
    public Optional<Item> findOne(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item findById(Long id) {
        try {
            return itemRepository.findById(id);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item create(Item item) {
        return itemRepository.create(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.update(item);
    }

    @Override
    public Item delete(Long id) {
        return itemRepository.delete(id);
    }

    @Override
    public List<Item> searchItemByBrand(String brand) {
        return itemRepository.searchItemByBrand(brand);
    }

    @Override
    public List<Item> searchItemBySize(Double size) {
        return itemRepository.searchItemBySize(size);
    }

}
