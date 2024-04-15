package org.practice.datastructure.queue;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public void enqueue(int value){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(value);
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue(){
        if(stack1.isEmpty()) return null;

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return value;
    }
}
