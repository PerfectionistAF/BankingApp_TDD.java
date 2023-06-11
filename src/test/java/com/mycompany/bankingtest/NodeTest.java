package com.mycompany.bankingtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mycompany.bankingtest.Node;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class NodeTest {

    public NodeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setData method, of class Node.
     */
    @Test
    public void testSetData() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("setData");
        UserAccount data = new UserAccount("John", "pass123", 100.0, "Savings");
        Node instance = new Node(data);
        instance.setData(data);
        assertNotNull(instance.getData());
    }

    /**
     * Test of setNext method, of class Node.
     */
    @Test
    public void testSetNext() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("setNext");
        Node next = new Node(new UserAccount("Jane", "pass456", 200.0, "Checking"));
        Node instance = new Node(new UserAccount("John", "pass123", 100.0, "Savings"));
        instance.setNext(next);
        assertNotNull(instance.getNext());
    }

    /**
     * Test of getData method, of class Node.
     */
    @Test
    public void testGetData() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("getData");
        UserAccount data = new UserAccount("John", "pass123", 100.0, "Savings");
        Node instance = new Node(data);
        UserAccount expResult = data;
        UserAccount result = instance.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNext method, of class Node.
     */
    @Test
    public void testGetNext() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("getNext");
        Node next = new Node(new UserAccount("Jane", "pass456", 200.0, "Checking"));
        Node instance = new Node(new UserAccount("John", "pass123", 100.0, "Savings"));
        instance.setNext(next);
        Node expResult = next;
        Node result = instance.getNext();
        assertEquals(expResult, result);
    }

}