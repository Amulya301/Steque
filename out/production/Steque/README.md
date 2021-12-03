### Steque
> A stack-ended queue or steque is a data type that supports push, pop, and enqueue. Knuth calls it an output-restricted deque.

> Write a generic data type for a steque. The goal of this assignment is to implement elementary data structures using arrays and linked lists and to introduce you to generics and iterators.

### Corner cases.  

> Throw the specified exception for the following corner cases:
* Throw an IllegalArgumentException if the client calls either enqueue() or push() with a null argument.
* Throw a java.util.NoSuchElementException if the client calls pop() when the steque is empty.
* Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
* Throw an UnsupportedOperationException if the client calls the remove() method in the iterator.

### Unit testing  
> Your main() method must call directly every public constructor and method to help verify that they work as prescribed (e.g., by printing results to standard output).

### The Report
> Write a report which must completely denote the differences between the implementation of Steque with Linkedlists vs Arrays. The report should majorly covers the following differences:

* Size (Storage allocation of Size in Linkedlists vs Arrays)
* Memory (When memory allocation will be created in Linkedlists vs Arrays)
* Memory efficiency (For the same number of elements, which uses less memory in Linkedlists vs Arrays)
* Execution time (Adding, Removing, and Accessing items in Linkedlists vs Arrays)
