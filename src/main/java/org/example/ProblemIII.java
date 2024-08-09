package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemIII {

    static class Employee {

        int id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static boolean checkForAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < c1.length; i++) {
            sum1 += c1[i];
            sum2 += c2[i];
        }

        return sum1 == sum2;
        //return s1.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().equals(s2);
    }

    public static void sortMapBasedOnValue(Map<Integer, Employee> employee) {

        LinkedHashMap<Integer, Employee> collect = employee.entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue().name))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldV, newV) -> oldV, LinkedHashMap::new));

        System.out.println(collect);


    }

    public static void main(String[] args) {

        Map<Integer, Employee> employeeMap = new HashMap<>();

        employeeMap.put(3, new Employee(1, "Anusree"));
        employeeMap.put(4, new Employee(2, "Swarup"));
        employeeMap.put(5, new Employee(3, "Mayur"));
        employeeMap.put(6, new Employee(4, "Tapan"));

        sortMapBasedOnValue(employeeMap);

    }
}
