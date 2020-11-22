//Enhan Zhao enz889 11097118 cmpt 270

/**
 * A BasicDoctor class that contains the name of the Doctor.
 */
public class BasicDoctor {
    //Instance variables
    /**
     * stores the name of the doctor as a string
     */
    String doctorName;
    //Constructor for BasicDoctor

    /**
     * a constructor for a BasicDoctor object.
     * @param name the first and last name of the doctor.
     */
    public BasicDoctor(String name){
        this.doctorName = name;
    }
    //getter and setter for BasicDoctor name
    public String getDoctorName(){
        return this.doctorName;
    }
    public void setDoctorName(String newName){
        this.doctorName = newName;
    }

    //toString()
    /**
     * Displays the information of BasicDoctor in a printable format.
     * @return a string containing the BasicDoctor info.
     */
    public String toString(){
        return "The doctor's name is: " + doctorName;
    }

    //main
    public static void main(String[] args){
        BasicDoctor doctor_1 = new BasicDoctor("Lisa Toy");
        //test getDoctorName()
        if (!doctor_1.getDoctorName().equals("Lisa Toy")){
            System.out.println("Error in getDoctorName, result did not match Doctor's name.");
        }
        //test setDoctorName()
        doctor_1.setDoctorName("Yanna Cai");
        if (doctor_1.getDoctorName() == "Lisa Toy"){
            System.out.println("Error in setDoctorName, Doctors name was not set correctly.");
        }
        doctor_1.setDoctorName("Lisa Toy");
        //test toString()
        String expected = "The doctor's name is: Lisa Toy";
        String result = doctor_1.toString();
        if (!expected.equals(result)){
            System.out.println("Error in toString(), result did not match expected.");
        }
    }
}
