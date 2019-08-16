package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void canInitialiseMovieObject() throws Exception {
        Movie wonderWoman = new Movie("Wonder Woman", "2017", "Patty Jenkins");
        String name = wonderWoman.getName();
        assertEquals(name, "Wonder Woman");
    }

    @Test
    public void canCheckOutMovie() throws Exception {
        Movie wonderWoman = new Movie("Wonder Woman", "2017", "Patty Jenkins");
        wonderWoman.setCheckOut();
        Boolean result = wonderWoman.getCheckedOutStatus();
        Assert.assertTrue(result);
    }
}