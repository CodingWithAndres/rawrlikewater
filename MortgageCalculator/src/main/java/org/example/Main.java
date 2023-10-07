package org.example;

import java.util.Scanner;

public class Main {
    private static final int MONTHS_IN_YEAR = 12;
    private static final int PERCENTAGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi! Welcome to Andy's Lending Solutions.");
        System.out.println("Say hello to possibilities.");

        double principle = getValidDouble(scanner, "How much do you need? ");
        double interestRate = getValidDouble(scanner, "Enter interest rate: ") / PERCENTAGE / MONTHS_IN_YEAR;
        double loanLength;
        loanLength = getValidDouble(scanner, "Enter loan length terms: ") * MONTHS_IN_YEAR;

        double n = loanLength;
        double monthlyPayments = mortgageCalculator(principle, interestRate, n);
        double totalInterest = (monthlyPayments * n) - principle;

        System.out.printf("Your total monthly payment: $%.2f%n", monthlyPayments);
        System.out.printf("How much interest you would pay over the life of the loan: $%.2f%n", totalInterest);
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        double value = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
        return value;
    }

    public static double mortgageCalculator(double principle, double monthlyInterestRate, double numberOfPayments) {
        double numerator = principle * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
        double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
        return numerator / denominator;
    }
}
