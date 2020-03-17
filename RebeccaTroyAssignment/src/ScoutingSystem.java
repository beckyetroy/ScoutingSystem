import java.util.Scanner;

/**
 * This class runs the application and handles the Division and Scout I/O
 * @author Becky Troy
 */
public class ScoutingSystem {
    /**
     * Declares and initialises a private Scanner object called input
     * Declares and initialises private Division object called divisionList
     */
    private Scanner input = new Scanner(System.in);
    private DivisionList divisionList = new DivisionList();
    private ScoutList scoutList = new ScoutList();

    /**
     * Calls the runMenu() method
     */
    public ScoutingSystem() {
        runMenu();
    }

    public static void main(String[] args) {
        new ScoutingSystem();
    }

    /**
     * mainMenu() - This method displays the menu for the application,
     * reads the menu option that the user entered and returns it.
     *
     * @return the users menu choice
     */
    private int mainMenu() {
        System.out.println("Scouting Ireland Menu");
        System.out.println("--------------------");
        System.out.println("1) Add a Scouting Division");
        System.out.println("2) List all Divisions");
        System.out.println("3) Update a Division (by index)");
        System.out.println("4) Remove a Division (by index)");
        System.out.println("--------------------");
        System.out.println("5) Add a Scout");
        System.out.println("6) List all Scouts");
        System.out.println("7) List all Scouts by Gender");
        System.out.println("8) List all Scouts by Division");
        System.out.println("9) Update a Scout (by index)");
        System.out.println("10) Remove a Scout (by index)");
        System.out.println("--------------------");
        System.out.println("11) Save to XML");
        System.out.println("12) Load from XML");
        System.out.println("--------------------");

        System.out.println("0) Exit");
        System.out.print("===>> ");
        int option = input.nextInt();
        return option;
    }

    /**
     * Calls mainMenu() and takes the value returned from mainMenu() and uses it for the switch
     * statement.
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addDivision();
                    break;
                case 2:
                    System.out.println(divisionList.listOfDivisions());
                    break;
                case 3:
                    updateDivision();
                    break;
                case 4:
                    deleteDivision();
                    break;
                case 5:
                    addScout();
                    break;
                case 6:
                    System.out.println(scoutList.listOfScouts());
                    break;
                case 7:
                    listScoutsByGender();;
                    break;
                case 8:
                    listScoutByDivision();
                    break;
                case 9:
                    updateScout();
                    break;
                case 10:
                    deleteScout();
                    break;
                case 11:
                    try{
                        divisionList.save();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    try{
                        scoutList.save();
                    }
                    catch (Exception e) {
                        System.out.println("Error writing to file: " + e);
                    }
                    System.out.println("Save complete");
                    break;
                case 12:
                    try{
                        divisionList.load();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    try{
                        scoutList.load();
                    }
                    catch(Exception e){
                        System.out.println("Error writing to file: " + e);
                    }
                    System.out.println("Load complete");
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  //this second read is required - bug in Scanner class; a String read is
            // ignored straight after reading an int.
            //display the main menu again
            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    /**
     * Gather the product data from the user and create a new product
     */
    private void addDivision() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.println("Please enter the following Division details...");
        System.out.print("  Scouting Division Name (max 40 chars):  ");
        String divisionName = input.nextLine();
        System.out.print("  Address (max 60 chars):  ");
        String divisionAddress = input.nextLine();
        System.out.print("  Phone (numbers only - no hyphens or spaces):  ");
        String divisionPhone = input.nextLine();
        System.out.print("  Division Leader (max 30 chars):  ");
        String divisionLeader = input.nextLine();
        System.out.print("  Email (must contain @ and .):  ");
        String divisionEmail = input.nextLine();

