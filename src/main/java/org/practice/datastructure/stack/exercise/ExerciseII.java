package org.practice.datastructure.stack.exercise;

import java.util.Stack;

/*
Stack: Parentheses Balanced ( ** Interview Question)
Check to see if a string of parentheses is balanced or not.

By "balanced," we mean that for every open parenthesis, there is a matching closing parenthesis in the correct order. For example, the string "((()))" has three pairs of balanced parentheses, so it is a balanced string. On the other hand, the string "(()))" has an imbalance, as the last two parentheses do not match, so it is not balanced.  Also, the string ")(" is not balanced because the close parenthesis needs to follow the open parenthesis.


Your program should take a string of parentheses as input and return true if it is balanced, or false if it is not.  In order to solve this problem, use a Stack data structure.

Method name: isBalancedParentheses

Return type: boolean

This method will be written in the same class as the main method so it will be static.  For more information on static methods click on "Hints."
 */
public class ExerciseII {

    public boolean isBalancedParentheses(String testStr){

        Stack<Character> openStack = new Stack<>();

        char[] charStr = testStr.toCharArray();

        if(charStr.length % 2 != 0 ){
            return false;
        }

        for (char ch : charStr){

            if(ch == '('){
                openStack.push(ch);
            } else if (ch ==  ')' && !openStack.isEmpty() && openStack.pop() != '('){
                return false;
            }
        }

        return true;
    }
}
