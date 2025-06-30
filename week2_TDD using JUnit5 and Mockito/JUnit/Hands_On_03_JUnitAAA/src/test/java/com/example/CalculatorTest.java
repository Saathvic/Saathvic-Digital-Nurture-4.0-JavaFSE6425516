package com.example;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {
	private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up calculator...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up calculator...");
        calculator = null;
    }

    @Test
    public void testAddition() {
        int x = 7;
        int y = 5;

        int result = calculator.add(x, y);

        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        int x = 10;
        int y = 4;

        int result = calculator.subtract(x, y);

        assertEquals(6, result);
    }
}
