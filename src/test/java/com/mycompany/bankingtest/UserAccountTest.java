/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.bankingtest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Before;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author dell
 */
public class UserAccountTest {
    UserAccount acc;
    @Before
    public void TestAddingAccount()
    {
        System.out.println("Test adding an account:");
        try {
            acc= new UserAccount("Sohayla" , "12345" , 1000.0 , "Retail");
            assertTrue(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserAccountTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UserAccountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}