//Enhan Zhao enz889 11097118 cmpt270

package commands;


import containers.*;
import entities.*;

/**
 * A class to refactor assignDoctorToPatient() method in Hospital system.
 */
public class AssignDoctor extends CommandStatus {

    /**
     * Constructor for instance of Assign Doctor.
     */
    public AssignDoctor(){};

    /**
     * Method that is called in hospital system, controls error message and checks validity of input.
     * @param name  name of doctor string
     * @param healthNumber patient healthcard number
     */
    public void assignDoctorToPatient(String name, int healthNumber)
    {
        AssignDoctor a = new AssignDoctor();

        Patient p = PatientMapAccess.dictionary().getPatient().get(healthNumber);
        if (p == null) {
            a.successful = false;
            a.errorMessage = "No such patient in system.";
            System.out.println(a.getErrorMessage());
        }

        Doctor d = DoctorMapAccess.dictionary().getDoctors().get(name);
        if (d == null){
            a.successful = false;
            a.errorMessage = "No such doctor in system.";
            System.out.println(a.getErrorMessage());
        }
        else {
            a.successful = true;
            assert p != null;
            p.addDoctor(d);
            d.addPatient(p);
        }
    }
}
