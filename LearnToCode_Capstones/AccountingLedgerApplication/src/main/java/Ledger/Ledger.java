package Ledger;

import Transaction.Transaction;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.List;

public class Ledger {
    private List<Object> transactions;

    public Ledger(List<Object> transactions) {
        this.transactions = transactions;
    }

    public void viewLedger() {
    }

    }
