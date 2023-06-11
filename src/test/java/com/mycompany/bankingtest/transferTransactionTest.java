/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtest;

import static junit.framework.TestCase.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author dell
 */
public class transferTransactionTest {
    UserAccount acc1 , acc2 , acc3;
    
    //public transferTransactionTest() {
    //}
    @Before
    public void setUp () throws Exception
    {
      acc1=new UserAccount("Salma" , "1" , 1000.0 , "Retail");  
      acc2=new UserAccount("Ali" , "11" , 2000.0 , "Student");  
      acc3=new UserAccount("Dina" , "111" , 5000.0 , "Retail");
    }
    @Test
    public void transferTransactionTest() throws Exception {
        acc1.transferTransaction(acc2 , 100.0);
        acc2.transferTransaction(acc1, 922);
        assertEquals(1822.0,acc1.getBalance());
        assertEquals(178.0,acc2.getBalance());
        
        acc1.transferTransaction(acc2,1000000.0);
        assertEquals(1822.0,acc1.getBalance());
        assertEquals(178.0,acc2.getBalance());
        
        acc2.transferTransaction(acc1, 100000000);
        assertEquals(1822.0,acc1.getBalance());
        assertEquals(178.0,acc2.getBalance());
        
        acc1.transferTransaction(acc2, -666);
        assertEquals(1822.0,acc1.getBalance());
        assertEquals(178.0,acc2.getBalance());
        
        acc2.transferTransaction(acc1,-9999);
        assertEquals(1822.0,acc1.getBalance());
        assertEquals(178.0,acc2.getBalance());
        
        acc1.transferTransaction(acc3 , acc1.getBalance());
        assertEquals(1822.0,acc3.getBalance());
        acc2.transferTransaction(acc3 , acc2.getBalance());
        assertEquals(2000.0,acc3.getBalance());
        
    }
    
}
