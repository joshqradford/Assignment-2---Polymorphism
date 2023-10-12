//******************************************************************************************
// PasswordLockable.java
//
// Josh Radford T00745233, September 25, 2023
//
// COMP 1231 Assignment 2 Question 1
// 
// This class sets up a PasswordLockable interface that defines abstract methods for 
// password protected objects.
//
//******************************************************************************************


public interface PasswordLockable 
{
    // Abstract mutator method for setting a password
    public void setPassword(String password);

    // Abstract mutator method for locking an object
    public void lock(String password);

    // Abstract mutator method for unlocking an object
    public void unlock(String password);

    // Abstract accessor method for checking if an object is locked
    public boolean isLocked();

}
