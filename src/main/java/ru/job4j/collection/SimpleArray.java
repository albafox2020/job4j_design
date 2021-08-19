package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    transient Object[] container = new Object[3];
    private int size = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length*2);
        }
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[index++];
            }
        };
    }
}
