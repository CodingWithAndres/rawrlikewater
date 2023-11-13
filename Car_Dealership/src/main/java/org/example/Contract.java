package org.example;

import java.time.LocalDateTime;

public abstract class Contract {
    private LocalDateTime dateOfContract;
    private String customerName;
    private  String customerEmail;
    private Vehicle vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public LocalDateTime getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(LocalDateTime dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    //public void setTotalPrice(double totalPrice) {
        //this.totalPrice = totalPrice;
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    public Contract(LocalDateTime dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        //make abstract//this.totalPrice = totalPrice;
        //this.monthlyPayment = monthlyPayment;
    }
}
