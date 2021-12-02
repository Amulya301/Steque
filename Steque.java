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
    private Item[] i;
    private int n;
    private  int incapacity=10;
    private int first;
    private int last;

    /**
     * constructs a steque object.
     */
    public Steque() {
        i = (Item[]) new Object[incapacity];
        n = 0;
        first=0;
        last=0;

    }
    
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */
    public void enqueue(Item item) {
        if(item==null) throw new IllegalArgumentException();
        if (n == i.length) resize(2*i.length); 
       last = (last+1)%incapacity;
       i[last++] = item;
       n++;
    }
    
    
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int j = 0; j < i.length; j++) {
            copy[j] = i[j];
            i = copy;
        }
    }


    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */
    public void push(Item item) {
        if(item==null) throw new IllegalArgumentException();
        if(n==i.length) resize(2*i.length);
        i[first] = item;
        n++;
    }
    
    /**
     * pops a least recent item in steque.
     * @return Item object from steque.
     */
    public Item pop() {
        if(isEmpty()) throw new NoSuchElementException();
        Item item = i[n-1];
        i[n-1] = null;
        n--;
        if(n>0 && n==i.length/4) resize(i.length/2);
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
    public class ArrayIterator implements Iterator<Item>{
        private int j;
        private int size;
        public ArrayIterator() {
            j = first;
            size=n;
        }

        public boolean hasNext() {
            return j!=0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            size--;
            return i[j++];
            //Item item = i[(j + first) % i.length];
            // j++;
            // return item;
            //return i[j--];
        }
    }
    public static void main(String[] args){
        Steque<Integer> s = new Steque<Integer>();
        s.enqueue(14);
        s.enqueue(17);
        s.enqueue(20);
        s.push(5);
        s.push(10);
        s.push(15);
        Iterator<Integer> iit = s.iterator();
        System.out.println("steque elements");
        while(iit.hasNext()){
            System.out.println(iit.next());
        }
        System.out.println("popped elements");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
