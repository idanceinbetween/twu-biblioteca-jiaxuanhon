package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
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
        absoluteProof.setTitle("Lean Impact");
        absoluteProof.setAuthor("Ann Mei Chang");
        absoluteProof.setYear("2018");

        Book angelsAndDemons = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        angelsAndDemons.setTitle("Explore Everything");
        angelsAndDemons.setAuthor("Bradley Garrett");
        angelsAndDemons.setYear("2013");

        books.add(sunFall);
        books.add(absoluteProof);
        books.add(angelsAndDemons);

        return books;
    }

    // DECLARE welcome() method, after initiation to display welcome message.
    public void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
    }

    // DECLARE mainMenu() method, show menu and ask for user input.

    // DECLARE showBooks() method that display books available with title, author and year. Ask for user input.
    // DECLARE checkOut(bookObject) method to check out a book.

    // DECLARE return(bookObject) method to return a book.

    // DECLARE quitApp() method to quit the App.

    public void start() {
        createLibrary();
        welcome();
    }

//    public void main(String[] args) {
        // Create books
//        createLibrary();
        // View welcome message 1.1
//        welcome();
        // View Menu 1.4 (one option only "List of Books")
//        mainMenu();
        // View list of books 1.2
        // Check out a book 1.7 > checkout success > return to 1.2
        // Return a book 1.10 > return success > return to 1.2
        // Quit the app 1.6 (by hitting Esc?)
//    }
}
