/*
Class User containing userID ,name,contactInformation,borrowedBook  attributes
*A constructor with access specifier public
*setters for setting the value of every attributes
*getters for accessing attributes

*/

class User {
    // Fields to represent user properties
     int userID;
     String name;
     String contactInformation;
     int borrowedBook = 0; // Number of books borrowed by user

    // Constructor to initialize user properties
    public User(int userID, String name, String contactInformation) {
        this.userID = userID;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    // Getters for user properties
    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInformation;
    }
}






       
    
    
       
