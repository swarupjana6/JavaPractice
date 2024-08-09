package org.example;

import java.util.*;
import java.util.stream.Stream;

public class ProblemIV {

    public static void main(String[] args) {

        List<Integer> elements = Arrays.asList(1,3,5,7);
        List<Integer> elements2 = Arrays.asList(2,4,1,5,9,6);

        //merge two list,
        List<Integer> conCanList = Stream.concat(elements.stream(), elements2.stream()).toList();
        System.out.println(conCanList);

        // sort by descending
        List<Integer> list = conCanList.stream()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(list);

        // remove duplicate without using set or stream
        ArrayList<Integer> distinctList = new ArrayList<>(list);
        Map<Integer, Integer> frequency = new HashMap<>();

        Iterator<Integer> itr = distinctList.iterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            if (!frequency.containsKey(i)) {
                frequency.put(i, 1);
            } else {
                itr.remove();
            }
        }
        System.out.println(distinctList);




    }
}
