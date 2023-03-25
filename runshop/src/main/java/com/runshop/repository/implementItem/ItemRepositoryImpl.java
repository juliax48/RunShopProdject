package com.runshop.repository.implementItem;

import com.runshop.entity.Item;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.PropertySource;
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
            //загрузка драйвера в classLoader (это чтобы с поднятием контекста спринга не конфликтовало?)
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
            item.setSize(resultSet.getString(SIZE));
            item.setColor(resultSet.getString(COLOR));
            item.setPrice(resultSet.getDouble(PRICE));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    @Override
    public Optional<Item> findOne(Item item) { // любой объект как Optional
        return Optional.of(item);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Item findById(Long id) {
        Item item = null;  // вне блока try

        registerDriver();
        try {
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement("select * from item where id=?");

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                item = parserResultSet(resultSet);
            }
        } catch (SQLException e) { //создать класс Entity
            throw new RuntimeException(e);
        }
        return item;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List findAll() {
        List<Item> items = new ArrayList<>();

        //Объект запрос который сожержит запрос
        registerDriver();
        try {

            Statement statement = getConnection().createStatement();
            String SQL = "select * from item order by id asc"; //SQL запрос
            //объект в которм лежат строки
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                items.add(parserResultSet(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Item create(Item item) {
        registerDriver();
        try {
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement("insert into item(name, brand, size,color, price)" +
                            " VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getBrand());
            preparedStatement.setString(3, item.getSize());
            preparedStatement.setString(4, item.getColor());
            preparedStatement.setDouble(5, item.getPrice());

            preparedStatement.executeUpdate();

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //запрос на получение послежней добавленной ID
        //присвоить объект 1) genereted ID 2) siq образение к ней 3) Света запрос в БД
        //

    }

    //////////////////////////////////////////////////////////////////////////////////////////

    public Item update(Item item) {

        try {
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement("update item set name=?, brand=?, size=?, color=?, price=? where id =?");

            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getBrand());
            preparedStatement.setString(3, item.getSize());
            preparedStatement.setString(4, item.getColor());
            preparedStatement.setDouble(5, item.getPrice());
            preparedStatement.setLong(6, item.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement =
                    getConnection().prepareStatement("delete from item where id=?");

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Item> searchItemByBrand(String query, String brand) {
        return null;
    }

    @Override
    public List<Item> searchItemBySize(String query, String size) {
        return null;
    }
}


//данные для подключения
//    private static String URL =
//            "jdbc:postgresql://localhost:5432/postgres?useUnicode=true&useJDBCCompliantTimezoneShift=true&Peugeot RifteruseLegacyDatetimeCode=false&serverTimezone=UTC";
//    private static String USERNAME = "postgres";
//    private static String PASSWORD = "postgres";
