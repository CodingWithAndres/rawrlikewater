package Main;

import Transaction.Transaction;
import Ledger.Ledger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Transaction> transactions = new ArrayList<>();


    public static void main(String[] args) {
        //transactions
        transactions.add(new Transaction("2023-04-15", 1013, "ergonomic keyboard", "Amazon", -89.50));
        transactions.add(new Transaction("2023-04-15", 1115, "Invoice 1001 paid", "Joe", 1500.00));
        transactions.add(new Transaction("2023-04-15", 1100, "HomePod Mini", "Apple", -99.99));
        transactions.add(new Transaction("2023-04-15", 7000, "Invoice 1002 paid", "Adam", 150.00));
        transactions.add(new Transaction("2023-04-15", 4000, "Car Note", "Capital One", -350.00));
        transactions.add(new Transaction("2023-04-15", 3030, "Macbook Pro M2", "Apple", -2000.00));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayOptions();
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "V":
                    Ledger ledger = null;
                    ledger.viewLedger();
                    break;
                case "X":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("V) View Ledger");
        System.out.println("X) Exit");
        System.out.print("Enter your choice: ");
    }
}

