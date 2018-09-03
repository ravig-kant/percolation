
import edu.princeton.cs.algs4.StdRandom;
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
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] itemList;
    private int size = 0;

    public RandomizedQueue() {
        itemList = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if(item == null)
            throw new IllegalArgumentException("Null is invalid");
        
        if (size >= itemList.length) {
            resize();
        }

        itemList[size++] = item;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("No element available");
        }

        int indexToDelete = StdRandom.uniform(size);
        Item replacement = itemList[size - 1];
        itemList[--size] = null;

        if (itemList.length > 4 * size) {
            shrink();
        }

        if (indexToDelete == size) {
            return replacement;
        } else {
            Item itemToDelete = itemList[indexToDelete];
            itemList[indexToDelete] = replacement;
            return itemToDelete;
        }
    }

    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException("No element available");
        }

        int indexToReturnItem = StdRandom.uniform(size);
        return itemList[indexToReturnItem];
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator<>(itemList, size);
    }

    private class QueueIterator<T> implements Iterator {

        private int sz = 0;
        private T[] array;

        public QueueIterator(T[] aList, int i_size) {
            array = (T[]) new Object[sz];
            for (int i = 0; i < sz; i++) {
                array[i] = aList[i];
            }
            sz = i_size;
        }

        @Override
        public boolean hasNext() {
            return sz != 0;
        }

        @Override
        public T next() {
            if (sz == 0) {
                throw new NoSuchElementException("No element available");
            }

            int indexToDelete = StdRandom.uniform(sz);
            T replacement = array[sz - 1];
            array[--sz] = null;

            if (indexToDelete == sz) {
                return replacement;
            } else {
                T itemToDelete = array[indexToDelete];
                array[indexToDelete] = replacement;
                return itemToDelete;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

    private void resize() {
        Item[] newArray = (Item[]) new Object[itemList.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = itemList[i];
        }

        itemList = newArray;
    }

    private void shrink() {
        Item[] newArray = (Item[]) new Object[itemList.length / 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = itemList[i];
        }

        itemList = newArray;
    }

}
