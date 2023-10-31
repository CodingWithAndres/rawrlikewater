package org.example;

import java.time.LocalDate;
import java.util.List;

public class Ledger {
    public List<Transaction> transactions;

    public Ledger(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    //Methods from the UserInterface Class *REPORTS*
    public void viewMonthToDate() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("*** Month to Date Entries ***");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            if (transactionDate.getMonth() == currentDate.getMonth() &&
                    transactionDate.getYear() == currentDate.getYear()) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void viewPreviousMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastMonthDate = currentDate.minusMonths(1);
        System.out.println("*** Previous Month Entries ***");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            if (transactionDate.getMonth() == lastMonthDate.getMonth() &&
                    transactionDate.getYear() == lastMonthDate.getYear()) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void viewYearToDate() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("*** Year to Date Entries ***");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            if (transactionDate.getYear() == currentDate.getYear()) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void viewPreviousYear() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastYearDate = currentDate.minusYears(1);
        System.out.println("*** Previous Year Entries ***");

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            if (transactionDate.getYear() == lastYearDate.getYear()) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void viewTransactionsByVendor(String vendor) {
        System.out.println("*** Transactions for Vendor: " + vendor + " ***");

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendor)) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void showDeposits() {
        System.out.println("*** Deposit Entries ***");

        for (Transaction transaction : transactions) {
            if (transaction.getAmt() > 0) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }


    public void showPayments() {
        System.out.println("*** Payment Entries ***");

        for (Transaction transaction : transactions) {
            if (transaction.getAmt() < 0) {
                System.out.println("Date: " + transaction.getDate() +
                        ", Time: " + transaction.getTime() +
                        ", Description: " + transaction.getDescr() +
                        ", Vendor: " + transaction.getVendor() +
                        ", Amount: " + transaction.getAmt());
            }
        }
    }

    public void viewLedger() {
        System.out.println("*** Ledger Entries ***");

        for (Transaction transaction : transactions) {
            System.out.println("Date: " + transaction.getDate() +
                    ", Time: " + transaction.getTime() +
                    ", Description: " + transaction.getDescr() +
                    ", Vendor: " + transaction.getVendor() +
                    ", Amount: " + transaction.getAmt());
        }
    }

    public void addTransaction(Transaction depositTransaction) {
    }
}
