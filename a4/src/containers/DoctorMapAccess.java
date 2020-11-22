package containers;

/*
A singleton container class that stores the doctor treemap for the hospital system
 */
import entities.Doctor;
import java.util.*;

/**
 * A singleton class that is the container for the Doctor TreeMap for the Hospital system, maps doctor name to Doctor Object
 */
public class DoctorMapAccess {

    /**
     * variable to hold the doctor treemap for the hospital system
     */
    private static TreeMap<String, Doctor> doctors;

    /**
     * variable to hold the single instance of DoctorMapAccess class
     */
    private static DoctorMapAccess d;

    /**
     * the constructor method to DoctorMapAccess
     */
    private DoctorMapAccess(){
        doctors = new TreeMap<String, Doctor>();
    }

    /**
     * the accessor to the Doctor Trreemap
     * @return the KV treemap for doctors
     */
    public TreeMap<String, Doctor> getDoctors(){
        return doctors;
    }

    /**
     * the accessor to the instant of DoctorMapAccess
     * @return the single instance of DoctorMapAccess
     */
    public static DoctorMapAccess dictionary(){
        if (d == null){
            d = new DoctorMapAccess();
        }
        return d;
    }

}
