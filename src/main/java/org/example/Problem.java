package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem :- Check if the array is balanced array or not.
Description:- A balanced array is defined to be an array where for every value n in the array, -n also is in the array.

Example 1:- {-2, 3, 2, -3} is a balanced array.
Example 2:- {1,1,-1,-1} is a balanced array.
Example 3:- {1,1,-1} is a NOT balanced array.
Example 4:- {-2, 3, 2, -3, 0, 5,-5} is a balanced array.
Example 5:- {1, 2, -3} is NOT a balanced array.
Example 6:- {-3,-2, -3, -2, 4, 1, 4, 1 , 3, 2, -4, -1} is NOT a balanced array

Note:-
Zeroes can be ignored.
There can be duplicates in the array. Every duplicate n needs to have -n
 */
public class Problem  {

    public static void main(String[] args) {
        Problem problem = new Problem();
        int[] input = {1,1,-1};
        System.out.println(problem.isBalanceArray(input));
//        System.out.println(problem.isBalancedArray(input));

    }

    public boolean isBalanceArray(int[] input){
        boolean isBalanced = true;

        Map<Integer, Integer> characterCount = new HashMap<>();
        for(int index = 0; index < input.length; index ++){
            int value = input[index];
            if(value == 0)
                continue;
            if(characterCount.containsKey(value*-1)){
                characterCount.put(value*-1, characterCount.get(value*-1)-1);
            } else {
                characterCount.put(value, characterCount.getOrDefault(value,0)+1);
            }
        }

//        for(Integer nums: characterCount.keySet()){
//            if(characterCount.get(nums) > 0 )
//                return false;
//        }
        System.out.println(characterCount);
        return !characterCount.values().stream().anyMatch(n -> n > 0);

//        return isBalanced;
    }

    public boolean isBalancedArray(int[] input){

        return Arrays.stream(input).sum() == 0;
    }
}

/*
Given following single employee Table, write a SQL query to get employee name and his manager’s name.

Table : Employees

emp_id | emp_name | manager_id
——————————————————
1       |       A         | NULL
2       |       B         | NULL
3       |       C         | 1
4       |       D         | 1
5       |       E         | 2


Expected Output:-

emp_name | manager_name
——————————————
A                 |  NULL
B                 |  NULL
C                 |  A
D                 |  A
E                 |  B

select emp.emp_name as emp_name, man.emp_name as manager_name from Employees emp
inner join on Employee man into emp.manager_id = man.emp_id

    list.streams.sorts( a,b -> {

        if(a.city.comparable(b.city) == 0) {
            return a.name.compare(b.name)
        }
        return a.city.compare(b.city);
    })

 */


















