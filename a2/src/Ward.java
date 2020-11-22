//Enhan Zhao enz889 11097118 cmpt 270

import java.util.Arrays;

/**
 * A hospital ward class that has a number of beds that can be assigned to patients.
 */
public class Ward {
    //Instance variables
    /**
     * the name of the ward
     */
    String wardName;
    /**
     * the bed label of the first bed in the ward
     */
    int firstBed;
    /**
     * the bed label of the last bed in the ward
     */
    int lastBed;
    /**
     * a Person object array that stores persons objects. The index corresponds to the bed index of the beds in the ward.
     */
    Person[] patientList;

    //Constructor for Ward
    /**
     * A constructor for a ward object
     * @param name the given name of the ward
     * @param firstBed the label number of the first bed in the ward as an int
     * @param lastBed the label number of the last bed in the ward as an int
     * @param patientL the list of Person object array same length as the number of beds used to assign patients to empty beds.
     */
    public Ward(String name, int firstBed, int lastBed, Person[] patientL){
        this.wardName = name;
        this.firstBed = firstBed;
        this.lastBed = lastBed;
        this.patientList = patientL;
    }
    //getter for wardName
    public String getWardName(){
        return this.wardName;
    }
    //getter for firstBed
    public int getFirstBed(){
        return this.firstBed;
    }
    //getter for lastBed
    public int getLastBed(){
        return this.lastBed;
    }
    //getter for patientlist
    public Person[] getPatientList(){
        return this.patientList;
    }

    /**
     * converts the bed label into its corresponding array index.
     * @param bedLabel the label of the bed that needs to be converted.
     * @return: an integer that is the index of the bed.
     */
    public int getBedIndex(int bedLabel){
        return bedLabel - this.firstBed;
    }

    /**
     * converts the bed index into its corresponding bed label.
     * @param bedIndex the index of the bed.
     * @return the number of the bed label.
     */
    public int getBedLabel(int bedIndex){
        return bedIndex + this.firstBed;
    }


    /**
     * checks if bed label is occupied.
     * @param bedLabel the bed label as an int
     * @return boolean: true if empty. false if occupied.
     */
    public boolean checkBedOccupied(int bedLabel){
        int i = getBedIndex(bedLabel);
        return patientList[i] == null;
    }

    /**
     * return the person at a given bed label, bed must not be empty
     * @param bedLabel an int that is the bed number
     * @return a person object if the bed is not empty.
     */
    public Person getPersonAtBed(int bedLabel){
        int i = getBedIndex(bedLabel);
        if (patientList[i] == null){
            System.out.println("The bed is empty.");
            return null;
        }
        else {
            return patientList[i];
        }
    }

    /**
     * assign a person to a bed label, the bed must be empty.
     * @param person a person class
     * @param bedLabel an int that is the bed to be assigned.
     */
    public void assignBed(Person person, int bedLabel){
        int i = getBedIndex(bedLabel);
        if (patientList[i] == null){
            patientList[i] = person;
        }
        else{
            System.out.println("The bed is occupied, try another bed.");
        }
    }

    /**
     * returns ward info in a printable form.
     * @return a string for ward attributes and info for all beds.
     */
    public String toString(){
        String info = "Ward name: " + wardName;
        String beds = "";
        for (int i = 0; i < patientList.length; i ++){
            beds = beds + "Bed " + getBedLabel(i);
            if (patientList[i] == null){
                beds = beds + " Empty\n";
            }
            else {
                beds = beds + " " + patientList[i].getName() + "\n";
            }
        }
        return info + "\n" + beds;
    }


    //Main
    public static void main(String[] args){
        //initiate a ward class
        Person[] listPatients = new Person[6];
        Ward Saskatoon = new Ward("Saskatoon", 10, 15,listPatients);
        Person person_1 = new Person("Lisa Toy", 123456789);
        Person person_2 = new Person("Paul Zhao", 987654321);
        //Test assignBed()
        Saskatoon.assignBed(person_1, 10);
        Saskatoon.assignBed(person_2, 15);
        //Testing getters
        if (Saskatoon.getWardName() != "Saskatoon"){
            System.out.println("Error in getWardName(), name does not match.");
        }
        if (Saskatoon.getFirstBed() != 10){
            System.out.println("Error in getFirstBed(), first bed does not match.");
        }
        if (Saskatoon.getLastBed() != 15){
            System.out.println("Error in getLastBed(), last bed does not match.");
        }
        //Test getBedIndex()
        if (Saskatoon.getBedIndex(13) != 3){
            System.out.println("Error in getBedIndex, converted index was incorrect.");
        }
        //Test getBedLabel()
        if (Saskatoon.getBedLabel(5) != 15){
            System.out.println("Error in getBedLabel, converted label was incorrect.");
        }
        //Test checkBedOccupied() on 1 empty bed and 1 occupied bed.
        if (Saskatoon.checkBedOccupied(10) && !Saskatoon.checkBedOccupied(11)) {
            System.out.println("Error in checkBedOccupied(), bed was occupied but returned true.");
        }
        //Test getPersonAtBed()
        if (Saskatoon.getPersonAtBed(10) != person_1){
            System.out.println("Error in getPersonAtBed(), name does not match.");
        }
        //Test toString() System.out.println(Saskatoon.toString()); result:
        //Ward name: Saskatoon
        //Bed 10 Lisa Toy
        //Bed 11 Empty
        //Bed 12 Empty
        //Bed 13 Empty
        //Bed 14 Empty
        //Bed 15 Paul Zhao




    }



}
