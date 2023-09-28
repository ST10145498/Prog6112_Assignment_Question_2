/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programmingassignmentquestion_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
class Order {
    
     /*
    The manageOrder method displays the food categories (starters, main course, dessert) and handles the user's selection.
    It utilizes a switch case to call the appropriate order method based on the meal type chosen by the user.
    The total order price is updated and returned.
    */
    private static ArrayList<Food> order = new ArrayList<>();
    private static Scanner KG = new Scanner(System.in);

    public static double manageOrder(Scanner GG, double totalOrderPrice) {
        /*
        Outputs order options , we display the 3 categories of food that the user may choose ot order from
        -We used a switch case after we get the user input and depending on the meal type he chose, we will
        call that method to now display its options
        */
        System.out.println("1. Starters");
        System.out.println("2. Main Course");
        System.out.println("3. Dessert");
        System.out.print("Please select a meal type to order (1-3) ");

        int mealType = getUserInput();

        switch (mealType) {
            case 1:
                totalOrderPrice = StarterOrder(totalOrderPrice);
                break;
            case 2:
                totalOrderPrice = MainCourseOrder(totalOrderPrice);
                break;
            case 3:
                totalOrderPrice = DessertOrder(totalOrderPrice);
                break;
            default:
                System.out.println("Invalid category choice. No items added to the order.");
        }

        return totalOrderPrice;
    }
    
    /*
    The StarterOrder, MainCourseOrder, and DessertOrder methods display food options for their respective categories
    and allow the user to select items. The selected items are added to the order ArrayList, and the total order price is updated.
    These methods demonstrate the use of constructors to create Food objects and inheritance to create specialized food types.
    */

