package org.practice.datastructure.doublelinkedlist;

public class DoublyLinkedList {

    public Node head;
    public Node tail;
    public int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;

        this.length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

        if (length == 0) return null;

        Node last = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node prev = tail.prev;
            last.prev = null;
            prev.next = null;
            tail = prev;
        }
        length--;

        return last;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            newNode.next = temp;
            temp.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {

        if (length == 0) return null;
        Node first = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node tmp = first.next;
            tmp.prev = null;
            first.next = null;
            head = tmp;
        }
        length--;
        return first;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        if (length == 1) {
            return head;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node newNode = new Node(value);
            Node before = get(index - 1);
            Node after = before.next;

            newNode.prev = before;
            newNode.next = after;
            after.prev = newNode;
            before.next = newNode;

            length++;
        }

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;

        length--;
        return temp;
    }


}
