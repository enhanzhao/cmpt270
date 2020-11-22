//Enhan Zhao 11097118 enz889 cmpt270

import java.util.*;

/**
 * A hospital class that contains a ward, a doctor dictionary and a patient dictionary.
 */
public class HospitalSystem{
    /**
     * a ward from the ward class.
     */
    private Ward w;
    /**
     * dictionaries for doctor and patients. doctors have names as keys, and patients have healthcard number as  keys.
     */
    private TreeMap<Integer, Patient> patientDic = new TreeMap();
    private TreeMap<String, Doctor> doctorDic = new TreeMap();

    /**
     * getter for ward
     * @return the ward w
     */
    public Ward getWard() {
        return w;
    }
    /**
     * getter and setter for Doctor and Patient dictionary.
     * @return the Doctor/Patient dictionary.
     */
    public TreeMap<Integer, Patient> getPatientDic() {
        return patientDic;
    }
    public TreeMap<String, Doctor> getDoctorDic() {
        return doctorDic;
    }


    /**
     * Initialize the ward with the name given, and with beds those labels are
     * the consecutive integers from minBedLabel to maxBedLabel.
     *
     * @param wName        the name of the ward
     * @param wMinBedLabel the label of the ward's first bed
     * @param wMaxBedLabel the label of the ward's last bed
     */
    public HospitalSystem(String wName, int wMinBedLabel, int wMaxBedLabel) {
        w = new Ward(wName, wMinBedLabel, wMaxBedLabel);
        patientDic = new TreeMap();
        doctorDic = new TreeMap();
    }

    /**
     * adds a new patient to the hospital system and dictionary
     * @param cardNum an int that is the patient's healthcard number
     * @param name the string name of the patient.
     */
    public void addPatient(int cardNum,  String name){
        Patient p = new Patient(name, cardNum);
        patientDic.put(cardNum, p);
    }

    /**
     * adds a new doctor to the hospital system and dictionary
     * @param name the name of the doctor as a string
     */
    public void addDoctor(String name){
        Doctor d = new Doctor(name);
        doctorDic.put(name, d);
    }

    /**
     * adds the doctor to the patient's doctor list; adds the patient to the doctor's patient list.
     * @param d object doctor
     * @param p object patient
     */
    public void assignDoctorToPatient(Doctor d, Patient p){
        d.addPatient(p);
        p.addDoctor(d);
    }

    /**
     * assigns a patient to a bed in the hospital system.
     * @param p patient object
     * @param bedLabel the bed label to assign the patient to .
     */
    public void assignBed(Patient p, int bedLabel){
        w.assignPatientToBed(p,bedLabel);
        p.setBedLabel(bedLabel);
    }

    /**
     * takes the patient out of the doctor's patient list; takes the doctor out of the patient's doctor list.
     * @param d object doctor
     * @param p object patient
     */
    public void dropAssociation(Doctor d, Patient p){
        d.removePatient(p.getHealthNumber());
        p.removeDoctor(d.getName());
    }

    /**
     * displays the current state of the hospital system to the screen.
     */
    public void systemState(){
        System.out.println(toString());
    }

    /**
     * returns all the related information of the hospital system in a printable form.
     * @return
     */
    public String toString(){
        String doctors = "Doctor names: \n";
        String patients = "Patient names: \n";
        for (String name : doctorDic.keySet()){
            doctors += name +"\n";
        }
        for (Patient p : patientDic.values()){
            patients += p.getName();
        }
        return doctors + patients + this.w.toString();
    }

    /**
     * prints to screen all the beds that is not assigned to any patient.
     */
    public void displayEmptyBeds(){
        System.out.println(w.availableBeds());
    }

    /**
     * take out the patient from the hospital system. free the patients bed, drop associiation with any doctor, and delete from the patient dictionary.
     * @param p object patient
     */
    public void releasePatient(Patient p){
        w.freeBed(p.getBedLabel());
        while (p.getDoctorList().size() != 0){
            Doctor d = p.getDoctorList().getFirst();
            dropAssociation(d, p);
        }
        this.patientDic.remove(p.getHealthNumber());
        ;
    }

