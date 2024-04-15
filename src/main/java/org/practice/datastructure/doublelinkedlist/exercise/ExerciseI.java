package org.practice.datastructure.doublelinkedlist.exercise;

import org.practice.datastructure.doublelinkedlist.DoublyLinkedList;
import org.practice.datastructure.doublelinkedlist.Node;

/*
DLL: Swap First and Last ( ** Interview Question)
Swap First and Last Node Values in a Doubly Linked List.

Given a doubly linked list, write a method called swapFirstLast() that swaps the values of the first and last nodes in the list.

If the length of the list is less than 2, the method should not perform any operation.


Function Signature:

public void swapFirstLast()


Input:

The method is part of the DoublyLinkedList class, which has a head and a tail pointer, as well as a length attribute.



Output:

No explicit output is returned. However, the method should modify the doubly linked list such that the values of the first and last nodes are swapped.



Constraints:

The doubly linked list may be empty, have only one node, or have two or more nodes.



Example:

Consider the following doubly linked list:

Head: 1
Tail: 5
Length: 5

Doubly Linked List:
1 <-> 2 <-> 3 <-> 4 <-> 5


After calling swapFirstLast(), the list should be:

Head: 5
Tail: 1
Length: 5

Doubly Linked List:
5 <-> 2 <-> 3 <-> 4 <-> 1


Note that the pointers to the nodes themselves are not swapped - only their values are exchanged.


 */
public class ExerciseI extends DoublyLinkedList {
    public ExerciseI(int value) {
        super(value);
    }

    public void swapFirstLast(){
        if(length < 2){
            return;

        }

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;

    }

}
