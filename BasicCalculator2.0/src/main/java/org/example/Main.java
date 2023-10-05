package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Howdy! I hope you enjoy this calculator test... Thank you for participating!");
        System.out.println("Enter your first number:");

        Scanner scanner = new Scanner(System.in);
        float firstNumber = scanner.nextFloat();

        System.out.println("Enter your second number");
        float secondNumber = scanner.nextFloat();

        //present user with calculations
        System.out.println("* Possible Calculations *1");
        System.out.println("(A)dd");
        System.out.println("(S)ubtract");
        System.out.println("(M)ultiply");
        System.out.println("(D)ivide");

        System.out.println("Please input the beginning letter for the desired calculation method:");
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("A")) {
            float sum = firstNumber + secondNumber;
            System.out.printf("%.2f + %.2f = %.2f", firstNumber, secondNumber, sum);
        }
        else if (answer.equalsIgnoreCase("S")) {
            float subtract = firstNumber - secondNumber;
            System.out.printf("%.2f - %.2f = %.2f", firstNumber, secondNumber, subtract);
        }
        else if (answer.equalsIgnoreCase("M")) {
            float multiply = firstNumber * secondNumber;
            System.out.printf("%.2f * %.2f = %.2f", firstNumber, secondNumber, multiply);
        }
        else if (answer.equalsIgnoreCase("D")) {
            float divide = firstNumber / secondNumber;
            System.out.printf("%.2f / %.2f = %.2f", firstNumber, secondNumber, divide);
        }
        else { System.out.println("SORRY! NOT A VALID ENTRY");

        }
    }
}