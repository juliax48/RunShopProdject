package com.runshop.service.serviceItem;

import com.runshop.entity.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    Optional<Item> findOne(Long id);

    Item findById(Long id);

    List findAll();

    Item create(Item item);

    Item update(Item item);

    Item delete(Long id);

    List<Item> searchItemByBrand (String brand);

    List<Item> searchItemBySize (Double size);
}
