package org.practice.slidingwindow;

import java.util.Arrays;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/minimum-window-subsequence
https://algo.monster/liteproblems/727

Given two strings, str1 and str2, find the shortest substring in str1 such that str2 is a subsequence of that substring.

A substring is defined as a contiguous sequence of characters within a string. A subsequence is a sequence that can be derived from another sequence by deleting zero or more elements without changing the order of the remaining elements.

Let’s say you have the following two strings:

str1 = “abbcb”

str2 = “ac”

In this example, “abbc” is a substring of str1, from which we can derive str2 simply by deleting both the instances of the character b
. Therefore, str2 is a subsequence of this substring. Since this substring is the shortest among all the substrings in which str2 is
present as a subsequence, the function should return this substring, that is, “abbc”.


 */
public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();

        // table to store the start index of the window in s1 that ends at i and has s2.charAt(j)
        int[][] windowStartAtIndex = new int[s1Length + 1][s2Length + 1];

        // initialize the table with default values
        for (int i = 0; i <= s1Length; i++) {
            Arrays.fill(windowStartAtIndex[i], -1);
        }

        // fill the table based on the input strings s1 and s2
        for (int i = 1; i <= s1Length; ++i) {
            for (int j = 1; j <= s2Length; ++j) {
                // On matching characters, update the table with the start index of the current window
                // If it's the first character of s2, the start is the current index in s1
                // Otherwise, it's the index stored in the previous position of the table
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    windowStartAtIndex[i][j] = (j == 1) ? i : windowStartAtIndex[i - 1][j - 1];
                } else {
                    // If there's no match, inherit the value from the previous index of s1
                    windowStartAtIndex[i][j] = windowStartAtIndex[i - 1][j];
                }
            }
        }

        // position and length of the minimum window
        int startPosition = 0, minLength = s1Length + 1;

        // find the smallest window in s1 that has all characters of s2
        for (int i = 1; i <= s1Length; ++i) {
            // check if the current position is the end of a valid window, i.e., it matches last character of s2
            if (s1.charAt(i - 1) == s2.charAt(s2Length - 1) && windowStartAtIndex[i][s2Length] > 0) {
                int j = windowStartAtIndex[i][s2Length] - 1; // the window's start position in s1
                int currentLength = i - j; // the length of the current window
                // update minimum length window, if the current window is smaller
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startPosition = j;
                }
            }
        }

        // if no valid window is found, return an empty string
        // otherwise, return the substring from startPosition with minLength
        return minLength > s1Length ? "" : s1.substring(startPosition, startPosition + minLength);
    }
}
