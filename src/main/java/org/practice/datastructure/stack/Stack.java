package org.practice.datastructure.stack;

import org.practice.datastructure.doublelinkedlist.Node;

public class Stack {

    public Node top;
    public int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height++;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        Node node = top;
        if(height == 1){
            top = null;
        } else if(height > 1) {
            top = node.next;
            node.next = null;
        }

        height--;
        return node;
    }
}
