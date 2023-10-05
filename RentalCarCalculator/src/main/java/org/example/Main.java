package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input desired Pick-Up date:");
        String pickupDate = scanner.nextLine();

        System.out.println("How many days will you be renting the vehicle?");
        double daysRented = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Are you 25 years or below? (YES/NO)");
        String userAge = scanner.nextLine();

        System.out.println("Do you want an electronic toll tag at $3.95/day? (YES/NO)");
        String tollTag = scanner.nextLine();

        System.out.println("Do you wish to add GPS at $2.95/day? (YES/NO)");
        String gPs = scanner.nextLine();

        System.out.println("Do you wish to add Roadside Assistance at $3.95/day? (YES/NO)");
        String roadS = scanner.nextLine();

        double basicCarRental = calculateBasicCarRental(daysRented);
        double addOns = calculateOptionsCost(daysRented, tollTag, gPs, roadS);
        double totalCost = basicCarRental + addOns;

        System.out.printf("Your basic rental charge is $%.2f, add ons options cost is $%.2f. The total cost is $%.2f for date %s%n",
                basicCarRental, addOns, totalCost, pickupDate);

    }

    public static double calculateBasicCarRental(double daysRented) {
        return daysRented * 29.99;
    }

    public static double calculateOptionsCost(double daysRented, String tollTag, String gPs, String roadS) {
        double addOns = 0;

        if (tollTag.equalsIgnoreCase("YES")) {
            addOns += 3.95 * daysRented;
        }

        if (gPs.equalsIgnoreCase("YES")) {
            addOns += 2.95 * daysRented;
        }

        if (roadS.equalsIgnoreCase("YES")) {
            addOns += 3.95 * daysRented;
        }

        return addOns;
    }
}

