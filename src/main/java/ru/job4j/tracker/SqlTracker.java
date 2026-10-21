package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() throws TrackerSQLException {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() throws TrackerSQLException {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new TrackerSQLException("Не удалось подключиться к базе данных трекера.", e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) throws TrackerSQLException {
        try (var statement = connection.prepareStatement(
                "INSERT INTO items (name, created) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось добавить заявку: " + item.getName(), e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws TrackerSQLException {
        boolean result;
        try (var statement = connection.prepareStatement(
                "UPDATE items SET name = ?, created = ? WHERE id = ?"
        )) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
            if (result) {
                item.setId(id);
            }
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось заменить заявку с id: " + id, e);
        }
        return result;
    }

    @Override
    public void delete(int id) throws TrackerSQLException {
        try (var statement = connection.prepareStatement(
                "DELETE FROM items WHERE id = ?"
        )) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось удалить заявку с id: " + id, e);
        }
    }

    @Override
    public List<Item> findAll() throws TrackerSQLException {
        List<Item> result = new ArrayList<>();
        try (var statement = connection.prepareStatement(
                "SELECT id, name, created FROM items ORDER BY id"
        ); var resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.add(createItem(resultSet));
            }
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось получить список заявок.", e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) throws TrackerSQLException {
        List<Item> result = new ArrayList<>();
        try (var statement = connection.prepareStatement(
                "SELECT id, name, created FROM items WHERE name = ? ORDER BY id"
        )) {
            statement.setString(1, key);
            try (var resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(createItem(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось найти заявки с именем: " + key, e);
        }
        return result;
    }

    @Override
    public Item findById(int id) throws TrackerSQLException {
        Item result = null;
        try (var statement = connection.prepareStatement(
                "SELECT id, name, created FROM items WHERE id = ?"
        )) {
            statement.setInt(1, id);
            try (var resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    result = createItem(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new TrackerSQLException("Не удалось найти заявку с id: " + id, e);
        }
        return result;
    }

    private Item createItem(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime());
    }
}