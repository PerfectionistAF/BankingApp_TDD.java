/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingtestsuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.mycompany.bankingtest.*;
@RunWith(Suite.class)
//ACCOUNT THAT SAVES AND DEPOSITS
@Suite.SuiteClasses({UserAccountTest.class, displayAccountTest.class, depositTransactionTest.class})
/**
 *
 * @author dell
 */
public class TestSuite2 {
    
}
