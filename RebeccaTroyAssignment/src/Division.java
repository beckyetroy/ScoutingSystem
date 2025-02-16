/**
 * A scaled down version of a Division class
 *
 * @author Becky Troy
 */
public class Division {

    private String divisionName;
    private String divisionAddress;
    private String divisionEmail;
    private String divisionPhone;
    private String divisionLeader;

    /**
     * Constructor for objects of class Division
     * @param divisionName Name of the division
     * @param divisionAddress Address of the division
     * @param divisionEmail E-mail address of the division
     * @param divisionPhone Phone number of the division
     * @param divisionLeader Name of the division leader
     */
    public Division(String divisionName, String divisionAddress, String divisionEmail, String divisionPhone, String divisionLeader) {

        //Validation statement - ensures division name is 40 characters or less by taking first 40 characters
        this.divisionName = (divisionName.length()<=40) ? divisionName : divisionName.substring(0,40);

        //Validation statement - ensures the division address is 60 characters or less by taking first 60 characters
        this.divisionAddress = (divisionAddress.length()<=60) ? divisionAddress : divisionAddress.substring(0,60);

        //Validation statement - ensures the division e-mail address contains @ and . symbols
        this.divisionEmail = (divisionEmail.contains("@") && divisionEmail.contains(".") ? divisionEmail : "Invalid email format");

        //Validation statement - ensures the phone number only contains numbers
        try {
            Long.parseLong(divisionPhone);
            this.divisionPhone = divisionPhone;
        }
        //Stores 'Unknown' if phone number is invalid
        catch (NumberFormatException ex) {
            this.divisionPhone = "Unknown";
        }

        //Validation statement - ensures division leader's name is 30 characters or less by taking first 30 characters
        this.divisionLeader = (divisionLeader.length()<=30) ? divisionLeader : divisionLeader.substring(0,30);
    }

    //-------
    //getters
    //-------
    /**
     * Returns the Division Name
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Returns the Division Address
     */
    public String getDivisionAddress() {
        return divisionAddress;
    }

    /**
     * Returns the Division E-mail Address
     */
    public String getDivisionEmail() {
        return divisionEmail;
    }

    /**
     * Returns the Division Phone Number
     */
    public String getDivisionPhone() {
        return divisionPhone;
    }

    /**
     * Returns the Division Leader's Name
     */
    public String getDivisionLeader() {
        return divisionLeader;
    }

    //-------
    //setters
    //-------
    /**
     * Updates the Division Name to the value passed as a parameter
     * @param divisionName The new Division Name
     */
    public void setDivisionName(String divisionName) {
        //Validation statement - ensures division name is 40 characters or less by taking first 40 characters
        this.divisionName = (divisionName.length()<=40) ? divisionName : divisionName.substring(0,40);
    }

    /**
     * Updates the Division Address to the value passed as a parameter
     * @param divisionAddress The new Division Address
     */
    public void setDivisionAddress(String divisionAddress) {
        //Validation statement - ensures the division address is 60 characters or less by taking first 60 characters
        this.divisionAddress = (divisionAddress.length()<=60) ? divisionAddress : divisionAddress.substring(0,60);
    }

    /**
     * Updates the Division E-mail Address to the value passed as a parameter
     * @param divisionEmail The new Division E-mail Address
     */
    public void setDivisionEmail(String divisionEmail) {
        //Validation statement - ensures the division e-mail address contains @ and . symbols
        this.divisionEmail = (divisionEmail.contains("@") && divisionEmail.contains(".") ? divisionEmail : "Invalid email format");
    }

    /**
     * Updates the Division Phone Number to the value passed as a parameter
     * @param divisionPhone The new Division Phone Number
     */
    public void setDivisionPhone(String divisionPhone) {
        //Validation statement - ensures the phone number only contains numbers
        try {
            Long.parseLong(divisionPhone);
            this.divisionPhone = divisionPhone;
        }
        //Stores 'Unknown' if phone number is invalid
        catch (NumberFormatException ex) {
            this.divisionPhone = "Unknown";
        }
    }

    /**
     * Updates the Division Leader's name to the value passed as a parameter
     * @param divisionLeader The new Division Leader
     */
    public void setDivisionLeader(String divisionLeader) {
        //Validation statement - ensures division leader's name is 30 characters or less by taking first 30 characters
        this.divisionLeader = (divisionLeader.length()<=30) ? divisionLeader : divisionLeader.substring(0,30);
    }

    //-------
    //methods
    //-------
    /**
     * Builds a String representing a user friendly representation of the object state
     * @return Details of the specific division
     */
    public String toString()
    {
        return "Scouting Division name= '" + divisionName
                + "', Address: '" + divisionAddress
                + "', Phone Number: '" + divisionPhone
                + "', Division Leader: '" + divisionLeader
                + "', Email: '" + divisionEmail + "'.";
    }
}