        Division d1 = new Division(divisionName, divisionAddress, divisionEmail, divisionPhone, divisionLeader);
        divisionList.addDivision(d1);
    }

    /**
     * This method will update the 8 scout attributes as long as the ArrayList is not empty
     */
    private void updateDivision() {
        //list the divisions to the screen
        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);

        if(!divisionDetails.equals("There are no divisions in the list.")) {
            //ask the user to choose a division
            System.out.print("Enter the index of the division to update ==> ");
            int index = input.nextInt();
            if (divisionList.numberOfDivisions() > 0 && (index < divisionList.numberOfDivisions())) {
                //gather new details for each field from the user
                //dummy read of String to clear the buffer - bug in Scanner class.
                input.nextLine();
                System.out.println("Please enter the following Division details...");
                System.out.print("  Scouting Division Name (max 40 chars):  ");
                String divisionName = input.nextLine();
                System.out.print("  Address (max 60 chars):  ");
                String divisionAddress = input.nextLine();
                System.out.print("  Phone (numbers only - no hyphens or spaces):  ");
                String divisionPhone = input.nextLine();
                System.out.print("  Division Leader (max 30 chars):  ");
                String divisionLeader = input.nextLine();
                System.out.print("  Email (must contain @ and .):  ");
                String divisionEmail = input.nextLine();
                divisionList.updateDivision(index, divisionName, divisionAddress, divisionEmail, divisionPhone, divisionLeader);
                System.out.println("Update Successful");
            }
            else
            {
                System.out.println("Incorrect Index - no division exists for that index");
            }
        }
    }

    /**
     * This method deletes a Division object as long as the ArrayList is not empty
     */
    private void deleteDivision() {
        //list the divisions to the screen
        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);

        if(!divisionDetails.equals("There are no divisions in the list.")) {
            //dummy read of String to clear the buffer - bug in Scanner class.
            input.nextLine();

            //ask the user to choose a division
            System.out.print("Enter the index of the division to Delete ==> ");
            int index = input.nextInt();

            if (divisionList.removeDivision(index) == true) {
                divisionList.removeDivision(index);
                System.out.println("The division has been deleted.");
            }
            else {
                System.out.println("There is no division for this index number.");
            }
        }
    }

    /**
     * Gather the scout data from the user and create a new scout
     */
    private void addScout() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.println("Please enter the following Scout details...");
        System.out.print("  First Name (max 40 chars):  ");
        String Firstname = input.nextLine();
        System.out.print("  Surname (max 40 chars):  ");
        String Surname = input.nextLine();
        System.out.print("  Address (max 50 chars): ");
        String address = input.nextLine();

        System.out.print("  Gender (M/F): ");
        String gender;
        String inputtedValue = input.nextLine();
        //Accepts user input 'MALE' and 'FEMALE' - not case sensitive
        if (inputtedValue.toUpperCase().equals("MALE")) {
            gender = "M";
        }
        else if (inputtedValue.toUpperCase().equals("FEMALE")) {
            gender = "F";
        }
        else {
            gender = inputtedValue.toUpperCase();
        }

        System.out.print("  Day of Birth (1-31):  ");
        int dayOfBirth = input.nextInt();
        //Asks the user to keep inputting a value until a valid day is entered        }
        while ((dayOfBirth < 1) || (dayOfBirth > 31)) {
            System.out.print("Invalid day. Please try again:    ");
            dayOfBirth = input.nextInt();
        }

        System.out.print("  Month of Birth (1-12):  ");
        int monthOfBirth = input.nextInt();
        //Asks the user to keep inputting a value until a valid day is entered        }
        while ((monthOfBirth < 1) || (monthOfBirth > 12)) {
            System.out.print("Invalid month. Please try again:  ");
            monthOfBirth = input.nextInt();
        }

        System.out.print("  Enter Current Year:  ");
        int currentYear = input.nextInt();

        System.out.print("      Scout's Year of Birth:  ");
        int yearOfBirth = input.nextInt();
        //Ensures Scout is 4 years of age or over
        while ((currentYear - yearOfBirth) < 6) {
            System.out.print("Scouts must be aged 6 or over. Please try again:  ");
            yearOfBirth = input.nextInt();
        }

        //list the divisions to the screen
        System.out.println("    ");
        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);
        //If the Arraylist is empty
        if (divisionDetails == "There are no divisions in the list.") {
            System.out.println("A new division must be created.");
            addDivision();
            String divisionDetails2 = divisionList.listOfDivisions();
            System.out.println(divisionDetails2);
        }
        else {
        }
        System.out.print("Choose " + Firstname + "'s Division by index ==>");
        int index = input.nextInt();

        Division division = divisionList.getDivision(index);

        Scout s1 = new Scout(Firstname, Surname, address, dayOfBirth, monthOfBirth, yearOfBirth, gender, division);
        scoutList.addScout(s1);
    }

    /**
     * Returns a list of all scouts of a particular gender that has been passed in by the user
     */
    private void listScoutsByGender() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.print("Please enter the gender you want to search by ==>  ");
        String gender = input.nextLine();

        //Accepts user input 'MALE' and 'FEMALE' - not case sensitive
        if (gender.toUpperCase().equals("MALE")) {
            gender = "M";
        }
        else if (gender.toUpperCase().equals("FEMALE")) {
            gender = "F";
        }
        else {
            gender = gender.toUpperCase();
        }
        String list = scoutList.listScoutsBySpecificGender(gender);
        System.out.println(list);
        if (list == "There are no scouts stored in the list.") {
            System.out.println("A new scout must be created.");
            addScout();

            //dummy read of String to clear the buffer - bug in Scanner class.
            input.nextLine();
            //Allows user to search again after adding a scout
            System.out.print("Please enter the gender you want to search by ==>  ");
            String gender2 = input.nextLine();
            //Accepts user input 'MALE' and 'FEMALE' - not case sensitive
            if (gender2.toUpperCase().equals("MALE")) {
                gender2 = "M";
            }
            else if (gender2.toUpperCase().equals("FEMALE")) {
                gender2 = "F";
            }
            else {
                gender2 = gender2.toUpperCase();
            }
            String list2 = scoutList.listScoutsBySpecificGender(gender2);
            System.out.println(list2);
        }
        else {
        }
    }

    /**
     * Returns a list of all scouts of a particular division that has been passed in by the user
     */
    private void listScoutByDivision() {
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.print("Please enter the division you want to search by ==>  ");
        String division = input.nextLine();

        String list = scoutList.listScoutsBySpecificDivision(division);
        System.out.println(list);

        if (list == "There are no scouts stored in the list.") {
            System.out.println("A new scout must be created.");
            addScout();

            //dummy read of String to clear the buffer - bug in Scanner class.
            input.nextLine();
            //Allows user to search again after adding a scout
            System.out.print("Please enter the division you want to search by ==>  ");
            String division2 = input.nextLine();

            String list2 = scoutList.listScoutsBySpecificDivision(division2);
            System.out.println(list2);
        }
        else {
        }
    }

    /**
     * This method will update the 8 scout attributes as long as the ArrayList is not empty
     */
    private void updateScout() {
        //list the scouts to the screen
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        if(!scoutDetails.equals("There are no scouts in the list.")) {
            //ask the user to choose a scout
            System.out.print("Enter the index of the scout to update ==> ");
            int index = input.nextInt();
            if (scoutList.numberOfScouts() > 0 && (index < scoutList.numberOfScouts())) {
                //gather new details for each field from the user
                //dummy read of String to clear the buffer - bug in Scanner class.
                input.nextLine();
                System.out.println("Please enter the following Scout details...");
                System.out.print("  First Name (max 40 chars):  ");
                String Firstname = input.nextLine();
                System.out.print("  Surname (max 40 chars):  ");
                String Surname = input.nextLine();
                System.out.print("  Address (max 50 chars): ");
                String address = input.nextLine();

                System.out.print("  Gender (M/F): ");
                String gender;
                String inputtedValue = input.nextLine();
                //Accepts user input 'MALE' and 'FEMALE' - not case sensitive
                if (inputtedValue.toUpperCase().equals("MALE")) {
                    gender = "M";
                }
                else if (inputtedValue.toUpperCase().equals("FEMALE")) {
                    gender = "F";
                }
                else {
                    gender = inputtedValue.toUpperCase();
                }

                System.out.print("  Day of Birth (1-31):  ");
                int dayOfBirth = input.nextInt();
                //Asks the user to keep inputting a value until a valid day is entered        }
                while ((dayOfBirth < 1) || (dayOfBirth > 31)) {
                    System.out.print("Invalid day. Please try again:    ");
                    dayOfBirth = input.nextInt();
                }

                System.out.print("  Month of Birth (1-12):  ");
                int monthOfBirth = input.nextInt();
                //Asks the user to keep inputting a value until a valid day is entered        }
                while ((monthOfBirth < 1) || (monthOfBirth > 12)) {
                    System.out.print("Invalid month. Please try again:  ");
                    monthOfBirth = input.nextInt();
                }

                System.out.print("  Enter Current Year:  ");
                int currentYear = input.nextInt();

                System.out.print("      Scout's Year of Birth:  ");
                int yearOfBirth = input.nextInt();
                //Ensures Scout is 4 years of age or over
                while ((currentYear - yearOfBirth) < 6) {
                    System.out.print("Scouts must be aged 6 or over. Please try again:  ");
                    yearOfBirth = input.nextInt();
                }

                //list the divisions to the screen
                System.out.println("    ");
                String divisionDetails = divisionList.listOfDivisions();
                System.out.println(divisionDetails);
                //If the Arraylist is empty
                if (divisionDetails == "There are no divisions in the list.") {
                    System.out.println("A new division must be created.");
                    addDivision();
                    String divisionDetails2 = divisionList.listOfDivisions();
                    System.out.println(divisionDetails2);
                }
                else {
                }
                System.out.print("Choose " + Firstname + "'s Division by index ==>");
                int divIndex = input.nextInt();

                Division division = divisionList.getDivision(divIndex);

                scoutList.updateScout(index, Firstname, Surname, address, dayOfBirth, monthOfBirth, yearOfBirth, gender, division);
                System.out.println("Update Successful");
            }
            else
            {
                System.out.println("Incorrect Index - no scout exists for that index");
            }
        }
    }

    /**
     * This method deletes a Scout object as long as the ArrayList is not empty
     */
    private void deleteScout() {
        //list the scouts to the screen
        String scoutDetails = scoutList.listOfScouts();
        System.out.println(scoutDetails);

        if(!scoutDetails.equals("There are no scouts in the list.")) {
            //dummy read of String to clear the buffer - bug in Scanner class.
            input.nextLine();

            //ask the user to choose a scout
            System.out.print("Enter the index of the scout to Delete ==> ");
            int index = input.nextInt();

            if (scoutList.removeScout(index) == true) {
                scoutList.removeScout(index);
                System.out.println("The scout has been deleted.");
            }
            else {
                System.out.println("There is no scout for this index number.");
            }
        }
        else {
        }
    }


}
