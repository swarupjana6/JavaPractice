package org.practice.datastructure.linkedlist.exercise;

import org.practice.datastructure.linkedlist.LinkedList;
import org.practice.datastructure.linkedlist.Node;

/*
LL: Find Kth Node From End ( ** Interview Question)
Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.

Method signature:

public Node findKthFromEnd(int k)


Example:

LinkedList myList = new LinkedList(1);
myList.append(2);
myList.append(3);
myList.append(4);
myList.append(5);

Node result = myList.findKthFromEnd(2); // Output: Node with value 4

result = myList.findKthFromEnd(5); // Output: Node with value 1

result = myList.findKthFromEnd(6); // Output: null


Note:

In this problem, you should use the two-pointer technique to efficiently find the k-th node from the end of the linked list.


 */
public class ExerciseIII extends LinkedList {
    public ExerciseIII(int value) {
        super(value);
    }

    public Node findKthFromEnd(int k) {

        Node slow = head;
        Node fast = head;

        if (k < 0) return null;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
