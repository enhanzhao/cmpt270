//Enhan Zhao enz889 11097118 cmpt 270

/**
 * A Person class that contains a persons name as a string and health card number as an int.
 */
public class Person {
    //Instance variables
    /**
     * stores the name of the person as a string.
     */
    String personName;
    /**
     * Stores the number of the health card number as an int.
     */
    int healthNum;

    //constructor for person
    /**
     * a constructor for a person object
     * @param name first name and last name of the person
     * @param card the health card number of the person
     */
    public Person(String name, int card){
        this.personName = name;
        this.healthNum = card;
    }
    //getter and setter for patient name
    public String getName(){
        return this.personName;
    }
    public void setName(String newPatientName){
        this.personName = newPatientName;
    }
    //getter for health card number
    public int getCardNumber(){
        return this.healthNum;
    }

    //toString() method
    /**
     * a toString method that returns Person object info in printable format.
     * @return a string that contains the Person object info.
     */
    public String toString(){
        return "Patient name: " + personName + " | Patient health card #: " + healthNum;
    }

    //main
    public static void main(String[] args){
        Person person_1 = new Person("Lisa Toy", 123456789);
        //Test getName()
        if (!person_1.getName().equals("Lisa Toy")){
            System.out.println("Error in getName(), result did not match name.");
        }
        //Test setName()
        person_1.setName("Yanna Cai");
        if (person_1.getName().equals("Lisa Toy")){
            System.out.print("Error in setName(), the name of object was not changed correctly.");
        }
        person_1.setName("Lisa Toy");
        //Test getCardNumber()
        if (person_1.getCardNumber() != 123456789){
            System.out.println("Error in getCardNumber(), result did not match health card number.");
        }
        //Test toString()
        String expected = "Patient name: Lisa Toy | Patient health card #: 123456789";
        String result = person_1.toString();
        if (!expected.equals(result)){
            System.out.println("Error in toString(), result did not match expected.");
        }


    }



}
