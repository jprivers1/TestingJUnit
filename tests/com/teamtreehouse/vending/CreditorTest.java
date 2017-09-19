package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jpriv on 9/19/2017.
 */
public class CreditorTest {
    Creditor creditor;

    @Before
    public void setUp() throws Exception {
        //Arrange
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        //Act
        creditor.addFunds(25);
        creditor.addFunds(25);
        //Assert
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        //Act
        creditor.addFunds(40);
        int refund = creditor.refund();
        //Assert
        assertEquals(40, refund);
    }

    @Test
    public void afterRefundAvailableFundsAreZero() throws Exception {
        //Act
        creditor.addFunds(30);
        creditor.refund();
        //Assert
        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test(expected = NotEnoughFundsException.class)
    public void noFundsThrowsNotEnoughMoneyException() throws Exception {
        creditor.deduct(50);
    }
}