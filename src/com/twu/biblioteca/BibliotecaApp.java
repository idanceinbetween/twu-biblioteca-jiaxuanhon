package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();
    String userInput;

    public ArrayList<Book> createBooks() {
        Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
        Book leanImpact = new Book("Lean Impact", "Ann Mei Chang", "2018");
        Book exploreEverything = new Book("Explore Everything", "Bradley Garrett", "2013");

        books.add(sunfall);
        books.add(leanImpact);
        books.add(exploreEverything);

        return books;
    }

    public ArrayList<Movie> createMovies() {
        Movie wonderWoman = new Movie("Wonder Woman", "2017", "Patty Jenkins");
        Movie theHateYouGive = new Movie("The Hate U Give", "2018", "George Tillman Jr.");
        Movie theCrossing = new Movie("The Crossing", "2018", "Bai Xue");

        movies.add(wonderWoman);
        movies.add(theHateYouGive);
        movies.add(theCrossing);

        return movies;
    }

    public void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
    }

    public void mainMenu() {
        System.out.println("What would you like to view today? Use your keyboard to select a number.");
        System.out.println("1: List of Books");
        System.out.println("0: Quit App");
        userInput = getUserInput();
        actionAtMainMenu(userInput);
    }

    public String getUserInput(){
        Scanner myObj = new Scanner(System.in);
        String userInput = myObj.nextLine();
        return userInput;
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> books){
        ArrayList<Book> results = new ArrayList<Book>();
        for ( Book book : this.books){
            if (!book.getCheckedOutStatus()) { results.add(book);};
        }
        return results;
    }

    public ArrayList<Book> getCheckedOutBooks(ArrayList<Book> books){
        ArrayList<Book> results = new ArrayList<Book>();
        for ( Book book : books){
            if (book.getCheckedOutStatus()) { results.add(book);};
        }
        return results;
    }

    public ArrayList<Movie> getAvailableMovies(ArrayList<Movie> movies){
        ArrayList<Movie> results = new ArrayList<Movie>();
        for ( Movie movie : movies){
            if (!movie.getCheckedOutStatus()) { results.add(movie);};
        }

        return results;
    }

    public ArrayList<Movie> getCheckedOutMovies(ArrayList<Movie> movies){
        ArrayList<Movie> results = new ArrayList<Movie>();
        for ( Movie movie : this.movies){
            if (movie.getCheckedOutStatus()) { results.add(movie);};
        }
        return results;
    }

    public void actionAtMainMenu(String userInput) {
        if (userInput.equals("1")) {
            ArrayList<Book> availableBooks = getAvailableBooks(books);
            showBooks(availableBooks);
            askForActionAtBookList();
            userInput = getUserInput();
            actionAtBookList(userInput);
        } else if (userInput.equals("0")) {
            quitApp();
        } else {
            System.out.println("Please select a valid option!");
            mainMenu();
        }
    }

    public void showBooks(ArrayList<Book> books) {
        String leftAlignFormat = "| %-20s | %-18s | %-4s |%n";

        System.out.format("+----------------------+--------------------+------+%n");
        System.out.format("| Book Title           | Author             | Year |%n");
        System.out.format("+----------------------+--------------------+------|%n");

        if (books.size() != 0) {
            for (Book book : books) {
                System.out.format(leftAlignFormat, book.getTitle(), book.getAuthor(), book.getYear());
            }
        } else {
            System.out.format("| There are no books available for check out.      |%n");
        }

        System.out.format("+----------------------+--------------------+------|%n");
    }

    public void askForActionAtBookList() {
        System.out.println("Please enter the title of the book you want to checkout. Please press R to return a book, or 0 to return to main menu.");
    }

    public void actionAtBookList(String userInput){
        if (userInput.equals("0")) {
            mainMenu();
        } else if (userInput.equals("R") || userInput.equals("r")) {
            askForBookTitleToReturn();
            userInput = getUserInput();
            if (userInput.equals("0")){mainMenu();} else {actionReturnBook(userInput);}
        } else {
            actionCheckOutBook(userInput);
        }
    }

    private void askForBookTitleToReturn(){
        System.out.println("Please enter the title of the book you want to return, or press 0 to return to main menu.");
    }

    private void actionCheckOutBook(String userInput){
        Book foundBook = null;
        ArrayList<Book> availableBooks = getAvailableBooks(books);
        foundBook = getBookByTitle(userInput, availableBooks);
        if (foundBook == null) {
            System.out.println("Sorry, that book is not available.");
            mainMenu();
        } else {
            foundBook.setCheckOut();
            System.out.println("Thank you! Enjoy the book");
            mainMenu();
        }
    }

    public void actionReturnBook(String userInput){
        Book foundBook = null;
        ArrayList<Book> checkedOutBooks = getCheckedOutBooks(books);
        foundBook = getBookByTitle(userInput, checkedOutBooks);
        if (foundBook == null) {
            System.out.println("That is not a valid book to return.");
            mainMenu();
        } else {
            foundBook.setReturn();
            System.out.println("Thank you for returning the book.");
            mainMenu();
        }
    }

    public Book getBookByTitle(String title, ArrayList<Book> booksList){
        String queryTitleCased = convertToTitleCase(title);
        Book foundBook = null;
        for (Book book : booksList){
            if (book.getTitle().equals(queryTitleCased)) {
                foundBook = book;
            }
        }
        return foundBook;
    }

    public void showMovies(ArrayList<Movie> movies) {
        String leftAlignFormat = "| %-20s | %-4s | %-18s | %-6s |%n";

        System.out.format("+----------------------+------+--------------------+--------+%n");
        System.out.format("| Movie Name           | Year | Director           | Rating |%n");
        System.out.format("+----------------------+------+--------------------+--------+%n");

        if (movies.size() != 0) {
            for (Movie movie : movies) {
                System.out.format(leftAlignFormat, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating());
            }
        } else {
            System.out.format("| There are no movies available for check out.      |%n");
        }

        System.out.format("+----------------------+------+--------------------+--------+%n");
    }


    private String convertToTitleCase(String str){
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

    private void quitApp(){
        System.exit(0);
    }

    public void run() {
        createBooks();
        welcome();
        mainMenu();
    }
}
