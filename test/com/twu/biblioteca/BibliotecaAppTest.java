package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaAppTest {

    private BibliotecaApp app;
    private ArrayList books;
    private ArrayList availableBooks;
    private ArrayList movies;
    private ArrayList availableMovies;
    private User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        books = app.createBooks();
        movies = app.createMovies();
        user = new User("000-0001", "password");
        user = User.login("000-0001", "password");
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void canCreateLibraryWithBookObjects() {
        Assert.assertTrue(books.size() > 0);
    }

    // 1.1
    @Test
    public void welcomeHasWelcomeMessage() {
        try {
            System.setOut(new PrintStream(outContent));
            app.welcome();
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("There is no welcome message (with line break).", outContent.size() > 1);
    }

    // 1.2
    @Test
    public void hasSomethingToShowInBooksListOption() {
        availableBooks = app.getAvailableBooks(books);
        if (availableBooks.size() > 0) { // if there is at least one book showing
            Book sampleBook = (Book) availableBooks.get(1);
            String sampleBookTitle = sampleBook.getTitle();
            try {
                System.setOut(new PrintStream(outContent));
                app.showBooks(availableBooks);
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure books are showing in Books List.", outContent.toString().contains(sampleBookTitle));
        } else {
            try {
                System.setOut(new PrintStream(outContent));
                app.showBooks(availableBooks); // no books are in available in ArrayList.
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure there is a message with the phrase 'no books available' on Books List.", outContent.toString().contains("no books available"));
        }
    }

    // 1.3
    @Test
    public void authorIsShowingOnBooksList() {
        availableBooks = app.getAvailableBooks(books);
        if (availableBooks.size() > 0) { // if there is at least one book showing
            Book sampleBook = (Book) availableBooks.get(1);
            String sampleBookAuthor = sampleBook.getAuthor();
            try {
                System.setOut(new PrintStream(outContent));
                app.showBooks(availableBooks);
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure author is showing on Books List.", outContent.toString().contains(sampleBookAuthor));
        }
    }

    //1.3
    @Test
    public void yearIsShowingOnBooksList() {
        availableBooks = app.getAvailableBooks(books);
        if (availableBooks.size() > 0) { // if there is at least one book showing
            Book sampleBook = (Book) availableBooks.get(1);
            String sampleBookYear = sampleBook.getYear();
            try {
                System.setOut(new PrintStream(outContent));
                app.showBooks(availableBooks);
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure year is showing on Books List.", outContent.toString().contains(sampleBookYear));
        }
    }

    // 1.5
    @Test
    public void selectInvalidOptionMainMenu() {
        try {
            System.setOut(new PrintStream(outContent));
            app.actionAtMainMenu("3");
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("No error message is displayed when user selected invalid option in Main Menu.", outContent.size() > 1);
    }

    //1.7
    @Test
    public void userCanCheckOutBook(){
        Book sampleBook = (Book) books.get(1);
        sampleBook.setCheckOut();
        Assert.assertTrue(sampleBook.getCheckedOutStatus() == true);
    }

    //1.7
    @Test
    public void checkedOutBookIsNotOnShowBooks(){
        Book book1 = (Book) books.get(1);
        book1.setCheckOut();
        availableBooks = app.getAvailableBooks(books);
        try {
            System.setOut(new PrintStream(outContent));
            app.showBooks(availableBooks);
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("Checked out books should not appear in the list of all library books", !outContent.toString().contains(book1.getTitle()));
    }

    //1.9
    @Test //TODO this test gets stuck! Separate out logic and printing IO
    public void unsuccessfulMessageOnCheckoutOfABook() {
        try {
            System.setOut(new PrintStream(outContent));
            app.actionAtBookList("Not a Real Book"); // this function should maybe return a "false" and then
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("Make sure there is an unsuccessful message on checkout of book.", outContent.size() > 1);
    }

    //1.10
    @Test
    public void userCanReturnBook(){
        Book sampleBook = (Book) books.get(0);
        sampleBook.setReturn();
        Assert.assertTrue(sampleBook.getCheckedOutStatus()==false);
    }

    // 2.1
    @Test
    public void hasSomethingToShowInMoviesListOption() {
        availableMovies = app.getAvailableMovies(movies);
        if (availableMovies.size() > 0) {
            Movie sampleMovie = (Movie) availableMovies.get(1);
            String sampleMovieTitle = sampleMovie.getName();
            try {
                System.setOut(new PrintStream(outContent));
                app.showMovies(availableMovies);
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure movies are showing in Movies List.", outContent.toString().contains(sampleMovieTitle));
        } else {
            try {
                System.setOut(new PrintStream(outContent));
                app.showMovies(availableMovies);
            } finally {
                System.setOut(originalOut);
            }
            Assert.assertTrue("Make sure there is a message with the phrase 'no movies available' on Movies List.", outContent.toString().contains("no movies available"));
        }
    }

    //2.4
    @Test
    public void userCanViewUserInformation() {
        try {
            System.setOut(new PrintStream(outContent));
            user.viewMyInfo();
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("Name is not showing when viewing information.", outContent.toString().contains(user.getName()));
    }

}