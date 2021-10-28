package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = (String) array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAdd4elements() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        String rsl = (String) array.get(3);
        assertThat(rsl, is("fourth"));
    }

    @Test
    public void whenAdd9elements() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        array.add("fifth");
        array.add("sixth");
        array.add("seventh");
        array.add("eighth");
        array.add("ninth");
        String rsl = (String) array.get(8);
        assertThat(rsl, is("ninth"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = (String) array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        Iterator<Object> it = array.iterator();
        array.add("second");
        it.next();
    }
}