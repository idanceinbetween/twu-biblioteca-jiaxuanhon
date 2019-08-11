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
    private ArrayList library;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        library= app.createLibrary();
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void canCreateLibraryWithBookObjects() {
        Assert.assertTrue(library.size() > 0);
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
        Assert.assertTrue("No error message is displayed when user selected invalid option", outContent.size() > 1);
    }

    // 1.1
    @Test
    public void hasSomethingToShowInBooksListOption() {
        try {
            System.setOut(new PrintStream(outContent));
            app.showBooks();
        } finally {
            System.setOut(originalOut);
        }
        Assert.assertTrue("There is nothing showing if user chose to view List of Books..", outContent.size() > 1);
    }
}