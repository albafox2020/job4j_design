package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, null);
        node.next = head;
        head = node;
        size++;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            T element = head.value;
            Node<T> nextHead = head.next;
            head.value = null;
            head.next = null;
            head = nextHead;
            size--;
            return element;
        }
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean revert() {
        if (isEmpty() || getSize() == 1) {
            return false;
        } else {
            Node<T> nodeNew = head.next;
            head.next = null;
            while (nodeNew != null) {
                Node<T> node = nodeNew.next;
                nodeNew.next = head;
                head = nodeNew;
                nodeNew = node;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
