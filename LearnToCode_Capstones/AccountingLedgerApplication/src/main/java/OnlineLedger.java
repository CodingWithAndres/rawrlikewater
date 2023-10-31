
import Transaction.Transaction;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class OnlineLedger {
    public static void main(String[] args) {
        Ledger ledger = new Ledger();

        Scanner scanner = new Scanner(System.in);
        String choice;

        while (true) {
            displayHomeScreen();
            choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    addDeposit(ledger, scanner);

                    break;

                case "P":
                    makePayment(ledger, scanner);

                    break;

                case "L":
                    ledger.viewLedger();

                    break;
                case "X":

                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");

                    break;
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("\nHome Screen:");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addDeposit(Ledger ledger, Scanner scanner) {
        System.out.print("Enter deposit info (Date, Description, Amount): ");
        String[] depositInfo = scanner.nextLine().split(",");
        if (depositInfo.length != 3) {
            System.out.println("Invalid input. Please provide Date, Description, and Amount separated by commas.");
            return;
        }

        try {
            String date = depositInfo[0].trim();
            String description = depositInfo[1].trim();
            double amount = Double.parseDouble(depositInfo[2].trim());

            Transaction deposit = new Transaction(date, description, amount);
            ledger.addTransaction(deposit);
            saveTransactionToCSV(deposit);

            System.out.println("Deposit added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid number.");
        }
    }

    private static void makePayment(Ledger ledger, Scanner scanner) {
        System.out.print("Enter debit info (Date, Description, Amount): ");
        String[] debitInfo = scanner.nextLine().split(",");
        if (debitInfo.length != 3) {
            System.out.println("Invalid input. Please provide Date, Description, and Amount separated by commas.");
            return;
        }

        try {
            String date = debitInfo[0].trim();
            String description = debitInfo[1].trim();
            double amount = Double.parseDouble(debitInfo[2].trim());

            Transaction debit = new Transaction(date, description, -amount);
            ledger.addTransaction(debit);
            saveTransactionToCSV(debit);

            System.out.println("Debit added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount format. Please enter a valid number.");
        }
    }

    private static void saveTransactionToCSV(Transaction transaction) {
        try {
            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(transaction.toCSV() + "\n");
            writer.close();
        } catch (IOException ex) {

        }
    }


    public static void viewAllEntries(Ledger ledger) {
        ArrayList<Transaction> allTransactions = ledger.getAllTransactions();
        displayTransactions(allTransactions);
    }

    private static void viewDeposits(Ledger ledger) {
        ArrayList<Transaction> deposits = ledger.getDeposits();
        displayTransactions(deposits);
    }

    private static void viewPayments(Ledger ledger) {
        ArrayList<Transaction> payments = ledger.getPayments();
        displayTransactions(payments);
    }

    private static void runReports(Ledger ledger, Scanner scanner) {
        System.out.println("\nReports:");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // Generate and display Month To Date report
                break;
            case 2:
                // Generate and display Previous Month report
                break;
            case 3:
                // Generate and display Year To Date report
                break;
            case 4:
                // Generate and display Previous Year report
                break;
            case 5:
                // Search by Vendor
                System.out.print("Enter Vendor Name: ");
                String vendorName = scanner.nextLine();
                ArrayList<Transaction> vendorTransactions = searchByVendor(ledger, vendorName);
                displayTransactions(vendorTransactions);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    private static ArrayList<Transaction> searchByVendor(Ledger ledger, String vendorName) {
        ArrayList<Transaction> vendorTransactions = new ArrayList<>();
        for (Transaction transaction : ledger.getAllTransactions()) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                vendorTransactions.add(transaction);
            }
        }
        return vendorTransactions;
    }

    private static void displayTransactions(ArrayList<Transaction> transactions) {
        System.out.println("Transaction Entries: \n");
        System.out.println("Date       | Description           | Amount");
        System.out.println("--------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.printf("%-11s| %-22s| $%-7.2f\n", transaction.getDate(), transaction.getDescription(), transaction.getAmount());
        }
    }
}