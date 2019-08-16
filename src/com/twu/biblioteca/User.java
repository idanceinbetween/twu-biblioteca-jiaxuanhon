package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    String libraryNumber;
    String password;
    String name;
    String email;
    String phoneNumber;
    ArrayList<Book> loanedBooks = new ArrayList<Book>();
    ArrayList<Movie> loanedMovies = new ArrayList<Movie>();
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

    public String getName() {
        if (name != null) return name;
        else return "No name provided";
    }

    public String getEmail(){
        if (email != null) return email; else return "No email provided.";
    }

    public String getPhoneNumber(){
        if (phoneNumber != null) return phoneNumber; else return "No phone number provided.";
    }

    public static User findUserByLibraryNumber(String libraryNumberStr){
        User foundUser = null;
        for (User user : User.all()) {
            if (user.getLibraryNumber().equals(libraryNumberStr)) {
                foundUser = user;
            }}
        return foundUser;
    }

    public static User login(String libraryNumberStr, String passwordStr){ //TODO Change to more secure login
        User user = null;
        Boolean result = false;
        user = User.findUserByLibraryNumber((libraryNumberStr));
        if (user != null) {
            if (passwordStr.equals(user.getPassword())) {
                User.loginSuccess();
            } else {
                user = null;
                User.loginFail();
            }
        } else {
            User.loginFail();
        }
        return user;
    }

    private String getPassword() {//TODO Change to more secure login
        return password;
    }

    public static void loginFail(){
        System.out.println("Sorry, user and password combination is incorrect.");
    }

    public static void loginSuccess(){
        System.out.println("Login successful.");
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

    public void checkOutMovie(Movie movie){
        movie.setCheckOut();
        movie.setLoaner(this);
        loanedMovies.add(movie);
    }

    public ArrayList<Movie> getMovieLoans(){
        return loanedMovies;
    }

    public void returnMovie(Movie movie){
        movie.setReturn();
        movie.removeLoaner(this);
        int index = loanedMovies.indexOf(movie);
        loanedMovies.remove(index);
    }

    public void viewMyInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Telephone Number: " + getPhoneNumber());
    }
}
