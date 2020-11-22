// Enhan Zhao enz889 11097118 CMPT270 assignment 1 part b
/**
 * A program that determines a gambler's possibility of reaching his winning goal
 */

import java.lang.Math;
class Gambler {
    /**
     * 1 unit of money is added for a win and deducted for a loss. main function simulates 1000 gambles with 100 stake with a goal of 200.
     * @param args
     */
    public static void main(String[] args){
        double successes = 0;
        double bets = 0;
        for (int x = 0; x < 1000; x++){
            int stake = 100;
            bets = 0;
            while (stake > 0 && stake < 200){
                int play = (int)Math.round(Math.random()*1);
                bets ++;
                if (play == 0){
                    stake = stake - 1;
                }
                else{
                    stake = stake + 1;
                }
            }
            if (stake == 200){
                successes += 1;
            }
            System.out.println("stake = " + stake + " bets made = " + bets);
        }

        System.out.println("average success = " + successes/1000);
        System.out.println("average bets = " + bets/1000);


    }
}
