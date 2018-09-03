
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ravigu
 */
public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;

    private static class Node<T> {

        private T val;
        private Node<T> prev;
        private Node<T> next;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid value");
        }

        Node<Item> newNode = new Node<>();
        newNode.val = item;
        if (size == 0) {
            first = newNode;
            last = first;
            size++;
            return;
        }
        newNode.next = first;
        first.prev = newNode;
        first = newNode;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Invalid value");
        }

        Node<Item> newNode = new Node<>();
        newNode.val = item;
        if (size == 0) {
            first = last = newNode;
            size++;
            return;
        }
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to remove");
        }

        Node<Item> toBeDeleted = first;
        first = first.next;

        if (first != null) {
            first.prev = null;
        }

        size--;
        return toBeDeleted.val;

    }

    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("Nothing to remove");
        }

        Node<Item> toBeDeleted = last;
        last = last.prev;

        if (last != null) {
            last.next = null;
        }

        size--;
        return toBeDeleted.val;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int sz = size;
            private Node<Item> frst = first;

            @Override
            public boolean hasNext() {
                return sz != 0;
            }

            @Override
            public Item next() {
                if (sz == 0) {
                    throw new NoSuchElementException("Nothing to return");
                }

                Node<Item> toBeReturned = frst;
                frst = frst.next;
                sz--;
                return toBeReturned.val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

}
