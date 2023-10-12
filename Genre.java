//******************************************************************************************
// Genre.java
//
// Josh Radford T00745233, September 25, 2023
//
// COMP 1231 Assignment 2 Question 1
// 
// This class sets up a Genre interface that defines four genre constants and getter/
// setter methods for Genre.
//
//******************************************************************************************

public interface Genre
{
    final int UNCLASSIFIED = 0, ACTION = 1, COMEDY = 2, HORROR = 3;


    // Abstract mutator method for setting genre
    public void setGenre(int genre);

    // Abstract accessor method for getting genre
    public int getGenre();

}