package org.example;

public class Transaction {
    private String date;
    private int time;
    private String descr;
    private String vendor;
    private double amt;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Transaction(String date, int time, String descr, String vendor, double amt) {
        this.date = date;
        this.time = time;
        this.descr = descr;
        this.vendor = vendor;
        this.amt = amt;
    }
}

