import Transaction.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class Ledger {
    public List<Transaction> transactions;
    public Transaction deposit;

    public Ledger() {
    }

    public void viewLedger() {
        //transactions
        Transaction[] transactions = {
                new Transaction("2023-04-15", 1013, "ergonomic keyboard", "Amazon", -89.50),
                new Transaction("2023-04-15", 1115, "Invoice 1001 paid", "Joe", 1500.00),

        };



        // Display all entries.
        for (Transaction transaction : transactions) {
            System.out.println("Date: " + transaction.getDate() +
                    ", Time: " + transaction.getTime() +
                    ", Description: " + transaction.getDescription() +
                    ", Vendor: " + transaction.getVendor() +
                    ", Amount: " + transaction.getAmount());
        }
    }

    public void addTransaction(Transaction deposit) {
        this.deposit = deposit;
    }

    public ArrayList<Transaction> getAllTransactions() {
        return null;
    }

    public ArrayList<Transaction> getDeposits() {
        return null;
    }

    public ArrayList<Transaction> getPayments() {
        return null;
    }
}