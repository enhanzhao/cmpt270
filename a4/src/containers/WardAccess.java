package containers;

import entities.Ward;

/**
 *A singleton container class for the Doctor dictionary
 */
public class WardAccess {

    /**
     * The variable that holds the instance of ward object for the hospital system
     */
    private static Ward ward;

    /**
     * The variable that holds the instance of WardAccess
     */
    private static WardAccess w;

    /**
     * constructor for the WardAccess
     * @param name name of ward
     * @param min min bed label
     * @param max max bed label
     */
    private WardAccess(String name, int min, int max){
        ward = new Ward(name, min, max);
    }

    /**
     * the getter method for WardAccess's ward object
     * @return the WardAccess instance
     */
    public static Ward Ward(){
        if (ward == null){
            throw new RuntimeException("ward not initialized yet.");
        }
        return ward;
    }

    /**
     * the getter for WardAccess instance. create new if not created
     * @param name name of ward
     * @param minBedLabel min bed label
     * @param maxBedLabel max bedlabel
     * @return
     */
    public static WardAccess initialize(String name, int minBedLabel, int maxBedLabel){
        if (w == null){
            w = new WardAccess(name, minBedLabel, maxBedLabel);
            return w;
        }
        else{
            throw new RuntimeException("ward already initialized.");
        }
    }
}
