package com.twu.biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    Book sunfall;

    @Before
    public void setUp() throws Exception {
        sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
    }

    @Test
    public void canInitialiseBookObject() throws Exception {
        String title = sunfall.getTitle();
        assertEquals(title, "Sunfall");
    }

    @Test
    public void canChangeCheckedOutStatus() throws Exception {
        sunfall.setCheckOut();
        assertEquals(sunfall.getCheckedOutStatus(), true);

        sunfall.setReturn();
        assertEquals(sunfall.getCheckedOutStatus(), false);
    }
}