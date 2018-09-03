/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class QueueUsingStack<T> {

    private Stack<T> first = new Stack<>();
    private Stack<T> second = new Stack<>();
    private int threshold = 1;

    public void enqueue(T obj) {
        if (first.size() == threshold) {
            reverse(first);
        }

        first.push(obj);
    }

    public T dequeue() {
        if (second.size() > 0) {
            return second.pop();
        } else if (first.size() > 0) {
            reverse(first);
            dequeue();
        }
        return null;
    }

    private void reverse(Stack<T> first) {
        threshold = 2 * first.size();
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
    }
}
