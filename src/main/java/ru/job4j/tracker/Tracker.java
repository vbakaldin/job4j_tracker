package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.set(index, item);
        }
        return result;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getName().equals(key)) {
                result.add(items.get(index));
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public void delete(int id) {
        items.remove(findById(id));
    }
}