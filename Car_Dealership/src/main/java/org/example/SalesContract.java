package org.example;

import java.time.LocalDateTime;

public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(LocalDateTime dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    boolean isFinanced() {
        return isFinanced;
    }

    public int recordingFee() {
        return 100;
    }

    public double salesTax() {
        return getVehicleSold().getPrice() * .05;
    }

    public double processingFee() {
        double price = getVehicleSold().getPrice();
        double processingFee = 0;
        if (price < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;
    }

    @Override
    public double getTotalPrice() {
        double basePrice = getVehicleSold().getPrice();
        double totalPrice;
        if (isFinanced) {
            if (basePrice >= 10000) {
                //@ 48 months
                double r = .0425 / 12;
                totalPrice = (48 * (basePrice * r * Math.pow(1 + r, 48)) / (Math.pow(1 + r, 48) - 1))
                        + recordingFee() + processingFee() + salesTax();
            } else {
                //@ 24 months
                double r = .0525 / 12;
                totalPrice = (24 * (basePrice * r * Math.pow(1 + r, 24)) / (Math.pow(1 + r, 24) - 1))
                        + recordingFee() + processingFee() + salesTax();
            }
        } else {
            totalPrice = basePrice + recordingFee() + processingFee() + salesTax();
        }
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double basePrice = getVehicleSold().getPrice();
        double monthlyPayment;
        if (isFinanced) {
            if (basePrice >= 10000) {
                monthlyPayment = getTotalPrice() / 48;
            } else {
                monthlyPayment = getTotalPrice() / 24;
            }
        } else {
            return 0;
        }
        return monthlyPayment;
    }
}