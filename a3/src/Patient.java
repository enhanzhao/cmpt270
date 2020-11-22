//Enhan Zhao 11097118 enz889 cmpt270
import java.util.LinkedList;

/**
 * An extended person class that models a patient at a hospital. Has a bed number, a list of doctors, and methods to change bed number and doctors.
 */
public class Patient extends Person {

    /**
     * The bed number assigned to patient as an int. -1 if unassigned.
     */
    private int bedLabel;
    /**
     * A list of all doctors for the patient.
     */
    private LinkedList<Doctor> doctorList;

    /**
     * Getter and setter for bedLabel.
     * @return the bed label as int
     */
    public int getBedLabel() {
        return this.bedLabel;
    }
    public void setBedLabel(int bedLabel) {
        this.bedLabel = bedLabel;
    }
    public LinkedList<Doctor> getDoctorList(){ return this.doctorList; }
    /**
     * Adds a doctor object to the list of doctors
     * @param d the doctor object to be added
     */
    public void addDoctor(Doctor d){
        this.doctorList.add(d);
    }

    /**
     * <Remove the give doctor from the patient list.
     * @param name the name of the doctor to be removed
     */
    public void removeDoctor(String name){
        for (Doctor d : this.doctorList){
            if (d.getName().equals(name)){
                this.doctorList.remove(d);
            }
        }
    }

    /**
     * checks to see if a doctor is assigned to the patient.
     * @param name the name of the doctor to check.
     * @return a boolean based on if the doctor is assigned.
     */
    public boolean hasDoctor(String name){
        if (this.doctorList.isEmpty()){
            return false;
        }
        for (Doctor d : doctorList){
            if (d.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     * Initialize an instance with the given name and health number.
     * @param pName   the person's name
     * @param pNumber the person's health number
     */
    public Patient(String pName, int pNumber) {
        super(pName, pNumber);
        bedLabel = -1;
        doctorList = new LinkedList();
    }

    /**
     * Return all information of the patient in printable form.
     * @return a string containing all patient information.
     */
    @Override
    public String toString(){
        String doctors = "List of Doctors: \n";
        for (Doctor d : this.doctorList){
            doctors += d.getName() + "\n";
        }
        return "Name: " + super.getName() + "\n" + "Health number: " + super.getHealthNumber() +"\n" + "Bed label: " + this.getBedLabel() + "\n" + doctors;
    }

    /**
     * the main method of the patient class that tests the methods.
     */
    public static void main(String[] args){
        //setup testing parameters
        Patient person_1 = new Patient("Lisa Toy", 123456789);
        Doctor doctor_1 = new Doctor("Paul Lai");
        //test getBedLabel
        if (person_1.getBedLabel() != -1){
            System.out.println("Error in getBedLabel: default label should be -1");
        }
        //test setBedLabel
        person_1.setBedLabel(200);
        if (person_1.getBedLabel() != 200){
            System.out.println("Error in setBedLabel: the label should be set to 200.");
        }
        //test addDoctor
        person_1.addDoctor(doctor_1);
        if (person_1.doctorList.get(0).getName() != "Paul Lai"){
            System.out.println("Error in addDoctor: doctor added does not match result.");
        }
        //test removeDoctor and hasDoctor()
        person_1.removeDoctor("Paul Lai");
        if (person_1.hasDoctor("Paul Lai")) {
            System.out.println("Error in removeDoctor, doctor was not removed.");
        }
    }


}
