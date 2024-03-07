package org.practice.streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIPractice {

    //Even number
    //Given a list of integers, find out all the even numbers that exist in the list using Stream functions
    public void evenNumber() {

        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);

        list.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);
    }

    //2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    public void numberStartingWithOne() {

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32,115,113);

        myList.stream()
                .map( n -> String.valueOf(n))
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);
    }

    //3. How to find duplicate elements in a given integers list in java using Stream functions?
    public void duplicateElements() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Set<Integer> set = new HashSet<>();
        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);
    }

    ///4. Given the list of integers, find the first element of the list using Stream functions?
    public void findFirstElement() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    //5. Given a list of integers, find the total number of elements present in the list using Stream functions?
    public void findTheTotalNumberOfElements() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        long count = myList.stream()
                .count();
        count = myList.stream()
                        .mapToLong(n -> 1 ).sum();
        System.out.println(count);
    }

    //6. Given a list of integers, find the maximum value element present in it using Stream functions?
    public void findMaxElement() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        int max = myList.stream()
                .max(Integer::max)
                .get();
        System.out.println(max);
    }

    //7. Given a String, find the first non-repeated character in it using Stream functions?
    public void firstNonRepeated() {
        String input = "Java articles are Awesome";

        Character result = input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        System.out.println(result);
    }

    //8. Given a String, find the first repeated character in it using Stream functions?
    public void firstRepeated() {
        String input = "Java Articles are Awesome";

        Character result = input.chars()
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();

        System.out.println(result);
    }

    //9. Given a list of integers, sort all the values present in it using Stream functions?
    public void sortValues() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .sorted()
                .forEach(System.out::println);
    }

    //10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
    public void sortDescending() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
//                .sorted(Collections.reverseOrder())
                .sorted((a,b) -> b.compareTo(a))
                .forEach(System.out::println);
    }

    //11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public boolean containsDuplicate(int[] nums){
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        Set<Integer> set = new HashSet<>(list);
        return !(set.size() == list.size());
    }

    //12. How will you get the current date and time using Java 8 Date and Time API?
    public void getCurrentDateAndTime(){
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time
    }

    //13. Write a Java 8 program to concatenate two Streams?
    public void concatenateTwoStreams(){
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatenateString = Stream.concat(list1.stream(), list2.stream());
        //System.out.println(concatenateString.collect(Collectors.toList()));

        concatenateString.forEach(str -> System.out.println(str + " "));
    }

    //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
    public void cubeAndFilter(){
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);

        integerList.stream()
                .map(n -> n*n*n)
                .filter(n -> n > 50)
                .forEach(System.out::println);
    }

    //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    public void sortedArrayToStream() {
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr);

        Arrays.stream(arr).forEach(n -> System.out.println(n + " "));
    }

    //16. How to use map to convert object into Uppercase in Java 8?
    public void convertObjectToUppercase(){
        List<String> names = Arrays.asList("aa", "bb");

        names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    public void testNotes(){

        class Notes implements Comparable<Integer> {
            int id;
            String tagName;
            int tagId;

            public Notes (int id, String note, int value){
                this.id = id;
                this.tagName = note;
                this.tagId = value;
            }

            public int getId() {return this.id;}
            public String getTagName() {return this.tagName;}
            public int getTagId() {return this.tagId;}


            @Override
            public int compareTo(Integer tagId) {
                return Integer.compare(this.tagId, tagId);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Notes notes)) return false;
                return tagId == notes.tagId;
            }

            @Override
            public int hashCode() {
                return Objects.hash(id, tagName, tagId);
            }
        }

        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));

        Map<String, Integer> notesRecords = noteLst.stream()
                .sorted(Comparator.comparingInt(Notes::getTagId).reversed())
                        .collect(Collectors.toMap(Notes::getTagName,
                                Notes::getTagId,
                                (oldTagId, newTagId) -> oldTagId,
                                HashMap::new));
        //How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?

                System.out.println("Notes : " + notesRecords);
    }


    public static void main(String[] args) {

        StreamAPIPractice streamAPIPractice = new StreamAPIPractice();

        //https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

        System.out.println("1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions");
        streamAPIPractice.evenNumber();
        System.out.println();

        System.out.println("2.Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
        streamAPIPractice.numberStartingWithOne();
        System.out.println();

        System.out.println("3. How to find duplicate elements in a given integers list in java using Stream functions?");
        streamAPIPractice.duplicateElements();
        System.out.println();

        System.out.println("4. Given the list of integers, find the first element of the list using Stream functions?");
        streamAPIPractice.findFirstElement();
        System.out.println();

        System.out.println("5. Given a list of integers, find the total number of elements present in the list using Stream functions?");
        streamAPIPractice.findTheTotalNumberOfElements();
        System.out.println();

        System.out.println("6. Given a list of integers, find the maximum value element present in it using Stream functions?");
        streamAPIPractice.findMaxElement();
        System.out.println();

        System.out.println("7. Given a String, find the first non-repeated character in it using Stream functions?");
        streamAPIPractice.firstNonRepeated();
        System.out.println();

        System.out.println("8. Given a String, find the first repeated character in it using Stream functions?");
        streamAPIPractice.firstRepeated();
        System.out.println();

        System.out.println("9. Given a list of integers, sort all the values present in it using Stream functions?");
        streamAPIPractice.sortValues();
        System.out.println();

        System.out.println("10. Given a list of integers, sort all the values present in it in descending order using Stream functions?");
        streamAPIPractice.sortDescending();
        System.out.println();

        System.out.println("11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.");
        System.out.println("Input: nums = [1,2,3,1]");
        int[] nums = { 1,2,3,1};
        System.out.println(streamAPIPractice.containsDuplicate(nums));
        int[] nums2 = {1,2,3,4};
        System.out.println("Input: nums = [1,2,3,4]");
        System.out.println(streamAPIPractice.containsDuplicate(nums2));
        System.out.println();

        System.out.println("12. How will you get the current date and time using Java 8 Date and Time API?");
        streamAPIPractice.getCurrentDateAndTime();
        System.out.println();

        System.out.println("13. Write a Java 8 program to concatenate two Streams?");
        streamAPIPractice.concatenateTwoStreams();
        System.out.println();

        System.out.println("14. Java 8 program to perform cube on list elements and filter numbers greater than 50.");
        streamAPIPractice.cubeAndFilter();
        System.out.println();

        System.out.println("15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?");
        streamAPIPractice.sortedArrayToStream();
        System.out.println();

        System.out.println("16. How to use map to convert object into Uppercase in Java 8?");
        streamAPIPractice.convertObjectToUppercase();
        System.out.println();

        System.out.println("17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?");
        streamAPIPractice.testNotes();
        System.out.println();

        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        long size = list.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();
        List<String> listStream = list.stream().skip(1).map(element -> element.substring(0, 3)).sorted().collect(Collectors.toList());
        System.out.println(size);
    }
}
