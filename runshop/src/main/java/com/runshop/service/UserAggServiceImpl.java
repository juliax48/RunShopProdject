package com.runshop.service;

import com.runshop.domain.User;
import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAggServiceImpl implements UserAggregationService {
// вызвать другие сервисы, агрегазция, слои
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public Map<String, Object> getStats() {

        List<User> users = userRepository.findAll();
        User one = userRepository.findOne(2L);
        userRepository.searchUser();

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("allUsers", users);
        resultMap.put("oneUser", one);

        return resultMap;
    }
}
