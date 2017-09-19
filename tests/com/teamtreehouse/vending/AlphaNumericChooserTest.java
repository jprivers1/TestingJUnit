package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by jpriv on 9/19/2017.
 */
public class AlphaNumericChooserTest {
    private AlphaNumericChooser chooser;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        //Arrange
        chooser = new AlphaNumericChooser(26, 10);
    }

    @Test
    public void validInputReturnsProperLocation() throws Exception {
        //Act
        AlphaNumericChooser.Location loc = chooser.locationFromInput("B4");
        //Assert
        assertEquals("proper row", 1, loc.getRow());
        assertEquals("proper column", 3, loc.getColumn());
    }

    @Test(expected = InvalidLocationException.class)
    public void invalidInputThrowsException() throws Exception{
        //Act
        chooser.locationFromInput("JLP");
    }

    @Test(expected = InvalidLocationException.class)
    public void choosingLargerThanMaxThrowsException() throws Exception{
        //Act
        chooser.locationFromInput("J27");
    }

    @Test
    public void constructorLargerThanAlphabetNotAllowed() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Maximum rows supported is 26");
        new AlphaNumericChooser(57, 10);
    }
}