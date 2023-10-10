package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean valid = false;
        System.out.println("Enter your numerical score:");

        while (!valid) {
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                valid = true; // Added to exit loop after valid input
            } else {
                System.out.println("Please enter valid input.");
                scanner.nextLine();
            }
        }

        if (score >= 90 && score <= 100) {
            System.out.println("Great job! You got an A!");
        } else if (score >= 80 && score <= 89) {
            System.out.println("Great job! You got a B!");
        } else if (score >= 70 && score <= 79) {
            System.out.println("Great job! You got a C!");
        } else if (score >= 60 && score <= 69) {
            System.out.println("We have some work to do. You got a D.");
        } else if (score < 60) {
            System.out.println("We have some work to do. You got an F.");
        }

        try {
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred while closing the scanner: " + e.getMessage());
        }
    }
}
