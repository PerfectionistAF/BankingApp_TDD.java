/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.bankingtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class QueueTest {
    
    public QueueTest() {
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
     * Test of isEmpty method, of class Queue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Queue instance = new Queue();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enqueue method, of class Queue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Node n = null;
        Queue instance = new Queue();
        instance.enqueue(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dequeue method, of class Queue.
     */
    @Test
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        Queue instance = new Queue();
        Node expResult = null;
        Node result = instance.dequeue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class Queue.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Queue instance = new Queue();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHead method, of class Queue.
     */
    @Test
    public void testGetHead() {
        System.out.println("getHead");
        Queue instance = new Queue();
        Node expResult = null;
        Node result = instance.getHead();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTail method, of class Queue.
     */
    @Test
    public void testGetTail() {
        System.out.println("getTail");
        Queue instance = new Queue();
        Node expResult = null;
        Node result = instance.getTail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
/*
package com.mycompany.bankingtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    public QueueTest() {
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


    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Queue instance = new Queue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }


    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Node n = new Node(null); // Create a new node
        Queue instance = new Queue();
        instance.enqueue(n);
        boolean isEmpty = instance.isEmpty();
        assertFalse(isEmpty);
        assertEquals(n, instance.getHead());
        assertEquals(n, instance.getTail());
    }

    @Test
    public void testDequeue() throws Exception {
        System.out.println("dequeue");
        Node n = new Node(null); // Create a new node
        Queue instance = new Queue();
        instance.enqueue(n); // Enqueue a node
        Node expResult = n;
        Node result = instance.dequeue();
        assertEquals(expResult, result);
        assertTrue(instance.isEmpty());
        assertNull(instance.getHead());
        assertNull(instance.getTail());
    }


    @Test
    public void testGetSize() {
        System.out.println("getSize");
        Queue instance = new Queue();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
        Node n = new Node(null); // Create a new node
        instance.enqueue(n); // Enqueue a node
        expResult = 1;
        result = instance.getSize();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetHead() {
        System.out.println("getHead");
        Queue instance = new Queue();
        Node expResult = null;
        Node result = instance.getHead();
        assertEquals(expResult, result);

        Node n = new Node(null); // Create a new node
        instance.enqueue(n); // Enqueue a node
        expResult = n;
        result = instance.getHead();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetTail() {
        System.out.println("getTail");
        Queue instance = new Queue();
        Node expResult = null;
        Node result = instance.getTail();
        assertEquals(expResult, result);

        Node n = new Node(null); // Create a new node
        instance.enqueue(n); // Enqueue a node
        expResult = n;
        result = instance.getTail();
        assertEquals(expResult, result);
    }

}*/