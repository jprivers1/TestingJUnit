package com.teamtreehouse.vending;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jpriv on 9/19/2017.
 */
public class CreditorTest {

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        //Arrange
        Creditor creditor = new Creditor();
        //Act
        creditor.addFunds(25);
        creditor.addFunds(25);
        //Assert
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        //Arrange
        Creditor creditor = new Creditor();
        creditor.addFunds(40);
        //Act
        int refund = creditor.refund();
        //Assert
        assertEquals(40, refund);
    }

    @Test
    public void afterRefundAvailableFundsAreZero() throws Exception {
        //Arrange
        Creditor creditor = new Creditor();
        creditor.addFunds(30);
        //Act
        creditor.refund();
        //Assert
        assertEquals(0, creditor.getAvailableFunds());
    }
}