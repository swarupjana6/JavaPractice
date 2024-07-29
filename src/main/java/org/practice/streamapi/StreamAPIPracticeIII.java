package org.practice.streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPIPracticeIII {

    public static void main(String[] args) {
        StreamAPIPracticeIII prac = new StreamAPIPracticeIII();
        prac.countOccurenceInTheString("ilovejavatechie");
        prac.findAllDuplicateElements("ilovejavatechie");
        prac.findNonRepeatElementFromString("ilovejavatechie");
        int[] input = {5, 9, 11, 2, 8, 21, 1};
        prac.findSecondHighestNumberFromArray(input);
        String[] strArray = {"java", "techie", "springboot", "microservice"};
        prac.findLongestStringFromArray(strArray);
        int[] numbers = {5,9,11,2,8,21,1};
        prac.findElementStartWith(numbers);

    }

    /*
    Java program to count the occurence of each character in the string.
     */
    public void countOccurenceInTheString(String input) {

        String[] result = input.split("");
        Map<String, Long> collect = Arrays.stream(result)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

    /*
    Java program to find all duplicate elements from the string
     */
    public void findAllDuplicateElements(String input) {

        String[] result = input.split("");
        List<String> collect = Arrays.stream(result)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(collect);

    }

    /*
    Java program to find first non-repeat element from a given string
     */
    public void findNonRepeatElementFromString(String input) {
        String[] result = input.split("");
        String collect = Arrays.stream(result)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(collect);

    }

    /*
    Java program to find second highest from the given array
     */
    public void findSecondHighestNumberFromArray(int[] input) {

        Integer collect = Arrays.stream(input)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(collect);
    }

    /*
    java program to find longest string from given array
     */
    public void findLongestStringFromArray(String[] input) {

        Arrays.stream(input)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .ifPresent(System.out::println);
    }

    /*
    java program to find all element from array who start with 1
     */
    public void findElementStartWith(int[] input){

        List<String> list = Arrays.stream(input)
                .boxed()
                .map(i -> i + "")
                .filter(str -> str.startsWith("1"))
                .toList();
        System.out.println(list);
    }
}
