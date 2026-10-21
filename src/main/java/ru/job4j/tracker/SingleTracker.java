package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private Store tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) throws TrackerSQLException {
        return tracker.add(item);
    }

    public Item findById(int id) throws TrackerSQLException {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) throws TrackerSQLException {
        return tracker.replace(id, item);
    }

    public List<Item> findByName(String key) throws TrackerSQLException {
        return tracker.findByName(key);
    }

    public List<Item> findAll() throws TrackerSQLException {
        return tracker.findAll();
    }

    public void delete(int id) throws TrackerSQLException {
        tracker.delete(id);
    }
}