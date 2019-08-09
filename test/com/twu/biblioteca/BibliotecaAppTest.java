package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaAppTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void canCreateLibraryWithBookObjects() {
        BibliotecaApp app = new BibliotecaApp();
        ArrayList<Book> library= app.createLibrary();
        Assert.assertTrue(library.size() > 0);
    }
}