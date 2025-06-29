package com.example;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class CalculatorTest {
	private Calculator c;

    @Before
    public void setUp() {
        System.out.println("Setting up calculator...");
        c = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up calculator...");
        c = null;
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 7;
        int b = 5;

        // Act
        int r = c.add(a, b);

        // Assert
        assertEquals(12, r);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int r = c.subtract(a, b);

        // Assert
        assertEquals(6, r);
    }
}
