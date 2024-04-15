package org.practice.datastructure.queue;

public class Queue {

    Node first;
    Node last;
    int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);

        if(length == 0){
            first = newNode;
            last = newNode;
        } else {
            newNode.next = last;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }

        Node temp = first;
        if(length == 1) {
            first = null;
            last = null;
        } else {
            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}
