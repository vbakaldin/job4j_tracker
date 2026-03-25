package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
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
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int newSize = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                result[newSize] = items[index];
                newSize++;
            }
        }
        result = Arrays.copyOf(result, newSize);
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index > -1) {
            System.arraycopy(items, index, items, index + 1, size);
            items[size - 1] = null;
            size--;
        }
    }
}