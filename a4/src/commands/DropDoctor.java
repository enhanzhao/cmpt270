//Enhan Zhao enz889 11097118 cmpt270

package commands;

import containers.DoctorMapAccess;
import containers.PatientMapAccess;
import entities.*;

/**
 * A class that refactors dropAssociation() in hospital system.
 */
public class DropDoctor extends CommandStatus {

    /**
     * Constructor for class drop doctor
     */
    public DropDoctor(){};

    /**
     * Method that is called in hospital system, controls error message and checks validity of input.
     * @param healthcard healthcard int of the patient
     * @param name name of the doctor
     */
    public void dropAssociation(int healthcard, String name)
    {
        DropDoctor d = new DropDoctor();

        Patient p = PatientMapAccess.dictionary().getPatient().get(healthcard);
        if (p == null){
            d.successful = false;
            d.errorMessage = "Patient does not exist.";
            System.out.print(d.getErrorMessage());
        }


        Doctor doc = DoctorMapAccess.dictionary().getDoctors().get(name);
        if (doc == null){
            d.successful = false;
            d.errorMessage = "Doctor does not exist.";
            System.out.println(d.getErrorMessage());
        }


        assert p != null;
        int pHealthNumber = p.getHealthNumber();
        assert doc != null;
        if (!doc.hasPatient(pHealthNumber)) {
            d.successful = false;
            d.errorMessage = "This patient is not associated with this doctor.";
            System.out.print(d.getErrorMessage());
        }
        if (!p.hasDoctor(name)) {
            d.successful = false;
            d.errorMessage = "This doctor and this patient are incorrectly "
                    + "associated.  The doctor has the patient, "
                    + "but the patient does not have the doctor";
            System.out.println(d.getErrorMessage());
        }
        p.removeDoctor(name);
        doc.removePatient(healthcard);
    }
}
