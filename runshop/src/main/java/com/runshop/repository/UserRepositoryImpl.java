package com.runshop.repository;

import com.runshop.domain.User;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserRepositoryImpl implements UserRepository {

    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/postgres";
    public static final String DATABASE_LOGIN = "runapp";
    public static final String DATABASE_PASSWORD = "123";


    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String DATE_BIRTH = "date_birth";
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";

    private void registerDriver() {
        try {
            Class.forName(POSTRGES_DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
        try {
            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User parseResultSet(ResultSet rs) {
        User user;
        try {
            user = new User();
            user.setId(rs.getLong(ID));
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setDateBirth(rs.getTimestamp(DATE_BIRTH));
            user.setWeight(rs.getDouble(WEIGHT));
            user.setHeight(rs.getDouble(HEIGHT));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Optional<User> findOne(User user) throws SQLException {
        final String findOneQuery = "select * from users where "
                + NAME + " = " + user.getName();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findOneQuery);
        ) {
            if (rs.next()) {
                user = parseResultSet(rs);
            }
            return null;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public User findById(Long id) throws EntityNotFoundException {
        final String findById = "select * from users where id = ";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findById + id);
        ) {
            if (rs.next()) {
                return parseResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        throw new EntityNotFoundException(id, User.class.getSimpleName());
    }
    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<User> findAll() {
        final String findAllQuery = "select * from users order by id asc";

        List<User> resultUsers = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery);
        ) {
            while (rs.next()) {
                resultUsers.add(parseResultSet(rs));
            }
            return resultUsers;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////    @Override
    public User create(User user) {
        final String createUserQuery =
                "INSERT INTO user (name, surname, date_birth, weight, height)";
        final String findById = "select * from users where id = ";

        StringBuilder strBuild = new StringBuilder();
        strBuild.append("\n VALUES(");
        strBuild.append("'");
        strBuild.append(user.getName()).append("', '");
        strBuild.append(user.getSurname()).append("', ");
        strBuild.append(user.getDateBirth()).append(",");
        strBuild.append(user.getWeight()).append(", '");
        strBuild.append(user.getHeight()).append("', '");

        strBuild.append(")");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            int affectedRows = statement.executeUpdate(createUserQuery + strBuild, Statement.RETURN_GENERATED_KEYS);
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                long id = generatedKeys.getLong(1);
                ResultSet rs = statement.executeQuery(findById + id);
                if (rs.next()) {
                    return parseResultSet(rs);
                }
            } else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return null;
    }

///////////////////////////////////////////////////////////////////////////////////
    @Override
    public User update(User user) {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("UPDATE public.users SET ");
        strBuild.append(NAME).append(" = '").append(user.getName()).append("',");
        strBuild.append(SURNAME).append(" = '").append(user.getSurname()).append("',");
        strBuild.append(DATE_BIRTH).append(" = ").append(user.getDateBirth()).append(",");
        strBuild.append(WEIGHT).append(" = ").append(user.getWeight()).append(",");
        strBuild.append(HEIGHT).append(" = '").append(user.getHeight()).append("',");
        strBuild.append("WHERE id = ").append(user.getId()).append(";");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(strBuild.toString());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return user;
    }
////////////////////////////////////////////////////////////////////////////////////
    @Override
    public User delete(Long id) throws EntityNotFoundException {
        final String findById = "select * from users where id = ";

        final String deleteUserQuery = "DELETE FROM public.users WHERE id = ";

        User user = new User();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {

            ResultSet rs = statement.executeQuery(findById + id);
            if (rs.next()) {
                user = parseResultSet(rs);
            }
            statement.execute(deleteUserQuery + id);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        if (user != null) {
            return user;
        } else throw new EntityNotFoundException(id, User.class.getSimpleName());
    }

////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<User> searchUserByWeight(Double weight) {
        List<User> usersWeight = new ArrayList<>();
        final String query = "select * from users where weight = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query))
        {
            statement.setDouble(1, weight);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                usersWeight.add(parseResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersWeight;
    }

////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<User> searchUserByHeight(Double height) {
        return null;
    }
}



