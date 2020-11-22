// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b

/**
 * Returns the sum of all items in an int array divided by the number of items in the int array
 */
class ArrayAverager{

    /**
     * Calculate average of int array
     * @param arr an int array
     * @return the average of int array, an int
     */
    public static double average(double[] arr){
        double total = 0;
        for (double x : arr){
            total = total + x;
        }
        double avg = total / arr.length;
        return avg;
    }

    public static void main(String[] args){
        double[] numberArray = {1, 3, 4, 5};
        double avgValue = average(numberArray);
        System.out.println("average = " + avgValue);
    }
}
