package org.example;

    public class Main {

        public static void main(String[] args) {
        //cconstructor with all properties
        Student student1 = new Student("Andres", "Solis", "123456", 2, false, "321 Andy St");

        //constructor with only First Name, Last Name, and StudentID
        Student student2 = new Student("John", "Hop", "789012");

        //setters to update properties
        student2.setYearInCollege(4);
        student2.setInternational(true);
        student2.setAddress("456 Johnny St");

        //properties using getters
        System.out.println("Student 1:");
        System.out.println("Name: " + student1.getFirstName() + " " + student1.getLastName());
        System.out.println("Student ID: " + student1.getStudentID());
        System.out.println("Year in College: " + student1.getYearInCollege());
        System.out.println("International Student: " + student1.isInternational());
        System.out.println("Address: " + student1.getAddress());

        System.out.println("\nStudent 2:");
        System.out.println("Name: " + student2.getFirstName() + " " + student2.getLastName());
        System.out.println("Student ID: " + student2.getStudentID());
        System.out.println("Year in College: " + student2.getYearInCollege());
        System.out.println("International Student: " + student2.isInternational());
        System.out.println("Address: " + student2.getAddress());
    }
}
