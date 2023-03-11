package com.runshop;

import com.runshop.domain.User;
import com.runshop.repository.UserRepository;
import com.runshop.repository.UserRepositoryImpl;

import java.util.List;

public class Main {

    //Ctrl+Alt+O - import optimizing
    //Ctrl+Alt+L - formatting

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl();

        List<User> all = userRepository.findAll();

        for (User user : all) {
            System.out.println(user);
        }

    }
}