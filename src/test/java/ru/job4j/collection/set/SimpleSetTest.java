package ru.job4j.collection.set;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNonNull4elements() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertTrue(set.add(2));
        assertTrue(set.contains(2));
        assertTrue(set.add(3));
        assertTrue(set.contains(3));
        assertTrue(set.add(4));
        assertTrue(set.contains(4));
        assertFalse(set.add(1));
        assertFalse(set.add(4));
    }

    @Test
    public void whenNullElements() {
        Set<Integer> set = new SimpleSet<>();
        assertFalse(set.contains(null));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

}