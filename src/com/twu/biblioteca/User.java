package com.twu.biblioteca;

public class User {
    String libraryNumber;
    String password;

    public User(String numberStr, String passwordStr) {
        libraryNumber = numberStr;
        password = passwordStr;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }
}
