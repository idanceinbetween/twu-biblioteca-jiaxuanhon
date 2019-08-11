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
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        books = app.createBooks();
        availableBooks = app.getAvailableBooks(books);
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

    // 1.5
    @Test
    public void selectInvalidOptionMainMenu() {
        try {
            System.setOut(new PrintStream(outContent));
            app.selectMainMenuOption("3");
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("No error message is displayed when user selected invalid option in Main Menu.", outContent.size() > 1);
    }

    // 1.1
    @Test
    public void hasSomethingToShowInBooksListOption() { //TODO rewrite test
        try {
            System.setOut(new PrintStream(outContent));
            app.showBooks(availableBooks);
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("There is nothing showing if user chose to view List of Books.", outContent.size() > 1);
    }

    // Option to go to 1.7 or 1.9, or Main Menu
    @Test
    public void userAlwaysGetsFeedbackAfterSelectBookListMenuOption() {
        try {
            System.setOut(new PrintStream(outContent));
            app.selectBookListMenuOption("Not a Real Book");
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("No error message is displayed when user selected invalid option in List of Books Menu.", outContent.size() > 1);
    }

    @Test
    public void checkedOutBookIsNotOnShowBooks(){
        Book book1 = (Book) books.get(1);
        book1.setCheckOut();
        try {
            System.setOut(new PrintStream(outContent));
            app.showBooks(availableBooks);
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("Checked out books should not appear in the list of all library books", !outContent.toString().contains(book1.getTitle()));
    }
}