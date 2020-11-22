//Enhan Zhao 11097118 enz889 cmpt270
import java.util.LinkedList;

/**
 * an extended Doctor class that adds a list of patients additional patient management methods to the Basic Doctor super class.
 */

public class Doctor extends BasicDoctor {

    /**
     * a list of patients that belongs to the doctor.
     */
    private LinkedList<Patient> patientList;

    /**
     * Initialize an instance of BasicDoctor with the given name.
     *
     * @param name the name of the doctor
     */
     public Doctor(String name) {
        super(name);
        patientList = new LinkedList();
    }

    /**
     * getter for patientList
     * @return patientList
     */
    public LinkedList<Patient> getPatientList(){
         return this.patientList;
    }

    /**
     * adds a patient object to the doctors patient list.
     * @param p the patient object to be added.
     */
     public void addPatient(Patient p){
         patientList.add(p);
     }

    /**
     * removes a patient from the patient list given the health card number.
     * @param healthNum the patients health card number
     */
    public void removePatient(int healthNum){
         for (Patient i : patientList){
             if (i.getHealthNumber() == healthNum){
                 patientList.remove(i);
             }
         }
     }

    /**
     * checks if the patient is assigned to a doctor.
     * @param healthNum the health card number of the patient to be checked.
     * @return boolean value, true if matched, false if not.
     */
     public boolean hasPatient(int healthNum){
         if (patientList.isEmpty()){
             return false;
         }
         for (Patient p : patientList){
             if (p.getHealthNumber() == healthNum){
                 return true;
             }
         }
         return false;
     }

    /**
     * Return all relative information of doctor in printable format
     */
     @Override
     public String toString(){
         String patients = "";
         for (Patient p : this.patientList){
             patients += p.getName();
         }
         return "Doctor name: " + this.getName() + "\n" + patients;
     }

    /**
     * the main function of class Doctor that tests the methods.
     */
    public static void main(String[] args){
        //setting up testing parameters
         Doctor doctor_1 = new Doctor("Paul Zhao");
         Patient patient_1 = new Patient("Lisa Toy", 123456789);
         //test getters()
         if (!doctor_1.getName().equals("Paul Zhao")){
             System.out.println("Error in getName(), the doctor name didnt match.");
         }
         if (!doctor_1.getPatientList().equals(new LinkedList<Patient>())){
             System.out.println("Error in getPatientList(), the list is different than the result.");
         }
         //test addPatient()
         doctor_1.addPatient(patient_1);
         if (!doctor_1.hasPatient(123456789)){
             System.out.println("Error in hasPatient(), doctor should not have this patient.");
         }
         //test removePatient()
         doctor_1.removePatient(123456789);
         if (doctor_1.hasPatient(123456789)){
             System.out.println("Error in removePatient, the patient is still in the patient list.");
         }

     }



}
