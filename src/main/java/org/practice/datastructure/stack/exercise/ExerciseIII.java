package org.practice.datastructure.stack.exercise;

import java.util.Stack;

/*
The sortStack method takes a single argument, a Stack object.  The method should sort the elements in the stack in ascending order (the lowest value will be at the top of the stack) using only one additional stack.  The function should use the pop, push, peek, and isEmpty methods of the Stack object.

This will use the Stack class we created in these coding exercises:

To sort the stack, you should create a new, empty stack to hold the sorted elements.  Then, while the original stack is not empty, you should remove the top element from the original stack and compare it to the top element of the sorted stack.  If the top element of the sorted stack is greater than the current element, you should move the top element of the sorted stack back to the original stack until the current element is in the correct position.  Finally, you should add the current element to the sorted stack.

Once all the elements have been sorted, you should copy the sorted elements from the sorted stack to the original stack in the correct order.

Overall, the function should have a time complexity of O(n^2), where n is the number of elements in the original stack, due to the nested loops used to compare the elements.  However, the function should only use one additional stack, which could be useful in situations where memory is limited.
 */
public class ExerciseIII {

    public static  void sortStack(Stack<Integer> number) {
        Stack<Integer> auxliary = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        if(number.isEmpty()){
            return;
        }

        auxliary.push(number.pop());
        while (!number.isEmpty()) {
            while (!auxliary.isEmpty() && number.peek() < auxliary.peek()) {
                temp.push(auxliary.pop());
            }
            auxliary.push(number.pop());
            while (!temp.isEmpty()) {
                auxliary.push(temp.pop());
            }
        }

        while (!auxliary.isEmpty()) {
            number.push(auxliary.pop());
        }
    }
}
