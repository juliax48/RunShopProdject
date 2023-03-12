package com.runshop.service;

import com.runshop.domain.User;
import com.runshop.repository.EntityNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> foundAll();

    User findOne(Long id);

    User foundById(long id);

    User deleteById(long id);

    User update(User object);

    List<User> searchUser();

    User add(User user);

    Optional<User> update(long id, User user);

    List<User> searchUserByWeight(Double weight);

    List<User> searchUserByHeight (Double height);
}
