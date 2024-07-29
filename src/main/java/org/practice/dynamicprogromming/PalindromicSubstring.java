package org.practice.dynamicprogromming;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/palindromic-substrings


Given a string, s, return the number of palindromic substrings contained in it.
A substring is a contiguous sequence of characters in a string.
A palindrome is a phrase, word, or sequence that reads the same forward and backward.
 */
public class PalindromicSubstring {

    public int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); ++i) {
            ans += extendPalindromes(s, i, i);
            ans += extendPalindromes(s, i, i + 1);
        }

        return ans;
    }

    private int extendPalindromes(final String s, int l, int r) {
        int count = 0;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            ++count;
            --l;
            ++r;
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        System.out.println(palindromicSubstring.countSubstrings("lever"));
    }

}
