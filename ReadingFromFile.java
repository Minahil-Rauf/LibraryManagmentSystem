/*  File name :ReadingFromFile.java
Class ReadingFromFile containing two static methods for reading the User and Book information from users.txt and books.txt files
*/
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class ReadingFromFile {
    // Method to read books information from file
    public static void readBook(Library library) {
        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] bookInfo = line.split(",");
                int bookID = Integer.parseInt(bookInfo[0].split(":")[1].trim());
                String title = bookInfo[1].split(":")[1].trim();
                String author = bookInfo[2].split(":")[1].trim();
                String genre = bookInfo[3].split(":")[1].trim();
                boolean availability = Boolean.parseBoolean(bookInfo[4].split(":")[1].trim());
                Book book = new Book(bookID, title, author, genre);
                book.setAvailability(availability);
                library.addBook(book);
            }
            System.out.println("Books information read from file successfully."); // Add this print statement
        } catch (IOException e) {
            System.err.println("Error reading books information from file: " + e.getMessage());
        }
    }

    // Method to read users information from file
    public static void readUser(Library library) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
               
                String[] userInfo = line.split(",");
                int userID = Integer.parseInt(userInfo[0].split(":")[1].trim());
                String name = userInfo[1].split(":")[1].trim();
                String contactInfo = userInfo[2].split(":")[1].trim();
                User user = new User(userID, name, contactInfo);
                library.addUser(user);
            }
            System.out.println("Users information read from file successfully."); // Add this print statement
        } catch (IOException e) {
            System.err.println("Error reading users information from file: " + e.getMessage());
        }
    }
}
