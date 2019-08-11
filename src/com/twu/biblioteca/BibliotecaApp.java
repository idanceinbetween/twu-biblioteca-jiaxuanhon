package com.twu.biblioteca;

import sun.jvm.hotspot.debugger.cdbg.CDebugger;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // DECLARE and instantiate ArrayList<Book> library
    ArrayList<Book> books = new ArrayList<Book>();

    // DECLARE createLibrary() method to initialise Book objects.
    public ArrayList<Book> createLibrary() {
        Book sunfall = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        sunfall.setTitle("Sun Fall");
        sunfall.setAuthor("Jim Al-Khalil");
        sunfall.setYear("2019");

        Book leanImpact = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        leanImpact.setTitle("Lean Impact");
        leanImpact.setAuthor("Ann Mei Chang");
        leanImpact.setYear("2018");

        Book exploreEverything = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        exploreEverything.setTitle("Explore Everything");
        exploreEverything.setAuthor("Bradley Garrett");
        exploreEverything.setYear("2013");

        books.add(sunfall);
        books.add(leanImpact);
        books.add(exploreEverything);

        return books;
    }

    // DECLARE welcome() method, after initiation to display welcome message.
    public void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
    }

    // DECLARE mainMenu() method, show menu and ask for user input.
    public void mainMenu() {
        System.out.println("What would you like to view today?");
        System.out.println("List of books: Press 1");
        Scanner myObj = new Scanner(System.in);
        String userChoice = myObj.nextLine();
        selectMainMenuOption(userChoice);
    }

    public void selectMainMenuOption(String userChoice) {
        switch (Integer.parseInt(userChoice)) {
            case 1:
                showBooks();
                break;
            default:
                // User selected invalid option .
                System.out.println("Please select a valid option!");
        }
    }

    // DECLARE showBooks() method that display books available with title, author and year. Ask for user input.
    public void showBooks() {
        String leftAlignFormat = "| %-2d | %-20s | %-18s | %-4s |%n";

        System.out.format("+----+----------------------+--------------------+------+%n");
        System.out.format("| No | Book Title           | Author             | Year |%n");
        System.out.format("+----+----------------------+--------------------+------|%n");

        if (books.size() != 0) {
            for (Book book : books) {
                System.out.format(leftAlignFormat, books.indexOf(book)+1, book.getTitle(), book.getAuthor(), book.getYear());
            }
        } else {
            System.out.format("There are no books available for check out.");
        }

        System.out.format("+----+----------------------+--------------------+------|%n");
    }

    // DECLARE
    // DECLARE checkOut(bookObject) method to check out a book.

    // DECLARE return(bookObject) method to return a book.

    // DECLARE quitApp() method to quit the App.
    public void quitApp(){
        System.exit(0);
    }

    public void run() {
        // Create books and show list of books 1.2
        createLibrary();
        // View welcome message 1.1
        welcome();
        // View Menu 1.4 (one option only "List of Books")
        mainMenu();
        // Check out a book 1.7 > checkout success > return to 1.2
        // Return a book 1.10 > return success > return to 1.2
        // Quit the app 1.6 (by hitting Esc?)
    }
}
