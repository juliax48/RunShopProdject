package com.runshop.repository.implementUser;


import com.runshop.entity.User;
import com.runshop.repository.implementItem.ItemRepositoryImplJdbcTemplate;
import com.runshop.repository.rowmapper.ItemRowMapper;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserRepositoryJdbcTemplateImpl implements UserRepository {
    private static final Logger logger = Logger.getLogger(String.valueOf(ItemRepositoryImplJdbcTemplate.class));

    private final JdbcTemplate jdbcTemplate;

    private final ItemRowMapper userRowMapper;


    @Override
    public Optional<User> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public User findById(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User create(User object) {
        return null;
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public List<User> searchUserByHeight(Double height) {
        return null;
    }
}