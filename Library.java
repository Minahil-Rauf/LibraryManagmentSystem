/*
File name :Library.java
Class Library containing array lists for book and user respectively and an instance of WritingToFile class
*A constructor
*Method to add book and users
*Method to display all books and users in the library
*Method to borrow and return books
*Method to search Book by Author and Title
*/

import java.util.ArrayList;
class Library {
    // Collections to store books and users
    private ArrayList<Book> books;
    private ArrayList<User> users;
    // Instance of WritingToFile class to handle file writing
    WritingToFile fileWriter;
    ReadingFromFile fileReader;

    // Constructor to initialize the library
    Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.fileWriter = new WritingToFile();
        this.fileReader=new ReadingFromFile();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        // Write books information to file
        fileWriter.writeBooksToFile(books);
    }

    // Method to add a user to the library
    public void addUser(User user) {
        users.add(user);
        // Write users information to file
        fileWriter.writeUsersToFile(users);
    }

    // Method to display all books and users in the library
    public void displayBooksAndUsers() {
        // Display books
        System.out.println("Books in the library:");

        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookID() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Genre: " + book.getGenre() +
                    ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
        }

        // Display users
        System.out.println("\nUsers in the library:");

        for (User user : users) {
            System.out.println("User ID: " + user.getUserID() +
                    ", Name: " + user.getName() +
                    ", Contact Information: " + user.getContactInfo());
        }
    }


    // Method to borrow a book from the library
    public void borrowBook(int userId, int bookId) {
        try {
            // Find the user
            User userFound = null;
            for (User user : users) {
                if (user.userID == userId) {
                    user.borrowedBook++; // Increment the number of borrowed books for the user
                    userFound = user;
                    break;
                }
            }

            if (userFound == null) {
                throw new Exception("User not found.");
            }

            // Find the book and remove it from the library
            Book bookToRemove = null;
            for (Book book : books) {
                if (book.bookID == bookId) {
                    bookToRemove = book;
                    break;
                }
            }

            if (bookToRemove == null) {
                throw new Exception("Book not found in the library.");
            }

            books.remove(bookToRemove);
            System.out.println("Book borrowed successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to return a borrowed book to the library
    public void returnBook(int userId, int bookId) {
        try {
            // Find the user
            User userFound = null;
            for (User user : users) {
                if (user.userID == userId) {
                    if (user.borrowedBook > 0) {
                        user.borrowedBook--;
                        userFound = user;
                    } else {
                        throw new Exception("User has not borrowed any books.");
                    }
                    break;
                }
            }

            if (userFound == null) {
                throw new Exception("User not found.");
            }

            // Find the book and add it back to the library
            Book bookToAdd = null;
            for (Book book : books) {
                if (book.bookID == bookId) {
                    bookToAdd = book;
                    break;
                }
            }

            if (bookToAdd == null) {
                throw new Exception("Book not found.");
            }

            books.add(bookToAdd);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to search for books by title
    public void searchBooksByTitle(String query) {
        try {
            boolean found = false;
            for (Book book : books) {
                if (book.getTitle().equals(query)) {
                    System.out.println("Book ID: " + book.getBookID() +
                            ", Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor() +
                            ", Genre: " + book.getGenre() +
                            ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                    found = true;
                }
            }
            if (!found) {
                throw new Exception("Book not found with the provided title.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to search for books by author
    public void searchBooksByAuthor(String query) {
        try {
            boolean found = false;
            for (Book book : books) {
                if (book.getAuthor().equals(query)) {
                    System.out.println("Book ID: " + book.getBookID() +
                            ", Title: " + book.getTitle() +
                            ", Author: " + book.getAuthor() +
                            ", Genre: " + book.getGenre() +
                            ", Availability: " + (book.isAvailable() ? "Available" : "Not Available"));
                    found = true;
                }
            }
            if (!found) {
                throw new Exception("Book not found with the provided author.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
