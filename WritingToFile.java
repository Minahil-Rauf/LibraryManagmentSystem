/*
Class WritingToFile containing two static methods for writing the User and Book information in users.txt and books.txt files
*/
class WritingToFile {
    // Method to write books information to file
    public static void writeBooksToFile(ArrayList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
            for (Book book : books) {
                writer.write("Book ID : " + book.getBookID() + "," +
                        "Book Title : " + book.getTitle() + "," +
                        "Book Author : " + book.getAuthor() + "," +
                        "Book Genre : " + book.getGenre() + "," +
                        "Book Availability : " + book.isAvailable());

                writer.newLine();
            }
            writer.close();
            System.out.println("Books information written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing books information to file: " + e.getMessage());
        }
    }

    // Method to write users information to file
    public static void writeUsersToFile(ArrayList<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"))) {
            for (User user : users) {
                writer.write("User ID : " + user.getUserID() + "," +
                        "User Name : " + user.getName() + "," +
                        "User Contact Information : " + user.getContactInfo());
                writer.newLine();
            }
            writer.close();
            System.out.println("Users information written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing users information to file: " + e.getMessage());
        }
    }
}