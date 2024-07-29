package org.practice.dynamicprogromming;

public class SwapNumberBitWise {

    public static void main(String[] args) {
        SwapNumberBitWise swap = new SwapNumberBitWise();
        swap.swap(15,399);
        System.out.println();
    }

    public void swap(int x, int y) {
        System.out.println("Number before swap :- x = " + x + " and y = " + y);

        x = x^y;
        y = x^y;
        x = x^y;

        System.out.println("Number after swap :- x = " + x + " and y = " + y);
    }
}
