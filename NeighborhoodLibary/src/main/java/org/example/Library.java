package org.example;

import java.util.Scanner;

/*
Overall, good job! You broke tasks down into methods to make your code readable and clean.
I gave you some advice about the constructor. Sometimes you can change the number of arguments
in the constructor to be more convenient for you. Less typing.
 */
public class Library {
    public static void main(String[] args) {
        Book[] inventory = initializeInventory();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayHomeScreen();
            int choice = getChoice(scanner);

            switch (choice) {
                    case 1:
                        showAvailableBooks(inventory, scanner);
                        break;

                        case 2:
                        showCheckedOutBooks(inventory, scanner);
                            break;

                            case 3:
                            System.out.println("Exiting Andy's Book Store. Goodbye!");
                            System.exit(0);
                                break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }

            //I like that this is its own method!
            public static Book[] initializeInventory() {
                Book[] inventory = new Book[20];

                //See how if you change the constructor its less typing?
                inventory[0] = new Book(1, "000-0-00-00000-0", "Book One");
                inventory[1] = new Book(2, "000-0-00-00000-1", "Book Two", false, "");
                inventory[2] = new Book(3, "000-0-00-00000-2", "Book Three", false, "");
                inventory[3] = new Book(4, "000-0-00-00000-3", "Book Four", false, "");
                inventory[4] = new Book(5, "000-0-00-00000-4", "Book Five", false, "");
                inventory[5] = new Book(6, "000-0-00-00000-5", "Book Six", false, "");
                inventory[6] = new Book(7, "000-0-00-00000-6", "Book Seven", false, "");
                inventory[7] = new Book(8, "000-0-00-00000-7", "Book Eight", false, "");
                inventory[8] = new Book(9, "000-0-00-00000-8", "Book Nine", false, "");
                inventory[9] = new Book(10, "000-0-00-00000-9", "Book Ten", false, "");
                inventory[10] = new Book(11, "000-0-00-00000-10", "Book Eleven", false, "");
                inventory[11] = new Book(12, "000-0-00-00000-11", "Book Twelve", false, "");
                inventory[12] = new Book(13, "000-0-00-00000-12", "Book Thirteen", false, "");
                inventory[13] = new Book(14, "000-0-00-00000-13", "Book Fourteen", false, "");
                inventory[14] = new Book(15, "000-0-00-00000-14", "Book Fifteen", false, "");
                inventory[15] = new Book(16, "000-0-00-00000-15", "Book Sixteen", false, "");
                inventory[16] = new Book(17, "000-0-00-00000-16", "Book Seventeen", false, "");
                inventory[17] = new Book(18, "000-0-00-00000-17", "Book Eighteen", false, "");
                inventory[18] = new Book(19, "000-0-00-00000-18", "Book Nineteen", false, "");
                inventory[19] = new Book(20, "000-0-00-00000-19", "Book Twenty", false, "");

                return inventory;
            }

            public static void displayHomeScreen() {
                System.out.println("WELCOME!");
                System.out.println("Find your place at Andy's online bookstore:");
                System.out.println("1. Show Available Books");
                System.out.println("2. Show Checked Out Books");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
            }

            public static int getChoice(Scanner scanner) {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                }
                return scanner.nextInt();
            }

            public static void showAvailableBooks(Book[] inventory, Scanner scanner) {
                System.out.println("Available Books:");
                for (Book book : inventory) {
                    if (book != null && !book.isCheckedOut()) {
                        System.out.println("ID: " + book.getId() +
                                ", ISBN: " + book.getIsbn() +
                                ", Title: " + book.getTitle());
                    }
                }

                System.out.print("Enter the ID of the book to check out, or 'exit' to go back to the home screen: ");
                String input = scanner.next();

                if (!input.equalsIgnoreCase("exit")) {
                    int bookId = Integer.parseInt(input);
                    checkOutBook(bookId, inventory, scanner);
                }
            }

            public static void showCheckedOutBooks(Book[] inventory, Scanner scanner) {
                System.out.println("Checked Out Books:");
                for (Book book : inventory) {
                    if (book != null && book.isCheckedOut()) {
                        System.out.println("ID: " + book.getId() +
                                ", ISBN: " + book.getIsbn() +
                                ", Title: " + book.getTitle() +
                                ", Checked Out To: " + book.getCheckedOutTo());
                    }
                }

                System.out.print("Enter 'C' to check in a book, or 'X' to go back to the home screen: ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("C")) {
                    System.out.print("Enter the ID of the book to check in: ");
                    int bookId = Integer.parseInt(scanner.next());
                    checkInBook(bookId, inventory);
                }
            }

            public static void checkOutBook(int bookId, Book[] inventory, Scanner scanner) {
                for (Book book : inventory) {
                    if (book != null && book.getId() == bookId && !book.isCheckedOut()) {
                        System.out.print("Enter your name to check out the book: ");
                        String name = scanner.next();
                        book.checkOut(name);
                        System.out.println("Book checked out successfully!");
                        return;
                    }
                }
                System.out.println("Invalid book ID or the book is already checked out.");
            }

            public static void checkInBook(int bookId, Book[] inventory) {
                for (Book book : inventory) {
                    if (book != null && book.getId() == bookId && book.isCheckedOut()) {
                        book.checkIn();
                        System.out.println("Book checked in successfully!");
                        return;
                    }
                }
                System.out.println("Invalid book ID or the book is not checked out.");
            }
        }

