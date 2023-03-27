package com.runshop.repository.implementItem;

import com.runshop.entity.Item;
import com.runshop.entity.User;
import com.runshop.repository.CRUDRepository;

import java.util.List;

public interface ItemRepository extends CRUDRepository<Long, Item> {

    List<Item> searchItemByBrand (String brand);

    List<Item> searchItemBySize (Double size);

}
