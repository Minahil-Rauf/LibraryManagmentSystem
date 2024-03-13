/*
File name :Book.java
Class Book containing bookID ,title,author,genre,avalaibilityStatus attributes
*A constructor with access specifier public
*setters for setting the value of every attributes  
*getters for accessing attributes

*/
class Book {
    // Fields to represent book properties
     int bookID;
     String title;
     String author;
     String genre;
     boolean availabilityStatus;
  // Constructor to initialize book properties
  public Book(int bookID, String title, String author, String genre) {
    this.bookID = bookID;
    this.title = title;
    this.author = author;
    this.genre = genre;
    availabilityStatus = true; // Initially, book is available
}

// Getters for book properties
public int getBookID() {
    return bookID;
}

public String getTitle() {
    return title;
}

public String getAuthor() {
    return author;
}
public String getGenre() {
    return genre;
}

public boolean isAvailable() {
    return availabilityStatus;
}

// Setter for availability status
public void setAvailability(boolean availability) {
    availabilityStatus = availability;
}
}
ss
