package com.runshop.repository.implementUser;

import com.runshop.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static String URL =
            "jdbc:postgresql://localhost:5432/postgres?useUnicode=true&useJDBCCompliantTimezoneShift=true&Peugeot RifteruseLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

    // соединие к БВ JBDC
    private static Connection connection;

    //инициализируем
    static {
        try { //подгружаем драйвер
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try { //компоненты кля подключения к БД
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private User parserResultSet(ResultSet resultSet) {
        User user;
        try {
            user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setDateBirth(resultSet.getTimestamp("date_birth"));
            user.setWeight(resultSet.getDouble("weight"));
            user.setHeight(resultSet.getDouble("height"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public Optional<User> findOne(User user) {
//        final String findOneQuery = "select * from users where + NAME + user.getName();
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet rs = statement.executeQuery(findOneQuery);
//        ) {
//            if (rs.next()) {
//                user = parserResultSet();
//            }
//            return null;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public Optional<User> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public User findById(Long id) throws EntityNotFoundException {

        final String findById = "select * from users where id = ";

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(findById);

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            parserResultSet(resultSet);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        throw new EntityNotFoundException(id, User.class.getSimpleName());
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        //Объект запрос который сожержит запрос
        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from users order by id asc"; //SQL запрос
            //объект в которм лежат строки
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                users.add(parserResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
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


    ///////////////////////////////////////////////////////////////////////////////    @Override
//    public User create(User user) {
//        final String createUserQuery =
//                "INSERT INTO user (name, surname, date_birth, weight, height)";
//        final String findById = "select * from users where id = ";
//
//        StringBuilder strBuild = new StringBuilder();
//        strBuild.append("\n VALUES(");
//        strBuild.append("'");
//        strBuild.append(user.getName()).append("', '");
//        strBuild.append(user.getSurname()).append("', ");
//        strBuild.append(user.getDateBirth()).append(",");
//        strBuild.append(user.getWeight()).append(", '");
//        strBuild.append(user.getHeight()).append("', '");
//
//        strBuild.append(")");
//
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();
//        ) {
//            int affectedRows = statement.executeUpdate(createUserQuery + strBuild, Statement.RETURN_GENERATED_KEYS);
//            if (affectedRows == 0) {
//                throw new SQLException("Creating user failed, no rows affected.");
//            }
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//
//            if (generatedKeys.next()) {
//                long id = generatedKeys.getLong(1);
//                ResultSet rs = statement.executeQuery(findById + id);
//                if (rs.next()) {
//                    return parseResultSet(rs);
//                }
//            } else {
//                throw new SQLException("Creating user failed, no ID obtained.");
//            }
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//        return null;
//    }
//
//    ///////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public User update(User user) {
//        StringBuilder strBuild = new StringBuilder();
//        strBuild.append("UPDATE public.users SET ");
//        strBuild.append(NAME).append(" = '").append(user.getName()).append("',");
//        strBuild.append(SURNAME).append(" = '").append(user.getSurname()).append("',");
//        strBuild.append(DATE_BIRTH).append(" = ").append(user.getDateBirth()).append(",");
//        strBuild.append(WEIGHT).append(" = ").append(user.getWeight()).append(",");
//        strBuild.append(HEIGHT).append(" = '").append(user.getHeight()).append("',");
//        strBuild.append("WHERE id = ").append(user.getId()).append(";");
//
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(strBuild.toString());
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//        return user;
//    }
//
//    ////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public void delete(Long id) {
//        final String findById = "select * from users where id = ";
//
//        final String deleteUserQuery = "DELETE FROM public.users WHERE id = ";
//
//        User user = new User();
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();) {
//
//            ResultSet rs = statement.executeQuery(findById + id);
//            if (rs.next()) {
//                user = parseResultSet(rs);
//            }
//            statement.execute(deleteUserQuery + id);
//
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//            throw new RuntimeException("SQL Issues!");
//        }
//        if (user != null) {
//
//        } else throw new EntityNotFoundException(id, User.class.getSimpleName());
//
//    }

////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    public List<User> searchUserByWeight(Double weight) {
//        List<User> usersWeight = new ArrayList<>();
//        final String query = "select * from users where weight = ?";
//
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(query))
//        {
//            statement.setDouble(1, weight);
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                usersWeight.add(parseResultSet(rs));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return usersWeight;
//    }

    @Override
    public List<User> searchUserByHeight(Double height) {
        return null;
    }

}



