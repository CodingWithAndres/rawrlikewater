package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//private DealershipFileManager(){}
//public static Dealership getDealership(){
public class DealershipFileManager {
    private DealershipFileManager() {

    }

    //Nice use of static and the private constructor
    public static Dealership getDealership() {
        Dealership dealership = new Dealership("* House of Cars *","2023 Andy Street","214-836-0000");

        try { //create fis file to store vehicles //remember to add FileNotFoundEx...
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/vehicles.csv");

            //create scanner to take user input into fis
            Scanner scanner = new Scanner(fileInputStream);

            //object...skip 1st line
            scanner.nextLine();

            //loop thru file
            String userInput;
            while (scanner.hasNextLine()) {
                userInput = scanner.nextLine();

                //use String.split method to retrieve data
                //splits a string into a list
                String[] list = userInput.split("\\|");

                Vehicle veh = new Vehicle(Integer.parseInt(list[0]), Integer.parseInt(list[1]),
                        list[2],
                        list[3],
                        list[4],
                        list[5],
                        Integer.parseInt(list[6]), Double.parseDouble(list[7]));

                //add to dealership inventory list
                dealership.addVehicle(veh);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found, sorry!");

        }
        return dealership;
    }
    public static void saveDealership(Dealership dealership){
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/vehicles.csv");

            //header
            String headerRow = String.format("%s | %s | %s %n", dealership.getName(), dealership.getAddress(), dealership.getPhoneNumber());
            fileWriter.write(headerRow);

            for (Vehicle vehicle : dealership.getAllVehicles()){
                String list = String.format("%d | %d | %s | %s | %s | %s | %d |%f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getType(), vehicle.getOdometer(), vehicle.getPrice());

                fileWriter.write(list);
            } //IO Exception
            //
            fileWriter.close();
        }
        catch (IOException ex){
            System.out.println("Could not write to file, sorry!");
        }
    }

}
