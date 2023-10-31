package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private final Ledger ledger;

    public UserInterface(Ledger ledger) {
        this.ledger = ledger;
    }



    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            displayOptions();
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "V":
                    ledger.viewLedger();
                    break;
                case "D":
                    ledger.showDeposits();
                    break;
                case "P":
                    ledger.showPayments();
                    break;
                case "R":
                    runReportsMenu();
                    break;
                case "H":
                    System.out.println("Going back to the home screen.");
                    break;
                case "X":
                    System.out.println("Exiting the application. Goodbye!");
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void displayOptions() {
        System.out.println("Options:");
        System.out.println("V) View All Entries");
        System.out.println("D) View Deposits");
        System.out.println("P) View Payments");
        System.out.println("R) Reports");
        System.out.println("H) Home");
        System.out.println("X) Exit");
        System.out.print("Enter your choice: ");
    }

    private void runReportsMenu() {
        boolean stayOnreportsScreen = true;
        Scanner scanner = new Scanner(System.in);

        while (stayOnreportsScreen) {
            System.out.println("Reports Menu:");
            System.out.println(" A) Month to Date");
            System.out.println(" B) Previous Month");
            System.out.println(" C) Year to Date");
            System.out.println(" D) Previous Year");
            System.out.println(" E) Search by Vendor");
            System.out.println(" F) Back to Reports");

            try {

                String choice = scanner.toString();
                scanner.nextLine();

                switch (choice) {
                    case "A":
                        ledger.viewMonthToDate();
                        break;
                    case "B":
                        ledger.viewPreviousMonth();
                        break;
                    case "C":
                        ledger.viewYearToDate();
                        break;
                    case "D":
                        ledger.viewPreviousYear();
                        break;
                    case "E":
                        System.out.print("Enter the vendor name: ");
                        String vendor = scanner.nextLine();
                        ledger.viewTransactionsByVendor(vendor);
                        break;
                    case "F":
                        stayOnreportsScreen = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}


