/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programmingassignmentquestion_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class ProgrammingAssignmentQuestion_2 {
    /*
    Kyle Govender ST10145498
    
    For question 2 I decided to make an online food ordering system , the user can order food online 
    from the choices given (more menu items can be added easily onto the code for if the store wants to add more food options in future)
    we run most of the code in our order clas.
    
    The program demonstrates the use of inheritance, ArrayLists, and constructors to manage the food ordering process
 
    Inheritance is used in this code to create a hierarchy of food classes. The parent class, "Food," defines common attributes
    (name and price) and methods for all food items. Child classes (MainCourse, Starter, Dessert) inherit these attributes
    and methods, allowing for specialization and code reusability. Child classes use the "super" keyword in their constructors
    to initialize inherited fields from the parent class.
    */

    public static void main(String[] args) {
    Scanner GG = new Scanner(System.in);
    double totalOrderPrice = 0.0;  // initialize the toal price to

    System.out.println("=====================================");
    System.out.println("Welcome to the Food House Order App");
    System.out.println("=====================================");

    while (true) {
        totalOrderPrice = Order.manageOrder(GG, totalOrderPrice);

        if (!Order.continueOrder(GG)) {
            boolean isDelivery = Order.chooseDeliveryOption(GG);
            Order.displayReceipt(totalOrderPrice, isDelivery);
            System.out.println("Program end");  // we end the program here 
            GG.close();
            System.exit(0);
        }
    }
}
}