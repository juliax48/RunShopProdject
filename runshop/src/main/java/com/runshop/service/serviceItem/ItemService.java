package com.runshop.service.serviceItem;

import com.runshop.entity.Item;
import com.runshop.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    Optional<Item> findOne(Item item);

    Item findById(Long id);

    List findAll();

    Item create(Item item);

    Item update(Item item);

    void delete(Long id);

    List<Item> searchItemByBrand (String query, String brand);

    List<Item> searchItemBySize(String query, String size);


}
