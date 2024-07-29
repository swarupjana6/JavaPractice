package org.practice.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIPracticeIV {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("anil", 1000);
        map.put("bhavan", 1600);
        map.put("micel", 1600);
        map.put("tom", 1600);
        map.put("ankit", 1200);
        map.put("daniel", 1700);
        map.put("james", 1400);

        String nameByHighestSalary = getNthhighestSalary(2, map).getKey();
        System.out.println(nameByHighestSalary);
        System.out.println(getNthHighestSalarygrp(2, map));


    }

    public static Map.Entry<String, Integer> getNthhighestSalary(int num, Map<String, Integer> map){

        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .toList()
                .get(num - 1);
    }

    public static Map.Entry<Integer, List<String>> getNthHighestSalarygrp(int num, Map<String, Integer> map) {

        return map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                 .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                 .toList()
                .get(num -1);

    }
}
