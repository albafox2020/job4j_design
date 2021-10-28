package ru.job4j.collection.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<Object> {

    private SimpleArray<Object> set = new SimpleArray<>();

    @Override
    public boolean add(Object value) {
        if (!contains(value)) {
            set.add(value);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean contains(Object value) {
        for (Object el : set) {
            if (Objects.equals(value, el)) {
                return true;
            }
        }  return false;
    }

    @Override
    public Iterator<Object> iterator() {
        return set.iterator();
    }
}
