package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to your personalized calculator by Andres! (: ");
        System.out.println("Would you like to Add, Subtract, Multiply, or Divide? ");
        Scanner scanner = new Scanner(System.in);

        String operation = scanner.nextLine();

        System.out.println("Enter first number");
        float firstNumber = scanner.nextFloat();

        System.out.println("Enter second number");
        float secondNumber = scanner.nextFloat();

        //proceed with calculation methods
        float add = (firstNumber + secondNumber);
        float subtract = (firstNumber - secondNumber);
        float multiply = (firstNumber * secondNumber);
        float divide = (firstNumber / secondNumber);

        if (operation.equalsIgnoreCase( "add")) {
            System.out.println(add);
        }
        else if (operation.equalsIgnoreCase("subtract")) {
            System.out.println(subtract);
        }
        if (operation.equalsIgnoreCase("multiply")) {
            System.out.println(multiply);
        }
        if (operation.equalsIgnoreCase("divide")) {

        }
    }
}