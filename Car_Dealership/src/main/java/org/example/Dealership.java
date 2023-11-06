package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle veh : inventory){
            if (veh.getPrice() >= min && veh.getPrice() <= max){
                vehicles.add(veh);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle veh : inventory){
            if (veh.getMake().equalsIgnoreCase(make) && veh.getModel().equalsIgnoreCase(model)){
                vehicles.add(veh);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle veh : inventory){
            if (veh.getYear() >= min && veh.getYear() <= max){
                vehicles.add(veh);
            }
        }
        return vehicles;
    }
    public List<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle veh : inventory){
            if (veh.getColor().equalsIgnoreCase(color)){
        }
    }
        return vehicles;
}
public List<Vehicle> getVehiclesByMileage(int min, int max){
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    for (Vehicle veh : inventory){
        if (veh.getOdometer() >= min && veh.getOdometer() <= max){
            vehicles.add(veh);
        }
    }
    return vehicles;
}
public List<Vehicle> getVehiclesByType(String type) {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    for (Vehicle veh : inventory) {
        if (veh.getType().equalsIgnoreCase(type)) {
        }
    }
    return vehicles;
}
public List<Vehicle> getAllVehicles(){
    return inventory;}

    public void addVehicle(Vehicle veh){
        inventory.add(veh);

    }

    public void removeVehicle(Vehicle veh){
        inventory.remove(veh);
    }
}
