package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Andrey", 12, new GregorianCalendar(2011, 03, 12));
        User user2 = new User("Andrey", 12, new GregorianCalendar(2011, 03, 12));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        for (Map.Entry<User, Object> pair : map.entrySet()) {
            User key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(key + ":" + value);
        }
    }
}