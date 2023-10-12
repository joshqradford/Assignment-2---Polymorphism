//******************************************************************************************
// BookApplication.java
//
// Josh Radford T00745233, September 25, 2023
//
// COMP 1231 Assignment 2 Question 1
// 
// This class serves as a driver class to test functionality of the book records application.
//
//******************************************************************************************


public class BookApplication
{

    public static void main(String[] args) 
    {
        double highestPrice = 0;

        // Create an array of Books that stores 4 book objects
        Book[] bookList = new Book[4];

        // Create and initialize 4 Book objects with book code, title, price, and genre for demonstration.
        bookList[0] = new Book("R001", "Unknown Title", 0.0, Genre.UNCLASSIFIED);
        bookList[1] = new Book("X001", "Rocket Man", 123.45, Genre.ACTION);
        bookList[2] = new Book("Y002", "Wedding Party", 88.94, Genre.COMEDY);
        bookList[3] = new Book("Z003", "Haunted House", 200.99, Genre.HORROR);

        // Printing out all of the Book's details in a readable format.
        System.out.println("Creating 4 book records...");
        for (Book book: bookList)
        {
            System.out.println(book.toString());
        }

        System.out.println();

        // Setting up a password and providing verification that it's been completed.
        System.out.println("Setting up a password... The password is: ABC123");
        for (Book book : bookList)
        {
            book.setPassword("ABC123");
        }
        System.out.println("A password has been set up.\n");

        // Printing out the details of the first book
        System.out.println("The first book record is: " + bookList[0].toString() + "\n");

        // Locking the first book
        System.out.println("Locking the first book record using the password ABC123...");
        bookList[0].lock("ABC123");
        System.out.println();

        // Trying to mutate a locked a record to (display locking functionality)
        System.out.println("Attempting to change the price of the first book record...");
        bookList[0].setPrice(456.78);
        System.out.println();

        // Trying to unlock the first book using an incorrect password (other than ABC123)
        System.out.println("Attempting to unlock the book record with the wrong password XYZ456...");
        bookList[0].unlock("XYZ456");
        System.out.println();

        // Trying to unlock the first book using an the correct password (ABC123)
        System.out.println("Attempting to unlock the book record with the correct password ABC123...");
        bookList[0].unlock("ABC123");
        System.out.println();

        // Updating the first books attributes while it's unlocked
        System.out.println("Updating the first book record's title, price, and genre...");
        bookList[0].setTitle("Kung Fu Hero");
        bookList[0].setPrice(200.99);
        bookList[0].setGenre(Genre.ACTION);
        System.out.println(bookList[0].toString() + "\n");

        // Finding book record(s) in the bookList array with the highest price using Comparable method
        System.out.println("List of books that have the highest price:");
        
        int index = 0;
        for (int i = 1; i < bookList.length; i++)
        {
            Book currentBook = bookList[i];
            Book lastBook = bookList[index];

            if (lastBook.compareTo(currentBook) < 0)
            {
                highestPrice = currentBook.getPrice();
            }

            index++;
        }
        
        // Printing book record(s) with the highest price
        for (Book book : bookList)
        {
            if (book.getPrice() == highestPrice)
            {
                System.out.println(book.toString());
            }
        }

        //******************************************************************************************
        // ADDITIONAL TEST CASES
        //******************************************************************************************
        System.out.println();

        // Setting up a password of incorrect length (under 6 characters)
        System.out.println("Setting up a password... The password is: ABC");
        bookList[0].setPassword("ABC");
        System.out.println();

        // Creating a book with empty, 0, or invalid parameters
        Book emptyBook = new Book("", "", 0, 99);
        System.out.println("Creating a new book with no book code, no title, 0 price, and invalid genre (99)");
        System.out.println(emptyBook.toString());
        System.out.println();

        // Trying to lock a book that's already locked
        emptyBook.setPassword("ABC123");
        System.out.println("Locking the first book record using the password ABC123...");
        emptyBook.lock("ABC123");
        System.out.println("Trying to lock it again using the password ABC123...");
        emptyBook.lock("ABC123");

    }
}
