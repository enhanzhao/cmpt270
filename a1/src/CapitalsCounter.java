// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b

/**
 * Counts the number of capital letters in a string and return the result as an int
 */
class CapitalsCounter {
    /**
     * count number of capital letters in string
     * @param s a string
     * @return the number of capital letters, int
     */
    public static int countCaps(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i ++){
            if (Character.isUpperCase(s.charAt(i))){
                count ++;
            }

        }
        return count;
    }
    public static void main(String[] args){
        String x = "IHaveFiveCapitalLetters";
        int result = countCaps(x);
        if (result == 5) {
            System.out.println(":)");
        }
        else{
            System.out.println(":(");
        }
    }
}
