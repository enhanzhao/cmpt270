//Enhan Zhao enz889 11097118 cmpt270

package containers;

import entities.Patient;

import java.util.*;

/**
 * A singleton container class for the Doctor dictionary
 */
public class PatientMapAccess {

    /**
     *  The patient TreeMap that stores the healthcard to the patient object
     */
    private static TreeMap<Integer, Patient> patients;

    /**
     * The variable that holds the instance of PatientMapAccess
     */
    private static PatientMapAccess p;

    /**
     * The constructor for PatientMapAccess
     */
    private PatientMapAccess(){
        patients = new TreeMap<Integer, Patient>();
    }

    /**
     * the accessor for Patient dictionary
     * @return the dictionary
     */
    public TreeMap<Integer, Patient> getPatient(){
        return patients;
    }

    /**
     * Returns the instance of PatientMapAccess, create the instance if it does not exist
     * @return the instance of PatientMapAccess
     */
    public static PatientMapAccess dictionary(){
        if (p == null){
            p = new PatientMapAccess();
        }
        return p;
    }




}

