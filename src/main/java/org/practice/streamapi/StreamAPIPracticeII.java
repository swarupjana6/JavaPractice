package org.practice.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamAPIPracticeII {

    //https://www.w3resource.com/java-exercises/stream/index.php

    // 1. Write a Java program to calculate the average of a list of integers using streams.
    public void averageOfIntList() {

        List<Integer> nums = Arrays.asList(2, 4, 6, 11, 56, 98, 45);
        double asDouble = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);

        System.out.println("Average of list element : - " + asDouble);
    }

    //2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.
    public void convertStringToUpperCase() {
        List<String> strs = Arrays.asList("Java", "8", "explained", "through", "programs");
        strs.stream()
                .map(String::toUpperCase)
                .toList()
                .forEach(System.out::println);
    }

    //3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
    public void sumOfAllOddAndEven() {

        List<Integer> nums = Arrays.asList(2, 4, 6, 11, 56, 98, 45, 23, 47, 65, 79, 22, 34);

        int evenSum = nums.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Even :- " + evenSum);

        int oddSum = nums.stream()
                .filter(n -> n % 2 > 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Even :- " + oddSum);

        Map<Boolean, List<Integer>> collect = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.toList()));

        int evenPartSum = collect.get(true)
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
        int oddPartSum = collect.get(false)
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Even :- " + evenPartSum);
        System.out.println("Sum of Even :- " + oddPartSum);


    }

    //4. Write a Java program to remove all duplicate elements from a list using streams.
    public void removeDuplicate() {
        List<Integer> nums = Arrays.asList(2, 4, 6, 11, 56, 56, 45, 11, 47, 6, 79, 22, 34);

        List<Integer> distinctnum = nums.stream()
                .distinct()
                .toList();

        System.out.println("Distinct nums :- " + distinctnum);

    }

    //5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    public void countStringStartWithSpecificLetter(String searchStr) {
        List<String> strs = Arrays.asList("Java", "8", "explained", "through", "programs");
        long count = strs.stream()
                .filter(str -> str.startsWith(searchStr))
                .count();

        System.out.println("Result of count of SearchString :- " + count);
    }

    //6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    public void sortStr(){
        List<String> strs = Arrays.asList("Java", "8", "explained", "through", "programs");
        List<String> ascStrs = strs.stream()
                .sorted()
                .toList();

        List<String> desStrs = strs.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Ascending order :- " + ascStrs);
        System.out.println("Ascending order :- " + desStrs);

    }

    //7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
    public void findMaxAndMin() {
        List<Integer> nums = Arrays.asList(2, 4, 6, 11, 56, 56, 45, 11, 47, 6, 79, 22, 34);

        int max = nums.stream().max(Integer::compare).orElse(null);
        int min = nums.stream().min(Integer::compare).orElse(null);

        System.out.println("Max : - " + max);
        System.out.println("Min : - " + min);
    }

    //8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.
    public void findSecondSmallestAndLargestElement() {
        List<Integer> nums = Arrays.asList(2, 4, 6, 11, 56, 56, 45, 11, 47, 6, 79, 22, 34);

        int a = nums.stream().sorted().skip(1).findFirst().orElse(-1);
        int b = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(-1);

        System.out.println("Second Smallest Num : - " + a);
        System.out.println("Second Largert num : - " + b);

    }

    public static void main(String[] args) {
        StreamAPIPracticeII stream = new StreamAPIPracticeII();

        System.out.println("1. Write a Java program to calculate the average of a list of integers using streams.");
        stream.averageOfIntList();

        System.out.println("2. Write a Java program to convert a list of strings to uppercase or lowercase using streams.");
        stream.convertStringToUpperCase();

        System.out.println("3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.");
        stream.sumOfAllOddAndEven();

        System.out.println("4. Write a Java program to remove all duplicate elements from a list using streams.");
        stream.removeDuplicate();

        System.out.println("5. Write a Java program to count the number of strings in a list that start with a specific letter using streams.");
        stream.countStringStartWithSpecificLetter("exp");

        System.out.println("6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.");
        stream.sortStr();

        System.out.println("7. Write a Java program to find the maximum and minimum values in a list of integers using streams.");
        stream.findMaxAndMin();

        System.out.println("8. Write a Java program to find the second smallest and largest elements in a list of integers using streams.");
        stream.findSecondSmallestAndLargestElement();

    }
}
