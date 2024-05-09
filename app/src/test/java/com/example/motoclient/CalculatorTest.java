package com.example.motoclient;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    Calculator calculator;
    //setup = oncreate
    public void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    //tearDown = ondestroy
    public void tearDown() throws Exception {
    }

    public void testSum() {
        int expected = 40;
        int actual = calculator.sum(10,20);
        assertEquals(expected,actual);
    }

    public void testMul(){
        int expected = 20;
        int actual = calculator.multiply(5,4);
        assertEquals(expected,actual);
    }
}