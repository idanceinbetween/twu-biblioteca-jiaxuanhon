package com.twu.biblioteca;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
        @Before
        public void setUp() throws Exception {
            Book sunFall = new Book();
            sunFall.setTitle("sunFall");
        }

        @Test
        public void canInitialiseBookObject() throws Exception {
            Book sunFall = new Book();
            sunFall.setTitle("Sun Fall");
            String title = sunFall.getTitle();
            assertEquals(title, "Sun Fall");
        }

        @Test
        public void canChangeCheckedOutStatus() throws Exception{
            Book sunFall = new Book();
            sunFall.setTitle("Sun Fall");
            sunFall.setCheckOut();
            assertEquals(sunFall.getCheckedOutStatus(), true);

            sunFall.setReturn();
            assertEquals(sunFall.getCheckedOutStatus(), false);
        }
}