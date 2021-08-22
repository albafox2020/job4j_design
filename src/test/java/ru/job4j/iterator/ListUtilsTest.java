package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfterLast2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));
    }

    @Test
    public void whenAddBefore2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addBefore(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 3, 2), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.removeIf(input, x -> x > 1);
        assertThat(Arrays.asList(1), Is.is(input));
    }

    @Test
    public void whenRemoveIf2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 5, 2, 4, 5, 8));
        ListUtils.removeIf(input, x -> x > 4);
        assertThat(Arrays.asList(1, 2, 4), Is.is(input));
    }

    @Test
    public void whenReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.replaceIf(input, x -> x > 1, 4);
        assertThat(Arrays.asList(1, 4), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> element = new ArrayList<>(Arrays.asList(1));
        ListUtils.removeAll(input, element);
        assertThat(Arrays.asList(3), Is.is(input));
    }

    @Test
    public void whenRemoveAll2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 4, 7, 8, 20));
        List<Integer> element = new ArrayList<>(Arrays.asList(1, 6, 8, 9, 20));
        ListUtils.removeAll(input, element);
        assertThat(Arrays.asList(3, 4, 7), Is.is(input));
    }

}