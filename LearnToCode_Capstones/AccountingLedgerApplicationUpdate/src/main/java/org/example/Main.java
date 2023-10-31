package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static FileHandler fileHandler = new FileHandler();

    List<Transaction> transactions = FileHandler.readTransactionsFromFile("src/main/resources/transactions.csv");



    public static void main(String[] args) {
        System.out.println("Howdy, welcome to Andy's Ledger Tracker!");

        ArrayList<Transaction> transactionList = new ArrayList<>();
        boolean continueRunning = true;

        while (continueRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select one of the following options below: Type the letter please");
            System.out.println(" D). Add a deposit");
            System.out.println(" P). Make Payment");
            System.out.println(" L). Ledger");
            System.out.println(" X). Exit");

            String userInputHome = scanner.nextLine();
            userInputHome = userInputHome.toLowerCase();

            double amt;

            Transaction depositTransaction = null;
            Transaction paymentTransactions = null;
            switch (userInputHome) {
                case "d":
                    System.out.println("You would like to log a deposit!");
                    //Auto Date&Time instead of userInput
                    LocalDate date = LocalDate.now();
                    System.out.println(date);
                    LocalTime time = LocalTime.now();
                    System.out.println(time);

                    System.out.println("Enter the item description you're depositing today");
                    String descr = scanner.nextLine();
                    System.out.println("Please enter the vendor name");
                    String vendor = scanner.nextLine();
                    System.out.println("Enter the $ amount");
                    amt = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println(LocalDate.now() + "|" + LocalTime.now() + "|" + descr + "|" + vendor + "|" + amt + "\n");

                    try {
                        FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);

                        depositTransaction = new Transaction("date", 0, "descr", "vendor", amt);
                        transactionList.add(depositTransaction);

                        fileWriter.write(LocalDate.now() + "|" + LocalTime.now() + "|" + descr + "|" + vendor + "|" + amt + "\n");

                        fileWriter.close();

                    } catch (IOException exx) {
                        System.out.println("Unable to write in file, Try again!");
                    }
                    break;


                case "p":
                    System.out.println("You would like to log a Payment!");
                    LocalDate Date = LocalDate.now();
                    System.out.println(Date);
                    LocalTime Time = LocalTime.now();
                    System.out.println(Time);
                    System.out.println("Enter the item description you're accounting a payment for");
                    String userInputDescription = scanner.nextLine();
                    System.out.println("Please type the vendor name");
                    String userInputVendor = scanner.nextLine();
                    System.out.println("Enter the $ amount");
                    amt = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputDescription + "|" + userInputVendor + "|" + -amt + "\n");

                    try {
                        FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);

                        paymentTransactions = new Transaction(LocalDate.now().toString(), LocalTime.now().getHour(), userInputDescription, userInputVendor, -amt);

                        transactionList.add(paymentTransactions);

                        fileWriter.write(LocalDate.now() + "|" + LocalTime.now() + "|" + userInputDescription + "|" + userInputVendor + "|" + -amt + "\n");

                        fileWriter.close();

                    } catch (IOException ex) {
                        System.out.println("ERROR writing in the file, I'm sorry!!!!");
                    }

                    Transaction paymentTransaction = new Transaction(LocalDate.now().toString(), LocalTime.now().getHour(), userInputDescription, userInputVendor, -amt);
                    transactionList.add(paymentTransaction);

                    break;

                case "l":
                    System.out.println("*** WELCOME *** to your ledger screen! Please select a letter for desired action.");
                    System.out.println(" A) Show all entries");
                    System.out.println(" D) Show all deposits");
                    System.out.println(" P) Show all payments");
                    System.out.println(" R) Show all Reports");
                    System.out.println(" H) Go to HomeScreen!");

                    String userInputLedger = scanner.nextLine().toLowerCase();

                    switch (userInputLedger) {
                        case "a":
                            System.out.println("Displaying ALL entries:");
                            try {
                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                Scanner banner = new Scanner(fileInputStream);

                                String input;

                                while (banner.hasNextLine()) {
                                    input = banner.nextLine();
                                    System.out.println(input);
                                }

                            } catch (IOException ex) {
                                System.out.println("Error reading file: " + ex.getMessage());
                            }
                            break;

                        case "d":
                            System.out.println("Displaying ALL deposits:");
                            try {
                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                Scanner banner = new Scanner(fileInputStream);

                                if (banner.hasNextLine()) {
                                    banner.nextLine();
                                }
                                while (banner.hasNextLine()) {
                                    String input = banner.nextLine();
                                    String[] transaction = input.split("\\|");

                                    if (transaction.length >= 5) {
                                        double transactionAmount = Double.parseDouble(transaction[4]);

                                        if (transactionAmount > 0) {
                                            System.out.println(input);
                                        }
                                    }
                                }

                            } catch (IOException ex) {
                                System.out.println("Error reading file: " + ex.getMessage());
                            }

                            break;

                        case "p":
                            System.out.println("Displaying ALL payments:");
                            try {
                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                Scanner banner = new Scanner(fileInputStream);

                                if (banner.hasNextLine()) {
                                    banner.nextLine();
                                }
                                while (banner.hasNextLine()) {
                                    String input = banner.nextLine();
                                    String[] transaction = input.split("\\|");

                                    if (transaction.length >= 5) {
                                        double transactionAmount = Double.parseDouble(transaction[4]);
                                        if (transactionAmount < 0) {
                                            System.out.println(input);
                                        }
                                    }
                                }
                            } catch (IOException ex) {
                                System.out.println("Error reading file: " + ex.getMessage());
                            }
                            break;

                        case "r":
                            boolean viewReports = true;
                            while (viewReports) {
                                System.out.println("*** REPORTS SCREEN *** Pick an option, please type a letter.");
                                System.out.println(" A) Month to Date");
                                System.out.println(" B) Previous Month");
                                System.out.println(" C) Year to Date");
                                System.out.println(" D) Previous Year");
                                System.out.println(" E) Search by Vendor");
                                System.out.println(" F) Back - Go back to the report page");

                                String userInputReport = scanner.nextLine().toUpperCase();

                                if (userInputReport.equals("F")) {
                                    viewReports = false;
                                    break; // Exit loop if user selects 'F'
                                }

                                if (userInputReport.length() == 1 && userInputReport.charAt(0) >= 'A' && userInputReport.charAt(0) <= 'E') {
                                    char reportChoice = userInputReport.charAt(0);

                                    switch (reportChoice) {
                                        case 'A':
                                            System.out.println("Month to Date entries");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0];
                                                        if (transactionDate.matches("\\d{6}-10-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (IOException ex) {
                                                System.out.println("Error reading file: " + ex.getMessage());
                                            }
                                            break;

                                        case 'B':
                                            System.out.println("PREVIOUS MONTH ENTRIES");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0];
                                                        if (transactionDate.matches("\\d{4}-09-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("File not found.");
                                            }
                                            break;

                                        case 'C':
                                            System.out.println("YEAR –TO– DATE ENTRIES");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0];
                                                        if (transactionDate.matches("2023-\\d{12}-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("File not found.");
                                            }
                                            break;

                                        case 'D':
                                            System.out.println("PREVIOUS YEAR ENTRIES");
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionDate = transaction[0];
                                                        if (transactionDate.matches("2022-\\d{2}-\\d{2}")) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("File not found.");
                                            }
                                            break;

                                        case 'E':
                                            System.out.println("Entry search by Vendor");
                                            System.out.println("Please enter vendor name you would like to search by.");
                                            userInputVendor = scanner.nextLine();
                                            try {
                                                FileInputStream fileInputStream = new FileInputStream("src/main/resources/transactions.csv");
                                                Scanner banner = new Scanner(fileInputStream);

                                                String input;

                                                while (banner.hasNextLine()) {
                                                    input = banner.nextLine();
                                                    String[] transaction = input.split("\\|");
                                                    if (transaction.length >= 2) {
                                                        String transactionVendor = transaction[3];
                                                        if (userInputVendor.equalsIgnoreCase(transactionVendor)) {
                                                            System.out.println(input);
                                                        }
                                                    }
                                                }

                                            } catch (FileNotFoundException ex) {
                                                System.out.println("File not found.");
                                            }
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Please try again.");
                                            break;
                                    }
                                } else {
                                    System.out.println("Invalid choice. Please try again.");
                                }
                            }
                            break;


                        case "h":
                            System.out.println("Directing to main HomeScreen");
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;

                case "x":
                    System.out.println("Exiting Application, Goodbye!");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }

            Ledger ledger = new Ledger(transactionList); // Assuming transactionList is already populated
            UserInterface userInterface = new UserInterface(ledger);
            userInterface.run();

            // Add Trans to list
            transactionList.add(depositTransaction);
            ledger.addTransaction(depositTransaction); // Add this line to ensure the transaction is added to the ledger

            transactionList.add(paymentTransactions);
            ledger.addTransaction(paymentTransactions); // Add this line to ensure the transaction is added to the ledger

            Transaction transaction = new Transaction("2023-10-26", 12, "Sample Transaction", "Sample Vendor", 100.0);
            FileHandler.writeTransactionToFile("src/main/resources/transactions.csv", transaction);
        }
    }
}

