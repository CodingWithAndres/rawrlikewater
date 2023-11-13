package org.example;

import java.time.LocalDateTime;

public class LeaseContract extends Contract {
    public LeaseContract(LocalDateTime dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }
    public double expectedEndingValue(){
        return getVehicleSold().getPrice() * .50;
    }
    public double leasingFee(){
        return getVehicleSold().getPrice() * .07;
    }

    @Override
    public double getTotalPrice() {
        return getMonthlyPayment() * 36 + leasingFee();
    }

    @Override
    public double getMonthlyPayment() {
        return (getVehicleSold().getPrice() - expectedEndingValue()) / 36 + ((getVehicleSold().getPrice() + expectedEndingValue()) * 4/2400);
    }
}
