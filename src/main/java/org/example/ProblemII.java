package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProblemII {

    /*
            3)Sort the List according to the below priorities
           (i)Number of repeatations
           (ii)Value of the digits
                input = {6,3,2,5,3,6,3,7}
                output ={3,3,3,6,6,2,5,7}
     */

    public static void sortNumberBasedonRepitation() {

        List<Integer> input = Arrays.asList(6, 3, 2, 5, 3, 6, 3, 7);
        List<Integer> result = new ArrayList<>();

        /*elements.stream()
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue(), Comparator.reverseOrder()))
                .forEachOrdered(e -> {
                    for(int i =0; i < e.getValue(); i++){
                       result.add(e.getKey());
                    }
                });*/

        Map<Integer, Long> frequency = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        input.stream()
                .sorted(Comparator.comparing((Integer x) -> frequency.get(x))
                        .reversed()
                        .thenComparing(Integer::intValue))
                .toList()
                .forEach(System.out::println);

        System.out.println(result);

    }

    /*
    Employ - id, name, salary, squad_id
    Sqaud - id, name, squad_leadname

    employ_name, emp_salary, empl_SquadName
    salary should be secound highest


    select emp.Name, emp.salary, squad.Name from employee emp
    inner join into Squad squad on emp.squad_id = squad.id
    where emp.salary = (select salary from employee where row = 2 order by salary desc)

     */


    /*

    [6:00 PM] Muhammad Roshan V R
Print all Permutations of given String

Input: S = “ABC”

Output: “ABC”, “ACB”, “BAC”, “BCA”, “CBA”, “CAB”

     */

    public static void printPermutn(String str, String ans) {

        // If string is empty
        if (str.isEmpty()) {
            System.out.print(ans + " ");
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recursive call
            printPermutn(ros, ans + ch);
        }
    }

    public static void main(String[] args) {

        sortNumberBasedonRepitation();
        printPermutn("ABC", "");


    }
}
