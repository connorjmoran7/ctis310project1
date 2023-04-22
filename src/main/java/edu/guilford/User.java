package edu.guilford;

import java.util.Random;
import java.util.Scanner;

public class User {

    // Create a random object to generate random numbers
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    // User Attributes

    private String firstName;
    private String lastName;
    private String email;
    private String birthYear;
    private int birthMonth;
    private int favNumber;
    private char symbol;

    // Symbol Array
    private char[] symbolArray = { '!', '@', '#', '$', '%', '^', '&', '*' };

    // Password Attribute

    private String password;

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getFavNumber() {
        return favNumber;
    }

    public void setFavNumber(int favNumber) {
        this.favNumber = favNumber;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        birthYear = "";
        birthMonth = 0;
        favNumber = 0;
        symbol = symbolArray[rand.nextInt(8)];
    }

    public User(String firstName, String lastName, String email, String birthYear, int birthMonth,
            int favNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthYear = birthYear;
        this.birthMonth = birthMonth;
        this.favNumber = favNumber;
        symbol = symbolArray[rand.nextInt(8)];
    }

    // Create a password using the user's attributes

    public void createPassword() {
        String tempPassword = "";
        tempPassword += firstName.substring(0, 2);
        tempPassword += lastName.substring(0, 2);
        tempPassword += birthMonth;
        tempPassword += email.substring(email.length() - 3);
        tempPassword += birthYear.substring(birthYear.length() - 2);
        tempPassword += favNumber;
        tempPassword += symbol;

        setPassword(tempPassword);
    }

    // Get all of the information from the user using a scanner

    public void getUserInfo() {

        System.out.println("\nPlease enter your first name: ");
        setFirstName(input.nextLine());

        System.out.println("Please enter your last name: ");
        setLastName(input.nextLine());

        System.out.println("Please enter your email: ");
        setEmail(input.nextLine());

        System.out.println("Please enter your birth year: ");
        setBirthYear(input.nextLine());

        System.out.println("Please enter your birth month: ");
        setBirthMonth(input.nextInt());

        System.out.println("Please enter your favorite number: ");
        setFavNumber(input.nextInt());

    }

}
