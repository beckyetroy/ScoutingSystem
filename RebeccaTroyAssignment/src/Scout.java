/**
 * A scaled down version of a Scout class
 *
 * @author Becky Troy
 */
public class Scout {

    private String Firstname;
    private String Surname;
    private String address;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String gender;
    private Division division;

    /**
     * Default Constructor for class Scout
     */
    public Scout() {
    }

    /**
     * Constructor for objects of class Scout
     *
     * @param Firstname      First name of the scout
     * @param Surname        Surname of the scout
     * @param address        Home address of the scout
     * @param dayOfBirth     Day scout was born
     * @param monthOfBirth   Month scout was born
     * @param yearOfBirth    Year scout was born
     * @param division       Division of scout
     */
    public Scout(String Firstname, String Surname, String address, int dayOfBirth, int monthOfBirth, int yearOfBirth, String gender, Division division) {
        //Validation statement - ensures first name is 40 characters or less
        if (Firstname.length() < 41) {
            this.Firstname = Firstname;
        }
        else {
        }

        //Validation statement - ensures first name is 40 characters or less
        if (Surname.length() < 41) {
            this.Surname = Surname;
        }
        else {
        }

        //Validation statement - ensures first name is 40 characters or less
        if (address.length() < 51) {
            this.address = address;
        }
        else {
        }

        //Validation statement - ensures day of birth is a valid day of the month between 1-31
        if ((dayOfBirth > 0) && (dayOfBirth < 32)) {
            this.dayOfBirth = dayOfBirth;
        }
        else {
        }

        //Validation statement - ensures month of birth is a valid month of the year between 1-12
        if ((monthOfBirth > 0) && (monthOfBirth < 32)) {
            this.monthOfBirth = monthOfBirth;
        }
        else {
        }

        this.yearOfBirth = yearOfBirth;

        //Validation statement - ensures gender is one of three options: "m", "f", "unspecified"
        if ((gender.toUpperCase().equals("M")) | (gender.toUpperCase().equals("F"))) {
            this.gender = gender;
        }
        else {
            gender = "unspecified";
        }

        this.division = division;
    }

    //-------
    //getters
    //-------
    /**
     * Returns the scout's first name
     */
    public String getFirstname() {
        return Firstname;
    }

    /**
     * Returns the scout's surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * Returns the scout's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Returns the scout's day of birth
     */
    public int getDayOfBirth() {
        return dayOfBirth;
    }

    /**
     * Returns the scout's month of birth
     */
    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    /**
     * Returns the scout's year of birth
     */
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Returns the scout's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the scout's division
     */
    public Division getDivision() {
        return division;
    }

    //-------
    //setters
    //-------
    /**
     * Updates the scout's first name to the value passed as a parameter
     * @param firstname The new first name
     */
    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    /**
     * Updates the scout's surname to the value passed as a parameter
     * @param surname The new surname
     */
    public void setSurname(String surname) {
        Surname = surname;
    }

    /**
     * Updates the scout's address to the value passed as a parameter
     * @param address The new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Updates the scout's day of birth to the value passed as a parameter
     * @param dayOfBirth The new day of birth
     */
    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Updates the scout's birth month to the value passed as a parameter
     * @param monthOfBirth The new birth month
     */
    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    /**
     * Updates the scout's birth year to the value passed as a parameter
     * @param yearOfBirth The new birth year
     */
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    /**
     * Updates the scout's gender to the value passed as a parameter
     * @param gender The new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Updates the scout's division to the value passed as a parameter
     * @param division The new division
     */
    public void setDivision(Division division) {
        this.division = division;
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
        return "Scout name: '" + Firstname + " " + Surname
                + "', Address: '" + address
                + "', Date of Birth: '" + dayOfBirth + "/" + monthOfBirth + "/" + yearOfBirth
                + "', Gender: '" + gender
                + "', Division: '" + division + "'.";
    }
}