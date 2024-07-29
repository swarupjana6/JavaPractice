package org.practice.fastandslowpointer;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/middle-of-the-linked-list

 */
public class MiddleLinkedList {


    public static LinkedListNode middleNode(LinkedListNode head) {

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        LinkedList input = new LinkedList();
        input.createLinkedList(arr);

        System.out.println(MiddleLinkedList.middleNode(input.head).data);
    }
}
