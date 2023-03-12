package com.runshop.service;

import com.runshop.domain.User;
import com.runshop.repository.EntityNotFoundException;
import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {


    @Override
    public List<User> foundAll() {
        return null;
    }

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public User foundById(long id) {
        return null;
    }

    @Override
    public User deleteById(long id) {
        return null;
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public List<User> searchUser() {
        return null;
    }

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public Optional<User> update(long id, User user) {
        return Optional.empty();
    }

    @Override
    public List<User> searchUserByWeight(Double weight) {
        return null;
    }

    @Override
    public List<User> searchUserByHeight(Double height) {
        return null;
    }
}