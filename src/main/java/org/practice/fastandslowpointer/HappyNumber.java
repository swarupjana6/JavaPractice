package org.practice.fastandslowpointer;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/happy-number
https://algo.monster/liteproblems/202

Write an algorithm to determine if a number 𝑛 is a happy number.

We use the following process to check if a given number is a happy number:

Starting with the given number n, replace the number with the sum of the squares of its digits.
Repeat the process until:
The number equals
1 which will depict that the given number n is a happy number.
The number enters a cycle, which will depict that the given number n is not a happy number.
 */
public class HappyNumber {
    public boolean isHappyNumber(int n) {

        // Initialize slow and fast pointers to detect cycle.
        int slowRunner = n;
        int fastRunner = getNext(n);

        // Loop until the two pointers meet or we find a happy number.
        while (slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);       // Move slow pointer by one step.
            fastRunner = getNext(getNext(fastRunner)); // Move fast pointer by two steps.
        }

        // If the slow runner reaches 1, then the number is happy.
        // If the pointers meet and it's not at 1, then a cycle is detected and the number is not happy.
        return slowRunner == 1;
    }

    // Helper method to calculate the next number in the sequence.
    private int getNext(int number) {
        int sumOfSquares = 0;
        while (number > 0) {
            int digit = number % 10;               // Extract the last digit of the current number.
            sumOfSquares += digit * digit;         // Add the square of the extracted digit to the sum.
            number /= 10;                          // Remove the last digit from the current number.
        }
        return sumOfSquares;
    }
}
