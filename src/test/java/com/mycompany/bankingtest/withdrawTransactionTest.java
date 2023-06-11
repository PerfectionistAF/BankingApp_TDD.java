/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;

import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dell
 */
public class withdrawTransactionTest {
    UserAccount acc ; 
    @Before
    public void setUp() throws Exception{
        acc=new UserAccount("M" , "0" , 1000.0 , "Retail");
    }
    @After
    public void tearDown() {
    }
    /**
     * Test of setFirstRowAccNum method, of class Withdraw.
     */
    @Test
    public void TestWithdraw() throws Exception
    {
        acc.withdrawTransaction(100);
        assertEquals(900.0, acc.getBalance());
        acc.withdrawTransaction(150);
        assertEquals(750.0 , acc.getBalance());
        acc.withdrawTransaction(111111);
        assertEquals(750.0 , acc.getBalance());
        acc.withdrawTransaction(-111111);
        assertEquals(750.0 , acc.getBalance());
    }
}
