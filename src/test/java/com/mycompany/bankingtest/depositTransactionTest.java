/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dell
 */
public class depositTransactionTest {
    UserAccount acc1;
    @Before
    public void setUp() throws Exception
    {
        acc1=new UserAccount("M" , "000" , 1000.0,"Retail");
    }
    @Test
    public void TestDeposit() {
        try {
            acc1.depositTransaction(1500.0);
            assertTrue(true);
        } catch (Exception ex) {
        }
        assertEquals(2500.0, acc1.getBalance());
        try {
            acc1.depositTransaction(-6);
            assertTrue(true);
        } catch (Exception ex) {
        }
        assertEquals(2500.0, acc1.getBalance());
    }
}
