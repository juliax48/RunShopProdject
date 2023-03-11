package com.runshop.service;

import com.runshop.domain.User;
import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        /*Validation layer*/
        return userRepository.findAll();
    }

    @Override
    public User create(User object) {
        /*Validation layer*/
        if (object.getWeight() > 80) {
            throw new RuntimeException("Something wrong!");
        }

        return userRepository.create(object);
    }

    @Override
    public User update(User object) {
        return userRepository.update(object);
    }

    @Override
    public void delete(Long id) {

    }
}