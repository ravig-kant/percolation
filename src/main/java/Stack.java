/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravigu
 */
public class Stack<T> {
    
    private Node first = null;
    private int size = 0;
    
    private class Node{
        T val;
        Node next;
    }
    
    public void push(T obj){
        Node item = new Node();
        item.val = obj;
        item.next = first;
        first = item;    
        size++;
    }
    
    public boolean isEmpty(){
        return first==null;
    }
    
    public T pop(){
        if(isEmpty())
            return null;
        
        T val = first.val;
        first = first.next;
        size--;
        return val;
    }
    
    public int size(){
        return size;
    }
}
