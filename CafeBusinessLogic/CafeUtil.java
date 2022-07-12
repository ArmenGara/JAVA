import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {
    // public int getStreakGoal(){
    //     int total = 0;
    //     for( int i = 1; i < 11; i++){
    //         total += i;
    //     }
    //     return total;
    // }
    
    // public double getOrderTotal(double[] prices){
    //     double newPrice = 0.0;
    //     for( double i = 1; i <= prices.length; i++){
    //         newPrice += i;
    //     }
    //     return newPrice;
    // }

    // public void displayMenu(ArrayList<String> menuItems){
    //     // Given an ArrayList of menu items (strings), print out each index and menu item. 
    //     for (int i = 0; i < menuItems.size(); i++){
    //     System.out.println( i + " " + menuItems.get(i));
    // }
    //     // Sample output given an  ArrayList with the items "drip coffee",  "cappuccino",  "latte" and  "mocha"
    // }

    public void addCustomer(ArrayList<String> customers){
        String userName = System.console().readLine();
        System.out.println("Hello! " + userName);
        System.out.println("There are " + customers.size() + "people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }
}