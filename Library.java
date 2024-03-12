
/*
Class Library containing array lists for book and user respectively and an instance of WritingToFile class
*A constructor
*Method to add book and users
*Method to display all books in the library
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
    System.out.println("Books in the library:");
   fileReader.readBook(this);

    System.out.println("\nUsers in the library:");
    fileReader.readUser(this);
}

    // Method to borrow a book from the library
    public void borrowBook(int userId, int bookId) {
        try {
            // Find the user
            for (User user : users) {
                if (user.userID == userId) {
                    user.borrowedBook++; // Increment the number of borrowed books for the user
                    break;
                }
            }

            // Find the book and remove it from the library
            for (Book book : books) {
                if (book.bookID == bookId) {
                    books.remove(book);
                    return;
                }
            }

            // Throw exception if book not found
            throw new Exception("Book not found in the library.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to return a borrowed book to the library
    public void returnBook(int userId, int bookId) {
        try {
            boolean userFound = false;
            // Find the user and decrement the number of borrowed books
            for (User user : users) {
                if (user.userID == userId) {
                    if (user.borrowedBook > 0) {
                        user.borrowedBook--;
                        userFound = true;
                    } else {
                        throw new Exception("User has not borrowed any books.");
                    }
                    break;
                }
            }

            // Throw exception if user not found
            if (!userFound) {
                throw new Exception("User not found.");
            }

            boolean bookFound = false;
            // Find the book and add it back to the library
            for (Book book : books) {
                if (book.bookID == bookId) {
                    bookFound = true;
                    books.add(book);
                    break;
                }
            }

            // Throw exception if book not found
            if (!bookFound) {
                throw new Exception("Book not found in the library.");
            }

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
