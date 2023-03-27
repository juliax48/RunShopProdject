package com.runshop.repository.rowmapper;

import com.runshop.entity.Item;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.runshop.repository.columns.ItemColumns.ID;
import static com.runshop.repository.columns.ItemColumns.BRAND;
import static com.runshop.repository.columns.ItemColumns.SIZE;
import static com.runshop.repository.columns.ItemColumns.PRICE;
import static com.runshop.repository.columns.ItemColumns.COLOR;
import static com.runshop.repository.columns.ItemColumns.NAME;

@Component
public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Item item;
        try {
            item = Item.builder()
                    .id(resultSet.getLong(ID))
                    .name(resultSet.getString(NAME))
                    .brand(resultSet.getString(BRAND))
                    .price(resultSet.getDouble(PRICE))
                    .color(resultSet.getString(COLOR))
                    .size(resultSet.getDouble(SIZE))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }
}
