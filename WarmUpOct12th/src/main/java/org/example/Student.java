package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private int yearInCollege;
    private boolean isInternational;
    private String address;

    ///constructor w/ all properties
    public Student(String firstName, String lastName, String studentID, int yearInCollege, boolean isInternational, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.yearInCollege = yearInCollege;
        this.isInternational = isInternational;
        this.address = address;
    }

    //constructor w/ 3 properties
    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getYearInCollege() {
        return yearInCollege;
    }

    public void setYearInCollege(int yearInCollege) {
        this.yearInCollege = yearInCollege;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
