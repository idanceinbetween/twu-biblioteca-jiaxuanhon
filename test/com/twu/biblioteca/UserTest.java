package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserTest {

    User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        user = new User("000-0001", "password");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void canInitialiseUserObject(){
        String number = user.getLibraryNumber();
        assertEquals("000-0001", number);
    }

    @Test
    public void canSetUserSecondaryDetails(){
        user.setNameEmailPhone("Alexa", "alexa@tw.com", "0362592925");
        assertEquals("Please make sure that secondary details are in correctly set.", "Alexa", user.getName());
    }

    @Test
    public void userIsInUsersList(){
        assertTrue("Users are not added to static 'all' method.", User.users.size() > 0);
    }

    @Test
    public void canFindUserWithLibraryNumber(){
        assertEquals(user, User.findUserByLibraryNumber(user.getLibraryNumber()));
    }

    @Test
    public void userCanLoginWithTheCorrectCredentials(){
        User foundUser = User.login("000-0001", "password");
        Assert.assertNotNull(foundUser);
    }

    @Test
    public void checkedOutBookIsOnUserLoanList(){
        Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
        user.checkOutBook(sunfall);
        Assert.assertTrue("Checked out book is not in user's loan list.", user.getBookLoans().contains(sunfall));
    }

    @Test
    public void checkedOutBookHasLoaner() {
        Book sunfall = new Book("Sunfall", "Jim Al-Khalil", "2019");
        user.checkOutBook(sunfall);
        Assert.assertTrue("Book is checked out but not attached to a user.", sunfall.getLoaner().equals(user));
    }

}