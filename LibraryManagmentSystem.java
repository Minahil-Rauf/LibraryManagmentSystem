/*   File name :LibraryManagmentSystems.java
Class LibraryManagmentSystem(Main class) incorporating an infinite do while loop and instaces of Library and Scanner class

*/

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // Displaying the menu
                System.out.println("Library Management System Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. Add User");
                System.out.println("3. Display Books and Users");
                System.out.println("4. Borrow Book");
                System.out.println("5. Return Book");
                System.out.println("6. Search Books by Title");
                System.out.println("7. Search Books by Author");
                System.out.println("0. Exit");

                // Getting user choice
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Handling user choice
                switch (choice) {
                    case 1:
                        // Adding a book
                        System.out.print("Enter Book ID: ");
                        int bookID = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Genre: ");
                        String genre = scanner.nextLine();

                        Book newBook = new Book(bookID, title, author, genre);
                        library.addBook(newBook);
                        break;

                    case 2:
                        // Adding a user
                        System.out.print("Enter User ID: ");
                        int userID = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Contact Information: ");
                        String contactInfo = scanner.nextLine();

                        User newUser = new User(userID, name, contactInfo);
                        library.addUser(newUser);
                        break;

                    case 3:
                        // Displaying all books
                        library.displayBooksAndUsers();
                        break;

                    case 4:
                        // Borrowing a book
                        System.out.print("Enter User ID: ");
                        int borrowUserID = scanner.nextInt();
                        System.out.print("Enter Book ID: ");
                        int borrowBookID = scanner.nextInt();
                        library.borrowBook(borrowUserID, borrowBookID);
                        System.out.println("Book has been borrowed successfully by the user");
                        break;

                    case 5:
                        // Returning a book
                        System.out.print("Enter User ID: ");
                        int returnUserID = scanner.nextInt();
                        System.out.print("Enter Book ID: ");
                        int returnBookID = scanner.nextInt();
                        library.returnBook(returnUserID, returnBookID);
                        break;

                    case 6:
                        // Searching books by title
                        System.out.print("Enter search query (Title ): ");
                        String searchQuery = scanner.nextLine();
                        library.searchBooksByTitle(searchQuery);
                        break;

                    case 7:
                        // Searching books by author
                        System.out.print("Enter search query (Author): ");
                        String searchQuery1 = scanner.nextLine();
                        library.searchBooksByAuthor(searchQuery1);
                        break;

                    case 0:
                        // Exiting the program
                        System.out.println("Exiting Library Management System. Goodbye!");
                        System.exit(0);

                    default:
                        // Handling invalid choice
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Handling invalid input
                System.out.println("Invalid input. Please enter an integer input.");
                scanner.nextLine(); // Clear the input buffer
            }
         }
}
}
