package com.twu.biblioteca;
import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    ArrayList<Book> books = new ArrayList<Book>();
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<User> users = new ArrayList<User>();
    User user = null;
    ArrayList<Book> myBookLoans = new ArrayList<Book>();
    ArrayList<Movie> myMovieLoans = new ArrayList<Movie>();
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

    public ArrayList<User> createUsers(){
        User user = new User("000-0001", "password");
        user.setNameEmailPhone("Alex Hopper", "alex@hopper.com", "012-1010293");
        users.add(user);
        return users;
    }

    public void welcome() {
        System.out.println("Welcome to Biblioteca. Your one-stop shop for great book titles in Bangalore!");
        System.out.println("Please login to start.");
    }

    private void loginMenu(){ //TODO Flow
        getLibraryNumber();
        String libraryNumberStr = getUserInput();
        getPassword();
        String password = getUserInput();
        user = User.login(libraryNumberStr,password);
        afterLoginMenu();
    }

    public void afterLoginMenu(){ //TODO Flow
        while (user == null){
            loginMenu();
        }
        mainMenu();
    }

    public void getLibraryNumber() {
        System.out.println("Please enter your library number (Format: xxx-xxxx) (Default user: 000-0001):");
    }

    public void getPassword() {
        System.out.println("Please enter your password: (Default password: password)");
    }

    public void mainMenu() {
        System.out.println("What would you like to view today? Use your keyboard to select a number.");
        System.out.println("1: List of Books");
        System.out.println("2: List of Movies");
        System.out.println("3: View My Book Loans");
        System.out.println("4: View My Movie Loans");
        System.out.println("00: View Account Information");
        System.out.println("0: Quit App");
        userInput = getUserInput();
        actionAtMainMenu(userInput);
    }

    public String getUserInput(){
        Scanner myObj = new Scanner(System.in); //TODO stub/override user input (simulate) testing
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

    public void actionAtMainMenu(String userInput) { //TODO Flow
        if (userInput.equals("1")) {
            ArrayList<Book> availableBooks = getAvailableBooks(books);
            showBooks(availableBooks);
            askForActionAtBookList();
            userInput = getUserInput();
            actionAtBookList(userInput);
        } else if (userInput.equals("2")){
            ArrayList<Movie> availableMovies = getAvailableMovies(movies);
            showMovies(availableMovies);
            askForActionAtMoviesList();
            userInput = getUserInput();
            actionAtMovieList(userInput);
        } else if (userInput.equals("3")){
            myBookLoans = user.getBookLoans();
            showBooks(myBookLoans);
            askForBookTitleToReturn();
            userInput = getUserInput();
            if (userInput.equals("0")){mainMenu();} else {actionReturnBook(userInput);}
            mainMenu();
        } else if (userInput.equals("4")){
            myMovieLoans = user.getMovieLoans();
            showMovies(myMovieLoans);
            askForMovieNameToReturn();
            userInput = getUserInput();
            if (userInput.equals("0")){mainMenu();} else {actionReturnMovie(userInput);}
            mainMenu();
        } else if (userInput.equals("00")){
            user.viewMyInfo();
            mainMenu();
        } else if (userInput.equals("0")) {
            quitApp();
        } else {
            System.out.println("Please select a valid option!");
            mainMenu();
        }
    }

    public void showBooks(ArrayList<Book> books) { // "return" & printing in the same function
        String leftAlignFormat = "| %-20s | %-18s | %-4s |%n";

        System.out.format("+----------------------+--------------------+------+%n");
        System.out.format("| Book Title           | Author             | Year |%n");
        System.out.format("+----------------------+--------------------+------|%n");

        if (books.size() != 0) {
            for (Book book : books) {
                System.out.format(leftAlignFormat, book.getTitle(), book.getAuthor(), book.getYear());
            }
        } else {
            System.out.format("| There are no books available.                   |%n");
        }

        System.out.format("+----------------------+--------------------+------|%n");
    }

    public void askForActionAtBookList() {
        System.out.println("Please enter the title of the book you want to checkout, or press 0 and Enter to return to main menu.");
    }

    public void actionAtBookList(String userInput){ //TODO Flow
        if (userInput.equals("0")) {
            mainMenu();
        } else {
            actionCheckOutBook(userInput);
        }
    }

    private void askForBookTitleToReturn(){
        System.out.println("Please enter the title of the book you want to return, or press 0 and Enter to return to main menu.");
    }

    private void actionCheckOutBook(String userInput){ //TODO Flow
        Book foundBook = null;
        ArrayList<Book> availableBooks = getAvailableBooks(books);
        foundBook = getBookByTitle(userInput, availableBooks);
        if (foundBook == null) {
            System.out.println("Sorry, that book is not available.");
            mainMenu();
        } else {
            user.checkOutBook(foundBook);
            System.out.println("Thank you! Enjoy the book");
            mainMenu();
        }
    }

    public void actionReturnBook(String userInput){ //TODO Flow
        Book foundBook = null;
        ArrayList<Book> checkedOutBooks = getCheckedOutBooks(books);
        foundBook = getBookByTitle(userInput, checkedOutBooks);
        if (foundBook == null) {
            System.out.println("That is not a valid book to return.");
            mainMenu();
        } else {
            user.returnBook(foundBook);
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
            System.out.format("| There are no movies available.                            |%n");
        }

        System.out.format("+----------------------+------+--------------------+--------+%n");
    }


    public void askForActionAtMoviesList() {
        System.out.println("Please enter the name of the movie you want to checkout, or press 0 and Enter to return to main menu.");
    }

    public void actionAtMovieList(String userInput){ //TODO Flow
        if (userInput.equals("0")) {
            mainMenu();
        } else {
            actionCheckOutMovie(userInput);
        }
    }

    public Movie getMovieByName(String name, ArrayList<Movie> moviesList){
        String queryTitleCased = convertToTitleCase(name);
        Movie foundMovie = null;
        for (Movie movie : moviesList){
            if (movie.getName().equals(queryTitleCased)) {
                foundMovie = movie;
            }
        }
        return foundMovie;
    }

    private void askForMovieNameToReturn(){
        System.out.println("Please enter the name of the movie you want to return, or press 0 and Enter to return to main menu.");
    }

    private void actionCheckOutMovie(String userInput){ //TODO Flow
        Movie foundMovie = null;
        ArrayList<Movie> availableMovies = getAvailableMovies(movies);
        foundMovie = getMovieByName(userInput, availableMovies);
        if (foundMovie == null) {
            System.out.println("Sorry, that movie is not available.");
            mainMenu();
        } else {
            user.checkOutMovie(foundMovie);
            System.out.println("Thank you! Enjoy the movie");
            mainMenu();
        }
    }

    public void actionReturnMovie(String userInput){ //TODO Flow
        Movie foundMovie = null;
        ArrayList<Movie> checkedOutMovies = getCheckedOutMovies(movies);
        foundMovie = getMovieByName(userInput, checkedOutMovies);
        if (foundMovie == null) {
            System.out.println("That is not a valid movie to return.");
            mainMenu();
        } else {
            user.returnMovie(foundMovie);
            System.out.println("Thank you for returning the movie.");
            mainMenu();
        }
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

    public void run() { //TODO Flow
        createBooks();
        createMovies();
        createUsers();
        welcome();
        loginMenu();
    }
}
