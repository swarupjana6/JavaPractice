package org.practice.datastructure.linklist;

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);

        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        Node temp = tail;

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            temp.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {

        Node prev = null;
        Node current = head;

        if (length == 0) return null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        tail = prev;
        prev.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return current;
    }

    public void prepend(int value) {

        Node newNode = new Node(value);
        Node temp = head;

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head = newNode;
            newNode.next = temp;
        }

        length++;
    }

    public Node removeFirst() {
        Node current = head;
        Node pre = head;

        if (length == 0) return null;

        current = current.next;
        head = current;
        pre.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return pre;
    }

    public Node get(int index) {

        Node current = head;

        if (index < 0 || index >= length) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    public boolean set(int index, int value) {
        Node current = head;

        if (index < 0 || index >= length) {
            return false;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;

        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node pre = get(index - 1);
            Node current = get(index);
            Node newNode = new Node(value);

            pre.next = newNode;
            newNode.next = current;
        }
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node pre = head;
            Node current = head;

            for (int i = 0; i < index; i++) {
                pre = current;
                current = current.next;
            }

            pre.next = current.next;
            current.next = null;
            length--;
            return current;
        }
    }

    public void reverse() {

        if (length < 1) {
            return;
        }
        Node temp = head;
        head = tail;
        tail = temp;

        Node before = null;
        Node after = head.next;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;

            before = temp;
            temp = after;
        }
    }

}
