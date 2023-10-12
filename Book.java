//******************************************************************************************
// Book.java
//
// Josh Radford T00745233, September 25, 2023
//
// COMP 1231 Assignment 2 Question 1
// 
// This class initializes a Book object with a book code, title, price, and genre and 
// provides relevant Book helper functions.
//
//******************************************************************************************


public class Book implements Genre, PasswordLockable, Comparable<Book>
{
    private String bookCode, title, password;
    private int genre;
    private double price;
    private boolean bookIsLocked = false;

    // Default constructor for this Book without parameters
    public Book() {}

    // Constructor that initializes this Book with book code, title, genre and price
    public Book(String bookCode, String title, double price, int genre) 
    {
        if (bookCode.length() > 0)
        {
            this.bookCode = bookCode;
        }
        else
        {
            this.bookCode = "####";
        }

        if (title.length() > 0)
        {
            this.title = title;
        }
        else
        {
            this.title = "Unknown Title";
        }
        
        this.price = price;

        if (genre > 3 || genre < 0)
        {
            this.genre = UNCLASSIFIED;
        }
        else
        {
            this.genre = genre;
        }
    }

    // Accessor method for retreiving a Book's code
    public String getBookCode() 
    {
        return bookCode;
    }

    // Mutator method for setting a Book's code
    public void setBookCode(String bookCode) 
    {
        if (!bookIsLocked) 
        {
            this.bookCode = bookCode;
        }
        else
        {
            lockedMessage();
        }
    }

    // Accessor method for retreiving a Book's title
    public String getTitle() 
    {
        return title;
    }

    // Mutator method for setting a Book's title
    public void setTitle(String title) 
    {
        if (!bookIsLocked) 
        {
            
             this.title = title;
        }
        else
        {
            lockedMessage();
        }
    }

    // Accessor method for retreiving a Book's price
    public double getPrice() 
    {
        return price;
    }

    // Mutator method for setting a Book's price
    public void setPrice(double price) 
    {
        if (!bookIsLocked) 
        {
            this.price = price;
        }
        else
        {
            lockedMessage();
        }
    }

    // Accessor method for retreiving a Book's genre
    @Override
    public int getGenre() 
    {
        return genre;
    }

    // Mutator method for setting a Book's genre
    @Override
    public void setGenre(int genre) 
    {
        if (!bookIsLocked) 
        {
            this.genre = genre;
        }
        else
        {
            lockedMessage();
        }
    }

    // Method to convert the genre to a text description
    public String genreToString(int genre)
    {
        String convertedGenre;

        if (this.genre == ACTION)
        {
            convertedGenre = "Action";
        }
        else if (this.genre == COMEDY)
        {
            convertedGenre = "Comedy";
        }
        else if (this.genre == HORROR)
        {
            convertedGenre = "Horror";
        }
        else
        {
            convertedGenre = "Unclassified";
        }

        return convertedGenre;
    }

    // Mutator method for setting a Book's password
    @Override
    public void setPassword(String password) 
    {
        if (password.length() >= 6) {
            this.password = password;
        }
        else 
        {
            System.out.println("Invalid password format. Please choose a password of minimum 6 characters in length.");
        }
    }

    // Method to lock the Book
    @Override
    public void lock(String password)
    {
        if (bookIsLocked == true)
        {
            System.out.println("This book record is already locked.");
        }
        else
        {
            bookIsLocked = true;
            System.out.println("This book record is now locked.");
        }
    }

    // Method to unlock the Book
    @Override
    public void unlock(String password)
    {
        if (this.password == password)
        {
            bookIsLocked = false;
            System.out.println("Correct password. This book record is now unlocked.");
        }
        else
        {
            System.out.println("Incorrect password. This book record is still locked.");
        }
        
    }

    // Method to check to see if a Book is currently locked
    @Override
    public boolean isLocked()
    {
        if (bookIsLocked == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Method to print a locked message to the system
    private void lockedMessage()
    {
        System.out.println("This book record is locked! No update performed.");
    }

    // Method to compare prices of two books. Returns 0 if equal, -1 if current book is less than compared book, or 1 if greater than.
    @Override
    public int compareTo(Book secondBook) {
        int result = 0;

        if (this.price < secondBook.getPrice())
        {
            result = -1;
        }
        else if (this.price > secondBook.getPrice())
        {
            result = 1;
        }
        
        return result;
    }

    // Returns a description of this Book's details as a readable String
    public String toString()
    {
        return String.format("Book Code: %s", bookCode) + 
               String.format("  Title: %s", title) +
               String.format("  Price: %.2f", price) + 
               String.format("  Genre: %s", genreToString(genre));
    }
}
