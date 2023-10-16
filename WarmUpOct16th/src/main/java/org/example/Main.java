package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] fiveArray = {9, 7, 5, 3, 1};

        //Sort
        Arrays.sort(fiveArray);

        //Print the sorted array
        System.out.println("The Sorted Array: ");
        for (int num : fiveArray) {
            System.out.print(num + "");
        }

    }
}