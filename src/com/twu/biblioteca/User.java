package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    String name;
    String email;
    String phoneNumber;
    ArrayList<Book> loanedBooks = new ArrayList<Book>();
    static ArrayList<User> users = new ArrayList<User>();

    public User(String numberStr, String passwordStr) {
        libraryNumber = numberStr;
        password = passwordStr;
        User.all().add(this);
    }

    public static ArrayList<User> all(){
        return User.users;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }

    public void setNameEmailPhone(String nameStr, String emailStr, String phoneStr){
        name = nameStr;
        email = emailStr;
        phoneNumber = phoneStr;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public static User findUserByLibraryNumber(String libraryNumberStr){
        User foundUser = null;
        for (User user : User.all()) {
            if (user.getLibraryNumber().equals(libraryNumberStr)) {
                foundUser = user;
            }}
        return foundUser;
    }

    public static Boolean login(String libraryNumberStr, String passwordStr){ //TODO Change to more secure login
        User user = null;
        Boolean result = false;
        user = User.findUserByLibraryNumber((libraryNumberStr));
        if (user != null) {
            if (passwordStr.equals(user.getPassword()))
            result = true;
            else {
                 User.loginFail();
            }}
        else {
            User.loginFail();
        }
        return result;
    }

    private String getPassword() {//TODO Change to more secure login
        return password;
    }

    public static void loginFail(){
        System.out.println("Sorry, user and password combination is incorrect.");
    }

    public void checkOutBook(Book book){
        book.setCheckOut();
        book.setLoaner(this);
        loanedBooks.add(book);
    }

    public ArrayList<Book> getBookLoans(){
        return loanedBooks;
    }

    public void returnBook(Book book){
        book.setReturn();
        book.removeLoaner(this);
        int index = loanedBooks.indexOf(book);
        loanedBooks.remove(index);
    }

}
