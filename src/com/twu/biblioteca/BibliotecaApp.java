package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    // DECLARE and instantiate ArrayList<Book> library
    ArrayList<Book> books = new ArrayList<Book>();

    // DECLARE createLibrary() method to initialise Book objects.
    public ArrayList<Book> createLibrary() {
        Book sunFall = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        sunFall.setTitle("Sun Fall");
        sunFall.setAuthor("Jim Al-Khalil");
        sunFall.setYear("2019");

        Book absoluteProof = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        absoluteProof.setTitle("Absolute Proof");
        absoluteProof.setAuthor("James Someone");
        absoluteProof.setYear("2009");

        Book angelsAndDemons = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        angelsAndDemons.setTitle("Angels and Demons");
        angelsAndDemons.setAuthor("Dan Brown");
        angelsAndDemons.setYear("1999");

        books.add(sunFall);
        books.add(absoluteProof);
        books.add(angelsAndDemons);

        return books;
    }

    // DECLARE welcome() method to display welcome message and menu to the user. Ask for user input.

    // DECLARE showBooks() method that display books available with title, author and year. Ask for user input.

    // DECLARE checkOut(bookObject) method to check out a book.

    // DECLARE return(bookObject) method to return a book.

    // DECLARE quitApp() method to quit the App.

    public static void main(String[] args) {

        // Create books

    }
}
