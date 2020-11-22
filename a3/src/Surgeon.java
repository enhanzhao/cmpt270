//Enhan Zhao 11097118 enz889 cmpt270
import java.util.LinkedList;

/**
 * A surgeon class that extend the doctor class.
 */
public class Surgeon extends Doctor {
    /**
     * Initialize an instance of BasicDoctor with the given name.
     *
     * @param name the name of the doctor
     */
    public Surgeon(String name) {
        super(name);
    }
    /**
     * Return surgeon info in printable form.
     * @return a string that contains all surgeon info.
     */
    @Override
    public String toString(){
        String patients = "";
        for (Patient p : super.getPatientList()){
            patients += p.getName() + "\n";
        }
        return "Surgeon name: " + this.getName() + "\n" + patients;
    }

    /**
     * a main function that tests the methods of the surgeon class.
     */
    public static void main(String[] args){
        //setup testing parameters
        Surgeon surgeon_1 = new Surgeon("Paul Lai");
        Patient patient_1 = new Patient("Lisa Toy", 123456789);
        Patient patient_2 = new Patient("Spongebob", 111);
        surgeon_1.addPatient(patient_1);
        surgeon_1.addPatient(patient_2);
        if (!surgeon_1.toString().equals("Surgeon name: Paul Lai\n" + "Lisa Toy\n" + "Spongebob\n")){
            System.out.println("Error in surgeon class toString(), output does not match information.");
        }
    }
}
