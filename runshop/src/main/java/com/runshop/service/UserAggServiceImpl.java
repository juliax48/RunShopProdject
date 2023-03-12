package com.runshop.service;

import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.util.Map;

public class UserAggServiceImpl implements UserAggregationService {
    // вызвать другие сервисы, агрегазция, слои
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public Map<String, Object> getStats() {

//        List<User> users = userRepository.findAll();
//        User one = userRepository.findOne(1L);
//   //     userRepository.searchUser(String name);
//
//        Map<String, Object> resultMap = new HashMap<>();
//
//        resultMap.put("allUsers", users);
//        resultMap.put("oneUser", one);
//
        return null;
    }
}


