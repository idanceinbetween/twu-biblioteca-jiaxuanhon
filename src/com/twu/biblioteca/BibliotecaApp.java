package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    // DECLARE and instantiate ArrayList<Book> books
    ArrayList<Book> books = new ArrayList<Book>();
    String userInput;

    // DECLARE createBooks() method to initialise Book objects.
    public ArrayList<Book> createBooks() {
        Book sunfall = new Book(); //CAN WE INSTANTIATE A BIT MORE EFFICIENTLY?
        sunfall.setTitle("Sunfall");
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
        System.out.println("What would you like to view today? Use your keyboard to select a number.");
        System.out.println("1: List of Books");
        System.out.println("0: Quit App");
        userInput = getUserInput();
        selectMainMenuOption(userInput);
    }

    public String getUserInput(){
        Scanner myObj = new Scanner(System.in);
        String userChoice = myObj.nextLine();
        return userChoice;
    }

    public void selectMainMenuOption(String userInput) {
        switch (Integer.parseInt(userInput)) {
            case 1:
                showBooks();
                bookListMenu();
                userInput = getUserInput();
                selectBookListMenuOption(userInput);
                break;
            case 0:
                quitApp();
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
                System.out.format(leftAlignFormat, books.indexOf(book) + 1, book.getTitle(), book.getAuthor(), book.getYear());
            }
        } else {
            System.out.format("| There are no books available for check out.           |%n");
        }

        System.out.format("+----+----------------------+--------------------+------|%n");
    }

    public void bookListMenu() {
        System.out.println("Please enter the title of the book you want to checkout. Or, press 0 to return to main menu.");
    }

    public void selectBookListMenuOption(String userInput){
        if (userInput.equals("0")) {
            mainMenu();
        } else { //check out by typing book title
            Book foundBook = null;
            foundBook = findBookByTitle(userInput);
            if (foundBook != null) {
                foundBook.setCheckOut();
                System.out.println("Thank you! Enjoy the book");
                mainMenu();
            } else {
                System.out.println("Sorry, that book is not available.");
            }
        }
    }

    public Book findBookByTitle(String title){
        String queryTitleCased = convertToTitleCase(title);
        Book foundBook = null;
        for (Book book : books){
            if (book.getTitle().equals(queryTitleCased)) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    public String convertToTitleCase(String str){
        char[] chars = str.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') {
                found = false;
            }
        }
        return String.valueOf(chars);
    }

    // DECLARE checkOut(bookObject) method to check out a book.

    // DECLARE return(bookObject) method to return a book.

    // DECLARE quitApp() method to quit the App.
    public void quitApp(){
        System.exit(0);
    }

    public void run() {
        // Create books and show list of books 1.2
        createBooks();
        // View welcome message 1.1
        welcome();
        // View Menu 1.4 (one option only "List of Books")
        mainMenu();
        // Check out a book 1.7 > checkout success > return to 1.2
        // Return a book 1.10 > return success > return to 1.2
        // Quit the app 1.6 (by hitting Esc?)
    }
}
