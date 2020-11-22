// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b

import java.util.*;

/**
 * Prints greeting message and user name from user input.
 */
class Greeter {
    /**
     * prints user input name
     * @param greeting a message to be displayed
     * @return the user name inputted, String
     */
    public static String introductions(String greeting){
        System.out.println(greeting);
        System.out.print("Enter your name: ");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        return username;


    }
    public static void main(String[] args){
        String username = introductions("welcome to my Java Program!");
        System.out.println("got username " + username);
    }
}
