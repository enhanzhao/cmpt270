// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b

/**
 * Finds all positive even integer in an int array and return Array list containing those ints
 */

import java.util.*;
class PositiveEvenFinder {
    /**
     * find positive even numbers in int array
     * @param numbers an int array
     * @return an ArrayList from java utilities containing positive ints from numbers
     */
    public static ArrayList<Integer> findPositiveEvens(int[] numbers){
        ArrayList newArray = new ArrayList<Integer>();
        for (int i = 0; i< numbers.length; i ++){
            if (numbers[i] % 2 == 0 && numbers[i] > 0){
                newArray.add(numbers[i]);
            }

        }
        return newArray;
    }
    public static void main(String[] args){
        int[] inputs = {1, 2, 3, 4, 5};
        ArrayList<Integer> result = findPositiveEvens(inputs);
        if (!(result.contains(2) && result.contains((4)))){
            System.out.println("Testing fault: positive_evens() returned " + result + "on inputs " + inputs + "didnt find the correct even numbers");
        }
    }
}
