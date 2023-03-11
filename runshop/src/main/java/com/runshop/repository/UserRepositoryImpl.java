package com.runshop.repository;

import com.runshop.domain.User;
import org.apache.commons.lang3.StringUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/qwery";
    public static final String DATABASE_LOGIN = "runapp";
    public static final String DATABASE_PASSWORD = "123";


    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String BIRTH_DATE = "birth_date";
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";


    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from user";

        List<User> result = new ArrayList<>();

        Connection connection;
        PreparedStatement statement;
        ResultSet rs;

        try {
            Class.forName(POSTRGES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {

            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }

        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
//        jdbc:postgresql://localhost:5432/apptest

        try {
            connection = DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
            statement = connection.prepareStatement(findAllQuery);
            rs = statement.executeQuery();

            System.out.println(rs.getMetaData().getColumnCount());

            while (rs.next()) {

                System.out.println(rs.getLong(ID));
                //User user = new User();
//                user.setId(rs.getLong(ID));
//                user.setName(rs.getString(NAME));
//                user.setSurname(rs.getString(SURNAME));
//                user.setBirthDate(rs.getTimestamp(BIRTH_DATE));
//                user.setHeight(rs.getDouble(HEIGHT));
//                user.setWeight(rs.getDouble(WEIGHT));

//                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    @Override
    public User findOne(Long id) {
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
    public void delete(Long id) {

    }

    @Override
    public void searchUser() {

    }
}
