package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void canInitialiseUserObject(){
        User user = new User("000-0001", "Password1");
        String number = user.getLibraryNumber();
        Assert.assertEquals("000-0001",number);
    }

}