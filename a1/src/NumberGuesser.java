// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b

/**
 * Based on an integer from user input, determine if the int is too high or too low.
 */

import java.util.*;
class NumberGuesser {
    /**
     * main function checks if int from user input is below 1 or above 100
     * @param args
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Guess a number between 1 and 100: ");
        int guess = Integer.parseInt(scan.nextLine());
        while (guess < 1 ||guess > 100){
            if (guess < 1){
                System.out.println("Too low!");
            }
            else if (guess > 100){
                System.out.println("Too High!");

            }
            guess = Integer.parseInt(scan.nextLine());

        }
        System.out.println("That was a valid guess!");

    }

}
