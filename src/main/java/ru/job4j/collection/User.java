package ru.job4j.collection;

import java.util.*;

import static java.util.Objects.hash;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && name.equals(user.name) && birthday.equals(user.birthday);
    }

    public static void main(String[] args) {
        ru.job4j.collection.User user1 = new ru.job4j.collection.User("Andrey", 12, new GregorianCalendar(2011, Calendar.APRIL, 12));
        ru.job4j.collection.User user2 = new ru.job4j.collection.User("Andrey", 12, new GregorianCalendar(2011, Calendar.APRIL, 12));
        ru.job4j.collection.User user3 = new ru.job4j.collection.User("Aleksey", 12, new GregorianCalendar(2011, Calendar.APRIL, 12));


        Map<ru.job4j.collection.User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        map.put(user3, new Object());

        for (Map.Entry<ru.job4j.collection.User, Object> pair : map.entrySet()) {
            ru.job4j.collection.User key = pair.getKey();
            Object value = pair.getValue();
            System.out.println(key + ":" + value + " hashCode: " + hash(key.hashCode()));
        }
    }
}
