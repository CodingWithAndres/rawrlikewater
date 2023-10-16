package org.example;

public class Book {

    //Method to check out
    public void checkOut(String checkedOutTo) {
        this.isCheckedOutTo = true;
        this.checkedOutTo = checkedOutTo;
    }

    //Method to check in
    public void checkIn() {
        this.isCheckedOutTo = false;
        this.checkedOutTo = "";
    }

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOutTo;
    private String checkedOutTo;

    //Constructor
    public Book(int id, String isbn, String title, boolean isCheckedOutTo, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOutTo = isCheckedOutTo;
        this.checkedOutTo = checkedOutTo;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOutTo;
    }

    public void setCheckedOut(boolean checkOut) {
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;

    }
}
