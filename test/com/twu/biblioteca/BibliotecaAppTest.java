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
        System.setOut(new PrintStream(outContent));
        app.welcome();
        Assert.assertTrue(outContent.size() > 1); //new line is a character
    }

    // Check that user can select and move to next screen

    // Check that user gets error message if menu selection is wrong

    //

}