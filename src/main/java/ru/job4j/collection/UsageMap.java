package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("vldimir_bakalind@yandex.ru", "Vladimir Bakaldin");
        map.put("vldimir_bakalind@yandex.ru", "Vladimir Ivanov");
        map.put("vldimir_Sidorov@yandex.ru", "Vladimir Sidorov");

        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}