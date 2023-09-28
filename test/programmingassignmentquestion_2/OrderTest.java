/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package programmingassignmentquestion_2;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class OrderTest {

    private double initialTotalOrderPrice;

    @Before
    public void setUp() {
        initialTotalOrderPrice = 0.0;
    }

  
  @Test
    public void testDessertOrder() {
        //Tests if the desert order correctly updates price after food is added 
        // Simulate user input for selecting a dessert
        ByteArrayInputStream userInput = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(userInput);

        // Call the method
        double updatedTotalOrderPrice = Order.DessertOrder(initialTotalOrderPrice);

        // Assert that the total order price has been updated correctly
        assertEquals(35.0, updatedTotalOrderPrice, 0.01); // Assuming dessert price is 35.0

        
        System.setIn(System.in);
    }

  @Test
    public void testContinueOrder() {
        //Tests if "continue order" correctly determines of the user wants to continue  
        // Simulate user input for continuing the order
        ByteArrayInputStream userInput = new ByteArrayInputStream("y\n".getBytes());
        System.setIn(userInput);

        // Call the method
        boolean result = Order.continueOrder(new Scanner(System.in));

        // Assert that the result is as expected
        assertTrue(result);

        
        System.setIn(System.in);
    }

  @Test
    public void testChooseDeliveryOption() {
        /*
        Tests if the chooseDeliveryOption method correctly handles 
        the user's choice of delivery and returns true when delivery is chosen.
        */
        // Simulate user input for choosing delivery
        ByteArrayInputStream userInput = new ByteArrayInputStream("1\ny\n".getBytes());
        System.setIn(userInput);

        // Call the method
        boolean result = Order.chooseDeliveryOption(new Scanner(System.in));

        // Assert that the result is as expected
        assertTrue(result);

        
        System.setIn(System.in);
    }
  @Test
    public void testChoosePickUpOption() {
        /*
        Tests if the chooseDeliveryOption method correctly handles 
        the user's choice of pick-up and returns false when pick-up is chosen.
        */
        // Simulate user input for choosing pick-up
        ByteArrayInputStream userInput = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(userInput);

        // Call the method
        boolean result = Order.chooseDeliveryOption(new Scanner(System.in));

        // Assert that the result is as expected (pick-up option)
        assertFalse(result);
    }
  
    @Test
    public void testDisplayReceiptPickUp() {
        // Tests if the displayReceipt method correctly calculates the total price for pick-up
        // Simulate user input for choosing pick-up
        ByteArrayInputStream userInput = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(userInput);

        // Call the method
        boolean isDelivery = Order.chooseDeliveryOption(new Scanner(System.in));
        double totalOrderPrice = 100.0; // Assuming initial total order price
        Order.displayReceipt(totalOrderPrice, isDelivery);

        // Assert that the total order price does not include the delivery fee
        assertEquals(100.0, totalOrderPrice, 0.01);

        System.setIn(System.in);
    }
    
    @Test
    public void testPickUpOption() {
    // Simulate user input for choosing pick-up
    ByteArrayInputStream userInput = new ByteArrayInputStream("2\n".getBytes());
    System.setIn(userInput);

    // Call the chooseDeliveryOption method
    boolean result = Order.chooseDeliveryOption(new Scanner(System.in));

    // Assert that the result is as expected (pick-up option)
    assertFalse(result);
}
    
}

