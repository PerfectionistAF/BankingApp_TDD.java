/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dell
 */
public class displayAccountTest {
    UserAccount acc;
    @Before
    public void setUp (){
        System.out.println("Saving an account test: Test the method only, not the UI");
      try {
            acc = new UserAccount("Gehad" , "478" , 1000.0 , "Retail");
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
    @Test 
    public void displayAccountTest(){
        try {
            try {
                acc.fileSave();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(displayAccountTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(displayAccountTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            acc.name="abcdefgh";
            acc.fileLoad();
            assertTrue(true);
            assertEquals("Sohayla" , acc.name);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(displayAccountTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}