    public static double StarterOrder(double totalOrderPrice) {
        /*
        this method serves as a means to display the starter options available to purchase 
        we added a re-prompt for a invalid option so the program continues without quitting 
        
        */
        System.out.println("Starters Menu:");
        Starter calamari = new Starter("Calamari", 20.0);
        Starter prawns = new Starter("Prawns", 25.0);
        Starter sushi = new Starter("Sushi", 30.0);
        
        System.out.println("1: " + calamari.getName() + " - R" + calamari.getPrice());
        System.out.println("2: " + prawns.getName() + " - R" + prawns.getPrice());
        System.out.println("3: " + sushi.getName() + " - R" + sushi.getPrice());


        int starterChoice;

        while (true) {  // loops for valid input
            System.out.print("Select a starter (1-3): ");  // we let the user choose his menu options 
            if (KG.hasNextInt()) {
                starterChoice = KG.nextInt();
                if (starterChoice >= 1 && starterChoice <= 3) {
                    break; // Valid choice, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a valid option (1-3):");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (1-3):");
                KG.next();
            }
        }
        /*
        Switch case that takes valid user input and .add the chosen food to order and add the price 
        of the food to the total order so we can output the total in the receipt
        */
        switch (starterChoice) {
            case 1:
                order.add(calamari);
                totalOrderPrice += calamari.getPrice();
                System.out.println("Calamari added to the order.");
                break;
            case 2:
                order.add(prawns);
                totalOrderPrice += prawns.getPrice();
                System.out.println("Prawns added to the order.");
                break;
            case 3:
                order.add(sushi);
                totalOrderPrice += sushi.getPrice();
                System.out.println("Sushi added to the order.");
                break;
            default:
                System.out.println("Invalid choice. No starter added to the order.");
        }

        return totalOrderPrice; // Return the updated totalOrderPrice
    }

    public static double MainCourseOrder(double totalOrderPrice) {
        /*
        This method displays the main course option available to purchase and takes an input 
        1-3 , we added a re-prompt for a invalid option so the program continues without quitting 
        */
        System.out.println("Main Course Menu:");
        MainCourse steak = new MainCourse("Steak", 80.0);
        MainCourse beefBurger = new MainCourse("Beef Burger", 70.0);
        MainCourse spaghettiBolognese = new MainCourse("Spaghetti Bolognese", 75.0);

        System.out.println("1: " + steak.getName() + " - R" + steak.getPrice());
        System.out.println("2: " + beefBurger.getName() + " - R" + beefBurger.getPrice());
        System.out.println("3: " + spaghettiBolognese.getName() + " - R" + spaghettiBolognese.getPrice());


        int mainCourseChoice;

        while (true) {  // loops for a valid input 
            System.out.print("Select a main course (1-3): ");
            if (KG.hasNextInt()) {
                mainCourseChoice = KG.nextInt();
                if (mainCourseChoice >= 1 && mainCourseChoice <= 3) {
                    break; // Valid choice, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a valid option (1-3):");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (1-3):");
                KG.next(); 
            }
        }
         /*
        Switch case that takes valid user input and .add the chosen food to order and add the price 
        of the food to the total order so we can output the total in the receipt
        */
        switch (mainCourseChoice) { 
            case 1:
                order.add(steak); 
                totalOrderPrice += steak.getPrice();
                System.out.println("Steak added to the order.");
                break;
            case 2:
                order.add(beefBurger);
                totalOrderPrice += beefBurger.getPrice();
                System.out.println("Beef Burger added to the order.");
                break;
            case 3:
                order.add(spaghettiBolognese);
                totalOrderPrice += spaghettiBolognese.getPrice();
                System.out.println("Spaghetti Bolognese added to the order.");
                break;
            default:
                System.out.println("Invalid choice. No main course added to the order.");
        }

        return totalOrderPrice; // Return the updated totalOrderPrice
    }

    public static double DessertOrder(double totalOrderPrice) {
        /*
        Dessert order displays the dessert option and manages the user input the same as the 
        previous 3 methods 
        
        we added a re-prompt for a invalid option so the program continues without quitting 
        */
        System.out.println("Dessert Menu:");
        Dessert iceCream = new Dessert("Ice Cream", 35.0);
        Dessert pancakes = new Dessert("Pancakes", 40.0);
        Dessert brownies = new Dessert("Brownies", 25.0);

        System.out.println("1: " + iceCream.getName() + " - R" + iceCream.getPrice());
        System.out.println("2: " + pancakes.getName() + " - R" + pancakes.getPrice());
        System.out.println("3: " + brownies.getName() + " - R" + brownies.getPrice());


        int dessertChoice;

        while (true) { //loops for valid input 
            System.out.print("Select a dessert (1-3): ");
            if (KG.hasNextInt()) {
                dessertChoice = KG.nextInt();
                if (dessertChoice >= 1 && dessertChoice <= 3) {
                    break; // Valid choice, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a valid option (1-3):");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid option (1-3):");
                KG.next(); 
            }
        }
        /*
        Switch case that takes valid user input and .add the chosen food to order and add the price 
        of the food to the total order so we can output the total in the receipt
        */
        switch (dessertChoice) {
            case 1:
                order.add(iceCream);
                totalOrderPrice += iceCream.getPrice();
                System.out.println("Ice Cream added to the order.");
                break;
            case 2:
                order.add(pancakes);
                totalOrderPrice += pancakes.getPrice();
                System.out.println("Pancakes added to the order.");
                break;
            case 3:
                order.add(brownies);
                totalOrderPrice += brownies.getPrice();
                System.out.println("Brownies added to the order.");
                break;
            default:
                System.out.println("Invalid choice. No dessert added to the order.");
        }

        return totalOrderPrice; // Return the updated totalOrderPrice
    }

    public static boolean continueOrder(Scanner GG) {
        System.out.print("Type 'y' to continue ordering or any other key to complete the order and receive the receipt: ");
        String continueChoice = GG.next().toLowerCase();
        return continueChoice.equals("y");
    }

       
    public static boolean chooseDeliveryOption(Scanner GG) {
     /*
    The chooseDeliveryOption method allows the user to select delivery or pick-up.
    It also handles the delivery fee and returns true if the user chooses delivery.
    */
    System.out.print("Do you want to pick up in store or choose delivery? (Type '1' for delivery, '2' for pick up, or any other key to quit): ");
    String deliveryChoice = GG.next();

    if (deliveryChoice.equals("1")) {
        System.out.println("You have chosen delivery.");
        System.out.print("Please note that delivery is an added R35 charge. Type 'y' to confirm delivery or any other key to pick up in store ");
        String deliveryConfirmation = GG.next().toLowerCase();

        if (deliveryConfirmation.equals("y")) {
            return true; // User chose delivery
        }
    } else if (deliveryChoice.equals("2")) {
        System.out.println("You have chosen pick up in store.");
    } else {
        System.out.println("Order cancelled. Exiting application.");
        GG.close();
        System.exit(0); // quits application 
    }

    return false; // User chose pick up in store or entered an invalid choice
}
    
    public static void displayReceipt(double totalOrderPrice, boolean isDelivery) { 
     /*
    The displayReceipt method displays the receipt with the list of ordered items and the total price.
    If delivery is chosen, it adds the delivery fee to the total price.
    */
        
        System.out.println(" ");
        System.out.println("======================");
        System.out.println("FOOD HOUSE RECEIPT");
        System.out.println("======================");
        System.out.println("Your Order:");
        for (Food item : order) {
            System.out.println(item.getName() + " - " + "R" + item.getPrice());
        }

        if (isDelivery) {
            totalOrderPrice += 35.0; // Add delivery fee
            System.out.println("Delivery Fee: R 35.0");
            System.out.println("Total Price (including delivery): R " + totalOrderPrice);
            System.out.println("Order to be delivered");
            System.out.println("Please come again ");
            System.out.println(" ");// leave a blank line for a neater output 
        } else {
            System.out.println("Total Price: R " + totalOrderPrice);
            System.out.println("Order to be picked up in store");
            System.out.println("Please come again ");
            System.out.println(" ");// leave a blank line for a neater output 
        }
    }

   

   private static int getUserInput() {
    /*
    The getUserInput method handles user input validation and returns a valid number.
    */
    int userInput;
    while (true) {
        if (KG.hasNextInt()) {
            userInput = KG.nextInt();
            if (userInput >= 1 && userInput <= 3) {
                return userInput;
            } else {
                System.out.println("Invalid input. Please enter a valid option (1-3):");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid option (1-3):");
            KG.next();
        }
    }
}
}