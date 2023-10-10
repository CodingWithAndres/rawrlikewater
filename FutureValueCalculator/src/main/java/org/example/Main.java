package org.example;

import java.util.Scanner;

public class Main {

    private static final int PERCENTAGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the initial deposit amount in dollars: ");
        double deposit = getValidPositiveDouble(scanner);

        System.out.println("Please enter the annual interest rate (as a percentage): ");
        double interestRate = getValidPositiveDouble(scanner);

        System.out.println("Please enter the length of the deposit in years: ");
        int termInYears = getValidPositiveInt(scanner);

        double convertedRate = interestRate / PERCENTAGE;
        double dailyCompounding = interestRate / 365;

        double totalInterest = deposit * convertedRate;
        double futureValue = deposit * Math.pow((1 + dailyCompounding), 365 * termInYears);

        System.out.printf("Your Certificate of Deposit's ending balance will be $%.2f, and you'll have earned $%.2f in interest.\n", futureValue, totalInterest);
    }

    private static double getValidPositiveDouble(Scanner scanner) {
        double value;
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number. ");
                scanner.next();
            }
            value = scanner.nextDouble();
        } while (value <= 0);
        return value;
    }

    private static int getValidPositiveInt(Scanner scanner) {
        int value;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer. ");
                scanner.next();
            }
            value = scanner.nextInt();
        } while (value <= 0);
        return value;
    }
}
