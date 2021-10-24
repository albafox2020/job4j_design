package ru.job4j.collection;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<Object> {
    transient Object[] container = new Object[3];
    private int size = 0;
    private int modCount = 0;

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<Object> iterator() {

        return new Iterator<>() {
            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return container[index++];
            }
        };
    }
}
