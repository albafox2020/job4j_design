package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> mem = new HashMap<>();

    @Override
    public void add(T model) {
        mem.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (!indexOf(id)) {
            return false;
        }
        mem.replace(id, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (!indexOf(id)) {
            return false;
        }
        mem.remove(id);
        return true;
    }

    @Override
    public T findById(String id) {
        return mem.get(id);
    }

    public boolean indexOf(String id) {
        return mem.keySet().contains(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemStore memStore = (MemStore) o;
        return mem.equals(memStore.mem);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mem);
    }
}
