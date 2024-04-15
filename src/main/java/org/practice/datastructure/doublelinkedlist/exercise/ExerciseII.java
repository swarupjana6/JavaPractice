package org.practice.datastructure.doublelinkedlist.exercise;

import org.practice.datastructure.doublelinkedlist.DoublyLinkedList;
import org.practice.datastructure.doublelinkedlist.Node;


/*
DLL: Reverse ( ** Interview Question)
Implement a method called reverse() that reverses the order of the nodes in the list.

This method should reverse the order of the nodes in the list by manipulating the pointers of each node, not by swapping the values within the nodes.


Method Signature:

public void reverse()


Output:

No explicit output is returned. However, the method should modify the doubly linked list such that the order of the nodes is reversed.


Constraints:

The doubly linked list may be empty or have one or more nodes.


Example:

Consider the following doubly linked list:

Head: 1
Tail: 5
Length: 5

Doubly Linked List:
1 <-> 2 <-> 3 <-> 4 <-> 5


After calling reverse(), the list should be:

Head: 5
Tail: 1
Length: 5

Doubly Linked List:
5 <-> 4 <-> 3 <-> 2 <-> 1
 */
public class ExerciseII extends DoublyLinkedList {
    public ExerciseII(int value) {
        super(value);
    }

    public void reverse(){
        Node current = head;
        Node temp = null;

        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head= tail;
        tail = temp;
    }

}