    /**
     * the main function of the hospital system that takes user input to: create hospital system object, add new patient and doctors, assign
     * patients to doctors, display empty beds, assign patient to a bed, release a patient, drop a doctor-patient association, and to display
     * the current state of the hospital system. Option 1 will log the user out of the system.
     */
    public static void main(String[] args){
        //construct a hospital system
    Scanner s = new Scanner(System.in);
    System.out.println("Enter hospital name: ");
    String name = s.next();
    System.out.println("Enter minimum bed label: ");
    int minBed = s.nextInt();
    System.out.println("Enter maximum bed label: ");
    int maxBed = s.nextInt();
    HospitalSystem sask = new HospitalSystem(name, minBed, maxBed);

    String menu = "1. quit\n" +
            "2. add a new patient to the system\n" +
            "3. add a new doctor to the system\n" +
            "4. assign a doctor to a patient\n" +
            "5. display the empty beds of the ward\n" +
            "6. assign a patient a bed\n" +
            "7. release a patient\n" +
            "8. drop doctor-patient association\n" +
            "9. display current system state ";
    System.out.println(menu);
    int i = s.nextInt();
    while (true){
        if (i == 1){
            sask.systemState();
            System.out.println("Logging off");
            break;
        }

        if (i == 2){
            System.out.println("Adding patient. Please enter patient health card number ");
            int cardNum = s.nextInt();
            System.out.println("Adding patient. Please enter patient name: ");
            String pName = s.next();
            sask.addPatient(cardNum, pName);
        }
        if (i == 3){
            System.out.println("Adding doctor. Please enter doctor name: ");
            String dName = s.next();
            sask.addDoctor(dName);
        }
        if (i == 4) {
            if (sask.getPatientDic().isEmpty() || sask.getDoctorDic().isEmpty()) {
                System.out.println("Not enough doctors/patients.");
            }
            else {
                System.out.println("Assigning patient to doctor. Enter patient health card number: ");
                int assignCardNum = s.nextInt();
                System.out.println("Assigning patient to doctor. Enter doctor name: ");
                String assignDocName = s.next();
                sask.assignDoctorToPatient(sask.getDoctorDic().get(assignDocName), sask.getPatientDic().get(assignCardNum));
            }
        }
        if (i == 5) {
                sask.displayEmptyBeds();
            }

        if (i == 6) {
            System.out.println("Assigning patient to bed. Enter patient health card number: ");
            int bedCardNum = s.nextInt();
            System.out.println("Assigning patient to bed. Enter empty bed label: ");
            int bedLabel = s.nextInt();
            if (!sask.getWard().isValidLabel(bedLabel)){
                System.out.println("Please enter a number between " + sask.getWard().getMinBedLabel() + " and " + sask.getWard().getMaxBedLabel());
            }
            else if(sask.getWard().isOccupied(bedLabel)){
                System.out.println("Please refer to option 5 for free beds.");
            }
            else{
                sask.assignBed(sask.getPatientDic().get(bedCardNum), bedLabel);
            }


        }
        if (i == 7){
            System.out.println("Releasing Patient. Enter patient health card number: ");
            int releaseCard = s.nextInt();
            sask.releasePatient(sask.getPatientDic().get(releaseCard));
        }
        if (i == 8){
            System.out.println("Dropping patient-doctor association. Enter patient health card number: ");
            int dropCard = s.nextInt();
            System.out.println("Dropping patient-doctor association. Enter doctor name: ");
            String dropDocName = s.next();
            sask.dropAssociation(sask.getDoctorDic().get(dropDocName), sask.getPatientDic().get(dropCard));
        }
        if (i == 9){
            sask.systemState();
        }
        System.out.println(menu);
        i = s.nextInt();
        }
    }
}
