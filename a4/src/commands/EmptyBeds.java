//Enhan Zhao enz889 11097118 cmpt270

package commands;
import containers.WardAccess;

/**
 * A class that refactor displayEmptyBed() in HospitalSystem.
 */
public class EmptyBeds extends CommandStatus {

    /**
     * constructor for class EmptyBeds
     */
    public EmptyBeds(){   };

    /**
     * Method that is called in hospital system, controls error message and checks validity of input.
     */
    public void displayEmptyBeds()
    {
        System.out.println(WardAccess.Ward().availableBeds());
        super.successful = true;
    }


}
