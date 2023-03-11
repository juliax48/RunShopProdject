package com.runshop.controller;

import com.runshop.domain.User;
import com.runshop.repository.UserRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FrontController extends HttpServlet {

//    public FrontController() {
//        super();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello");

        if (dispatcher != null) {
            System.out.println("Forward will be done!");
            System.out.println("We are processing user request");

            UserRepositoryImpl userService = null;
            List<User> users = userService.findAll();

            String collect = users.stream().map(User::getName).collect(Collectors.joining(","));

            req.setAttribute("userName", collect);
            Object user;
            req.setAttribute("users", users);


            dispatcher.forward(req, resp);
        }


    }

}