/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dell
 */
public class fileLoadTest {
    UserAccount acc1 ,acc2;
    
    @Before
    public void setUp() throws FileNotFoundException, UnsupportedEncodingException
    {
        acc1=new UserAccount("a" , "1" , 2558 , "Retail");
        acc2=new UserAccount("b" , "2" , 2558 , "Student");
        acc2.name = "Salma";
        acc2.accountNumber = 2500;
        acc2.passKey = "123";
        acc2.balance = 5000.0;    
        acc2.accountType = "Retail";
        acc2.opened = true; 
    }
    @Test
    public void TestLoad() 
    {
        acc1.accountNumber=2500;
        try { 
            acc1.fileLoad();
            assertTrue(true);
        } catch (FileNotFoundException ex) {
        }
        assertEquals(acc2,acc1);
        acc1.accountNumber=66666;
        try {
            acc1.fileLoad();
        } catch (FileNotFoundException ex) {
            assertTrue(true);
        }
    }
}
