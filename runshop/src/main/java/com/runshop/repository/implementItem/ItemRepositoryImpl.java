package com.runshop.repository.implementItem;

import com.runshop.aspect.LoggingAspect;
import com.runshop.entity.Item;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.runshop.repository.columns.ItemColumns.ID;
import static com.runshop.repository.columns.ItemColumns.BRAND;
import static com.runshop.repository.columns.ItemColumns.SIZE;
import static com.runshop.repository.columns.ItemColumns.PRICE;
import static com.runshop.repository.columns.ItemColumns.COLOR;
import static com.runshop.repository.columns.ItemColumns.NAME;


@Repository
@PropertySource("classpath:database.properties")
public class ItemRepositoryImpl implements ItemRepository {

    private static final Logger log = Logger.getLogger(ItemRepositoryImpl.class);

    public JdbcTemplate jdbcTemplate;

    public ItemRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/postgres";
    public static final String DATABASE_LOGIN = "runapp";
    public static final String DATABASE_PASSWORD = "123";

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

    private Item parserResultSet(ResultSet resultSet) {
        Item item;
        try {
            item = new Item();
            item.setId(resultSet.getLong(ID));
            item.setName(resultSet.getString(NAME));
            item.setBrand(resultSet.getString(BRAND));
            item.setSize(resultSet.getDouble(SIZE));
            item.setColor(resultSet.getString(COLOR));
            item.setPrice(resultSet.getDouble(PRICE));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public Optional<Item> findOne(Long id) {
        return Optional.of(findById(id));
    }

    @Override
    public Item findById(Long id) {
        Item item = null;

        registerDriver();
        try {
            String sql = "select * from item where id=?";
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                item = parserResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public List findAll() {
        List<Item> items = new ArrayList<>();

        registerDriver();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select * from item order by id asc"; //SQL запрос
            //объект в которм лежат строки
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                items.add(parserResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    @Override
    public Item create(Item item) {
        registerDriver();
        try {
            String sql = "insert into item(name, brand, size,color, price)";
                    PreparedStatement preparedStatement =
                    getConnection().prepareStatement( sql + " VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getBrand());
            preparedStatement.setDouble(3, item.getSize());
            preparedStatement.setString(4, item.getColor());
            preparedStatement.setDouble(5, item.getPrice());

            preparedStatement.executeUpdate();

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Item update(Item item) {
        try {
            String SQL = "update item set name=?, brand=?, size=?, color=?, price=? where id =?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(SQL);

            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getBrand());
            preparedStatement.setDouble(3, item.getSize());
            preparedStatement.setString(4, item.getColor());
            preparedStatement.setDouble(5, item.getPrice());
            preparedStatement.setLong(6, item.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public Item delete(Long id) {
        Item item = findById(id);
        try {
            String SQL = "delete from item where id=?";
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement(SQL);

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public List<Item> searchItemsByBrand(String brand) {
        List<Item> listBrand = new ArrayList<>();
        registerDriver();

        try {
            Connection connection = getConnection();
            String sql = "select * from item where brand = ? order by id asc ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, brand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                listBrand.add(parserResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL issues");
        }
        return listBrand;
    }

    @Override
    public List<Item> searchItemsBySize(Double size) {
        List<Item> listSize = new ArrayList<>();

        registerDriver();
        try {
            Connection connection = getConnection();
            String SQL = "select * from item where size = ? order by id asc ";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setDouble(1, size);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                listSize.add(parserResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL issues");
        }
        return listSize;
    }

}