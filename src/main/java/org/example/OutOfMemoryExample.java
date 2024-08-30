package org.example;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryExample {
    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();
            while (true) {
                list.add(1); // Continually adds to the list
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Caught an OutOfMemoryError: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

