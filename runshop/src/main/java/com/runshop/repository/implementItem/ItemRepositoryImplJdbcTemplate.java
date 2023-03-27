package com.runshop.repository.implementItem;

import com.runshop.entity.Item;
import com.runshop.repository.rowmapper.ItemRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
@Primary
public class ItemRepositoryImplJdbcTemplate implements ItemRepository {
    private static final Logger logger = Logger.getLogger(String.valueOf(ItemRepositoryImplJdbcTemplate.class));

    private final JdbcTemplate jdbcTemplate;

    private final ItemRowMapper itemRowMapper;

    @Override
    public List<Item> findAll() {
        final String sql = "select * from item order by id asc";
        return jdbcTemplate.query(sql, itemRowMapper);
    }

    @Override
    public Item create(Item item) {
        final String sql = "insert into item(name, brand, size, color,price)" +
                " VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,
                item.getName(),
                item.getBrand(),
                item.getSize(),
                item.getColor(),
                item.getPrice());
        final String sqlLastElem = "select id from item order by id desk limit 1";
        jdbcTemplate.queryForObject(sqlLastElem, Long.class);
        return item;
    }

    @Override
    public Item update(Item item) {
        final String sql = "update item set name=?, brand=?, size=?, color=?, price=? where id =?";
        jdbcTemplate.update(sql,
                item.getName(),
                item.getBrand(),
                item.getSize(),
                item.getColor(),
                item.getPrice());
        return findById(item.getId());
    }

    @Override
    public Item delete(Long id) {
        Item item = findById(id);
        final String sql = "delete from item where id = :id";
        jdbcTemplate.update(sql, itemRowMapper);
        return item;
    }

    @Override
    public Optional<Item> findOne(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from item where id = " + id, itemRowMapper));
    }

    @Override
    public Item findById(Long id) {
        final String sql = "select * from item where id= " + id;
        try {
            return jdbcTemplate.queryForObject(sql, itemRowMapper);
        } catch (EmptyResultDataAccessException e) {
            logger.error("Item not found with id " + id);
            throw new RuntimeException("Error!");
        }
    }

    @Override
    public List<Item> searchItemByBrand(String brand) {
        String sql = "select * from item where brand = ?";
        return jdbcTemplate.query(sql, itemRowMapper);
    }

    @Override
    public List<Item> searchItemBySize(Double size) {
        String sql = "select * from item where size = ? order by id asc ";
        return jdbcTemplate.query(sql, itemRowMapper);
    }
}



//запрос на получение послежней добавленной ID
//присвоить объект 1) genereted ID 2) siq образение к ней 3) Света запрос в БД




