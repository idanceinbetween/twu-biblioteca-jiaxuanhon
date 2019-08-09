package com.twu.biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    /*
     * Start the application (Mock) and Assert that the welcome message has been printed
     * There is a main menu
     * There is a book list, each book with author and year.
     * Check out and return a book, update book.checkedOut == true / false.
     * Book that has been checked out is not on the book list.
     */

        @Before
        public void setUp() throws Exception {
            Book sunFall = new Book();
            sunFall.setTitle("sunFall");
        }

        @Test
        public void canInitialiseBookObject() throws Exception {
            Book sunFall = new Book();
            sunFall.setTitle("sunFall");
            String title = sunFall.getTitle();
            assertEquals(title, "sunFall");
        }
}