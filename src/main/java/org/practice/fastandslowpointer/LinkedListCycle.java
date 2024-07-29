package org.practice.fastandslowpointer;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/linked-list-cycle
https://algo.monster/problems/linked_list_cycle

Check whether or not a linked list contains a cycle. If a cycle exists, return TRUE.
Otherwise, return FALSE. The cycle means that at least one node can be reached again by traversing the next pointer.
 */
public class LinkedListCycle {

    public static boolean detectCycle(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast.data == slow.data)
                return true;
        }
        return false;
    }
}
