package org.practice.datastructure.stack.exercise;

import org.practice.datastructure.stack.Node;
import org.practice.datastructure.stack.Stack;

/*
Return a new String with the letters in reverse order.

This method will be written in the same class as the main method so it will be static.  For more information on static methods click on "Hints."

This will use the Stack class we created in the last two coding exercises:
 */
public class ExerciseI extends Stack {

    static class Node {
        public char value;
        public org.practice.datastructure.stack.Node next;

        public Node(char value) {
            this.value = value;
        }
    }


    public ExerciseI(int value) {
        super(value);
    }

    public static String reverseString(String string) {

        java.util.Stack<Character> stack = new java.util.Stack<>();
        String reversedString = "";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;
    }
}
