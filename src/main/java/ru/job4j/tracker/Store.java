package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.util.List;

public interface Store extends AutoCloseable {

    Item add(Item item) throws TrackerSQLException;;

    boolean replace(int id, Item item) throws TrackerSQLException;;

    void delete(int id) throws TrackerSQLException;;

    List<Item> findAll() throws TrackerSQLException;;

    List<Item> findByName(String key) throws TrackerSQLException;;

    Item findById(int id) throws TrackerSQLException;;
}