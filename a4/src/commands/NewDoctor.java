//Enhan Zhao enz889 11097118 cmpt270

package commands;

import containers.DoctorMapAccess;
import entities.*;


/**
 * A class to refactor the addDoctor Method in HospitalSystem
 */
public class NewDoctor extends CommandStatus {

    /**
     * Constructor for class NewDoctor
     */
    public NewDoctor(){}

    /**
     * Method that is called in hospital system, controls error message and checks validity of input.
     * @param name the name of doctor
     * @param response a string of the response to question: is this doctor a surgeon?
     */
    public void addDoctor(String name, String response){

        NewDoctor n = new NewDoctor();

        if (DoctorMapAccess.dictionary().getDoctors().containsKey(name)){
            n.successful = false;
            n.errorMessage = "Not added, doctor already added.";
            System.out.println(n.getErrorMessage());
        }

        Doctor d;
        if (response.charAt(0) == 'y' || response.charAt(0) == 'Y')
            d = new Surgeon(name);
        else
            d = new Doctor(name);

        // check to make sure the doctor name doesn't already exsist
        Doctor sameNumberDoctor = DoctorMapAccess.dictionary().getDoctors().put(name, d);
        if (sameNumberDoctor != null){
            DoctorMapAccess.dictionary().getDoctors().put(name, sameNumberDoctor); // put the original doctor back
            n.successful = false;
            n.errorMessage = "Put the original doctor back, doctor with the same name already exist.";
            System.out.println(n.getErrorMessage());
        }
        else{
            n.successful = true;
        }

    }







}
