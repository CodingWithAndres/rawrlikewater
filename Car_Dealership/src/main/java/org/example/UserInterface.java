package org.example;

import javax.annotation.processing.SupportedSourceVersion;
import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    public UserInterface(){
        dealership = DealershipFileManager.getDealership();
    }
    public void displayScreen(){
        boolean isDisplayScreen = true;
        Scanner scanner = new Scanner(System.in);

        while (isDisplayScreen){
            System.out.printf("Welcome to %s!!!\n", dealership.getName());
            System.out.printf("Located @ %s\n", dealership.getAddress());

            System.out.println("0.) Exit House of Cars Dealership");
            System.out.println("1.) View ALL vehicles in inventory");
            System.out.println("2.) Explore vehicles by price");
            System.out.println("3.) Explore vehicles by make & model");
            System.out.println("4.) Explore vehicles by year");
            System.out.println("5.) Explore vehicles by color");
            System.out.println("6.) Explore vehicles by mileage");
            System.out.println("7.) Explore vehicles by type");
            System.out.println("8.) Add vehicle");
            System.out.println("9.) Remove vehicle");
            try {
                int userInput = scanner.nextInt();

                switch (userInput){
                    case 0:
                        DealershipFileManager.saveDealership(dealership);
                        System.exit(0);
                        break;

                    case 1:
                        getAllVehicles();
                        break;

                    case 2:
                        getByPrice();
                        break;
                        
                    case 3:
                        getByMakeModel();
                        break;
                        
                    case 4:
                        getByYear();
                        break;
                        
                    case 5: 
                        getByColor();
                        break;
                        
                    case 6:
                        getByMileage();
                        break;
                        
                    case 7:
                        getByType();
                        break;
                        
                    case 8:
                        addVehicle();
                        break;
                        
                    case 9:
                        removeVehicle();
                        break;
                        
                    default:
                        System.out.println("Invalid option, sorry!");
                        break;
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please input a number for desired choice.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void removeVehicle() {
        boolean isRemovingVehicle = true;

        while (isRemovingVehicle){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(" * Please type the VIN # of the vehicle you wish to remove *");
                int vinNumber = scanner.nextInt();
                scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getAllVehicles();
                Vehicle vehToRemove = null;

                for (Vehicle veh : vehicleList){
                    if (veh.getVin() == vinNumber){
                        vehToRemove = veh;
                        break;
                    }
                }
                if (vehToRemove != null){
                    dealership.removeVehicle(vehToRemove);
                    System.out.println("Vehicle has been removed!");
                }
                else {
                    System.out.println("Vehicle" + vinNumber + "is unable to be found in inventory.");
                }
                isRemovingVehicle = false;
            } catch (InputMismatchException ex){
                System.out.println("VIN # is not valid, try again!");
            }
        }
    }

    private void addVehicle() {
        boolean isAddingVehicle = true;

        while (isAddingVehicle) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the vehicle's VIN #; ");
                int vinNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please enter vehicle year: ");
                int yr = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please enter vehicle make: ");
                String make = scanner.nextLine();

                System.out.println("Please enter vehicle model: ");
                String model = scanner.nextLine();

                System.out.println("Please enter color of vehicle:");
                String color = scanner.nextLine();

                System.out.println("Please enter vehicle type: ");
                String type = scanner.nextLine();

                System.out.println("Please enter the current odometer reading:");
                int odometer = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please enter vehicle price: ");
                double price = scanner.nextDouble();

                Vehicle addVeh = new Vehicle(vinNumber,yr,make,model,color,type,odometer,price);

                dealership.addVehicle(addVeh);

                System.out.println("Vehicle has been added to inventory!");

                isAddingVehicle = false;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input, sorry!");
            }
        }
    }

    private void getByType() {
        boolean getByType = true;

        while(getByType){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter desired vehicle type:");
                String vehType = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByType(vehType);
                displayVehicles(vehicleList);
                getByType = false;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input!");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicleList) {

        for (Vehicle veh : vehicleList){
            System.out.println(vehicleList.toString());
        }
    }

    private void getByMileage() {
        boolean getByMileage = true;

        while (getByMileage){
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Please enter the minimum mileage of vehicle's you wish to explore: ");
                int minMi = scanner.nextInt();
                System.out.println("Please enter the maximum mileage of vehicle's you wish to explore: ");
                int maxMi = scanner.nextInt();

                if (minMi <= maxMi){
                    List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMi,maxMi);
                    displayVehicles(vehicleList);
                    getByMileage = false;
                } else {
                    System.out.println("Minimum mileage can't be greater than maximum mileage, try again..");
                    }
                } catch (InputMismatchException ex){
                    System.out.println("Mileage is a number.");
            }
        }
    }

    private void getByColor() {
        boolean getByColor = true;

        while (getByColor){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the color of the vehicle you wish to explore: ");
                String color = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehicleByColor(color);
                displayVehicles(vehicleList);
                getByColor = false;
            } catch (InputMismatchException ex){
                System.out.println("Invlid input!");
            }
        }
    }

    private void getByYear() {
        boolean getByYear = true;

        while (getByYear){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the minimum year of vehicles' you wish to explore: ");
                int minYr = scanner.nextInt();
                System.out.println("Please enter the maximum year of vehicles' you wish to explore: ");
                int maxYr = scanner.nextInt();

                if (minYr <= maxYr) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYr, maxYr);
                    displayVehicles(vehicleList);
                    getByYear = false;
                } else {
                    System.out.println("The min year must not be greater than the max year; ");
                    }
                } catch (InputMismatchException ex){
                System.out.println("Year is a number.");
            }
        }
    }

    private void getByMakeModel() {
        boolean getByMakeModel = true;

        while (getByMakeModel){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the make of vehicles' you wish to explore: ");
                String make = scanner.nextLine();
                System.out.println("Please enter the model of vehicles' you wish to explore: ");
                String model = scanner.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                getByMakeModel = false;
            } catch (InputMismatchException ex){
                System.out.println("Invalid input!");
            }
        }
        
    }

    private void getAllVehicles() {
        displayVehicles(dealership.getAllVehicles());
        
    }

    private void getByPrice() {
        boolean getByPrice = true;

        while (getByPrice){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter the minimum price for the vehicles' you wish to explore:");
                double minPrice = scanner.nextDouble();
                System.out.println("Please enter the maximum price for the vehicles' you wish to explore:");
                double maxPrice = scanner.nextDouble();

                if (minPrice < maxPrice){
                    System.out.println("Viewing ALL vehicles between %d and %d");
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice,maxPrice);
                    displayVehicles(vehicleList);
                    getByPrice = false;
                }
                else {
                    System.out.println("Minimum price can't be greater than maximum price. ");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Price is a #");
            }
        }
    }
}



