package com.runshop;

import com.runshop.domain.User;
import com.runshop.repository.EntityNotFoundException;
import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, EntityNotFoundException {
        // find all users
        System.out.println("find all users");
        UserRepository userRepository = new UserRepositoryImpl();

        List<User> all = userRepository.findAll();
        for (User user : all) {
            System.out.println(user);
        }

        // find users by ID
        System.out.println("find user by ID");
        try {
            System.out.println(userRepository.findById(1L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        // delete user 5
        System.out.println("delete user ID 5");
        System.out.println(userRepository.delete(5L));

        //
        List<User> weight = userRepository.searchUserByWeight(80D);
        for (User user : weight) {
            System.out.println(user);
        }



        // change weight user id 1
        System.out.println("info user id 2");
        System.out.println(userRepository.findById(2L));
        System.out.println();
        User user = userRepository.findById(2L);
        user.setHeight(75D);
        System.out.println("update weight user ID 2");
        System.out.println(userRepository.update(user));


    }
}