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
        //Validation statement - ensures division name is 40 characters or less
        if(divisionName.length() < 41 ) {
            this.divisionName = divisionName;
        }
        //To do!!!
        else {

        }

        //Validation statement - ensures the division address is 60 characters or less
        if(divisionAddress.length() < 60 ) {
            this.divisionAddress = divisionAddress;
        }
        //To do!!!
        else {

        }

        //Validation statement - ensures the division e-mail address contains @ and . symbols
        if(divisionEmail.contains("@") && divisionEmail.contains(".")) {
            this.divisionEmail = divisionEmail;
        }
        else {
            divisionEmail = "Invalid email format";
        }

        //TO DO - Validation
        this.divisionPhone = divisionPhone;

        //Validation statement - ensures division leader's name is 30 characters or less
        if(divisionLeader.length() < 30 ) {
            this.divisionLeader = divisionLeader;
        }
        //Stores first 30 characters as division leader's name
        else {
            String str = this.divisionLeader.substring(0,29);
            str = divisionLeader;
        }
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
        //Validation statement - ensures division name is 40 characters or less
        if(divisionName.length() < 40 ) {
            this.divisionName = divisionName;
        }
        //Stores first 40 characters as division name
        else {
            String str = this.divisionName.substring(0,39);
            str = divisionName;
        }
    }

    /**
     * Updates the Division Address to the value passed as a parameter
     * @param divisionAddress The new Division Address
     */
    public void setDivisionAddress(String divisionAddress) {
        //Validation statement - ensures the division address is 60 characters or less
        if(divisionAddress.length() < 60 ) {
            this.divisionAddress = divisionAddress;
        }
        //Stores first 60 characters as division address
        else {
            String str = this.divisionAddress.substring(0,59);
            str = divisionAddress;
        }
    }

    /**
     * Updates the Division E-mail Address to the value passed as a parameter
     * @param divisionEmail The new Division E-mail Address
     */
    public void setDivisionEmail(String divisionEmail) {
        //Validation statement - ensures the division e-mail address contains @ and . symbols
        if(divisionEmail.contains("@") && divisionEmail.contains(".")) {
            this.divisionEmail = divisionEmail;
        }
        else {
            divisionEmail = "Invalid email format";
        }
    }

    /**
     * Updates the Division Phone Number to the value passed as a parameter
     * @param divisionPhone The new Division Phone Number
     */
    public void setDivisionPhone(String divisionPhone) {
        //TO DO - Validation!!!
        this.divisionPhone = divisionPhone;
    }

    /**
     * Updates the Division Leader's name to the value passed as a parameter
     * @param divisionLeader The new Division Leader
     */
    public void setDivisionLeader(String divisionLeader) {
        //Validation statement - ensures division leader's name is 30 characters or less
        if(divisionLeader.length() < 30 ) {
            this.divisionLeader = divisionLeader;
        }
        //Stores first 30 characters as division name
        else {
            String str = this.divisionLeader.substring(0,29);
            str = divisionLeader;
        }
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
                + "', Division Leader: " + divisionLeader
                + "', Email: '" + divisionEmail + "'";
    }
}
