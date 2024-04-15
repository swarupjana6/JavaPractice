package org.practice.slidingwindow;

import java.util.*;

/*
https://www.educative.io/courses/grokking-coding-interview-patterns-java/repeated-dna-sequences
https://algo.monster/liteproblems/187

Given a string, s, that represents a DNA subsequence, and a number k, return all the contiguous subsequences (substrings) of length k
 that occur more than once in the string. The order of the returned subsequences does not matter. If no repeated substring is found,
  the function should return an empty set
 */

public class DNASequences {
    public List<String> findRepeatedDnaSequences(String s, int k) {
        // Calculate the number of 10-character substrings in 's'
        int substringLengthLimit = s.length() - k;
        // Create a map to store counts of each DNA sequence
        Map<String, Integer> sequenceCounts = new HashMap<>();
        // List to store the DNA sequences that appear more than once
        List<String> repeatedSequences = new ArrayList<>();

        // Iterate through the string checking for 10-character long substrings
        for (int i = 0; i <= substringLengthLimit; ++i) {
            // Extract the 10-character substring starting at index 'i'
            String currentSubstring = s.substring(i, i + k);
            // Increase the count of the current DNA sequence in the map
            sequenceCounts.put(currentSubstring, sequenceCounts.getOrDefault(currentSubstring, 0) + 1);
            // If this is the second occurrence of the DNA sequence, add it to the answer list
            if (sequenceCounts.get(currentSubstring) == 2) {
                repeatedSequences.add(currentSubstring);
            }
        }
        // Return the list of repeated DNA sequences
        return repeatedSequences;
    }

    public static void main(String[] args) {
        DNASequences dnaSequences = new DNASequences();
        System.out.println(dnaSequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCC", 8));
    }
}
