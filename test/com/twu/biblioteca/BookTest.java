package com.twu.biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
//        @Before
//        public void setUp() throws Exception {
//            Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
//        }

        @Test
        public void canInitialiseBookObject() throws Exception {
            Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
            String title = sunfall.getTitle();
            assertEquals(title, "Sun Fall");
        }

        @Test
        public void canChangeCheckedOutStatus() throws Exception{
            Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
            sunfall.setCheckOut();
            assertEquals(sunfall.getCheckedOutStatus(), true);

            sunfall.setReturn();
            assertEquals(sunfall.getCheckedOutStatus(), false);
        }
}