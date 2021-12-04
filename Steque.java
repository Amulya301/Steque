/*
 *  File: Steque.java
 *  Author: 
 *  Date: 18th Nov, 2021
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author 
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;
    private int first;
    private int last;
    private static int incapacity = 6;

    /**
     * constructs a steque object.
     */
    public Steque() {
        a = (Item[]) new Object[incapacity];
        n = 0;
        first = 0;
        last = 0;
    }
    
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if(last == size()) resize(2*incapacity);
        if(isEmpty()) a[last] = item;
        else{
        a[last] = item;
        last++;
        }
        n++;
    }
    private void resize(int capacity){
        Item temp[] = (Item[])  new Object[capacity];
        for (int k = 0; k <= n; k++) 
            temp[k] = a[k];
    }


    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */
    public void push(Item item) {
       if(item==null) throw new IllegalArgumentException();
       if(first >= incapacity-1) resize(2*incapacity);
       a[++first] = item;
       n++;
    }
    
    /**
     * pops a least recent item in steque.
     * @return Item object from steque.
     */
    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException();
            Item item = a[n];
            n--;
            return item;

    }
    
    /**
     * checks to see if steque is empty.
     * @return true if steque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return n==0;
    }
    
    /**
     * return the number of elements currently in the steque.
     * @return size as integer.
     */
    public int size() {
        return n;

    }
    
    /**
     * returns an iterator over the elements 
     * stored in steque.
     * 
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();

    }
    public class ArrayIterator implements Iterator<Item> {
        public int i = 0;

        @Override
        public boolean hasNext() {
            return i <=n;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if(hasNext()){
                return a[i++];
        }
            throw new NoSuchElementException();
    }
    }
    public static void main(String[] args){
        Steque<Integer> s = new Steque<Integer>();
        s.enqueue(14);
        System.out.println(s.size());
        s.enqueue(17);
        System.out.println(s.size());
        s.enqueue(20);
        System.out.println(s.size());
        s.push(5);
        System.out.println(s.size());
        s.push(10);
        System.out.println(s.size());
        s.push(15);
        System.out.println(s.size());
        Iterator<Integer> iit = s.iterator();
        System.out.println("steque elements");
        while(iit.hasNext())
        System.out.println(iit.next());
        System.out.println("popped elements");
       while(!s.isEmpty()){
           System.out.println(s.pop());
       }
    }
}
