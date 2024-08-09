/*

Implement a Custom Queue in java with following operations

enqueue() -> adds element to the back of the queue e.g. queue.enqueue(1); queue.enqueue(“A”)
dequeue() -> remove and return element from the front of the queue
peek() -> return element from front of the queue without removing it.
print() -> print all the elements in the queue
Note:- Can’t use Arrays, ArrayList or LinkedList directly. Use own implementation of the LinkedList using custom Node class

    ||  -> head
    ||
    ||  - tail
 */
package org.example;

public class Main {
    public static void main(String[] args) {

        CustomQueue<Integer> queue = new CustomQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
        System.out.println("Peek -> " + queue.peek());
        queue.print();
        System.out.println("Dequeue -> " + queue.dequeue());
        queue.print();
    }
}

class Node<E> {

    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }
}

class CustomQueue<E> {

    Node<E> head;
    Node<E> tail;
    int length;

    public CustomQueue() {
    }
    public CustomQueue(E value) {
        enqueue(value);
    }

    public void enqueue(E value) {

        Node<E> newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node<E> temp = tail;
            temp.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public E dequeue() {

        Node<E> element = null;
        if (length == 0)
            return null;

        element = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = element.next;
            element.next = null;
        }
        length--;

        return element.value;
    }

    public E peek() {
        if (length == 0)
            return null;

        return head.value;
    }

    public void print() {
        if (length == 0)
            System.out.println("Queue is empty");

        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}