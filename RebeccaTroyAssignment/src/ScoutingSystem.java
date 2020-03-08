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
        System.out.println("3) Remove a Division (by index)");
        System.out.println("--------------------");
        System.out.println("4) Add a Scout");
        System.out.println("5) List all Scouts");
        System.out.println("6) List all Scouts by Gender");
        System.out.println("7) List all Scouts by Division");
        System.out.println("8) Remove a Scout (by index)");
        System.out.println("--------------------");
        System.out.println("9) Save to XML");
        System.out.println("10) Load from XML");
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
                    deleteDivision();
                    break;
                case 4:
                    addScout();
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
        System.out.print("  Phone (numbers only): ");
        String divisionPhone = input.nextLine();
        System.out.print("  Division Leader (max 30 chars): ");
        String divisionLeader = input.nextLine();
        System.out.print("  Email (must contain @ and .):  ");
        String divisionEmail = input.nextLine();

        Division d1 = new Division(divisionName, divisionAddress, divisionEmail, divisionPhone, divisionLeader);
        divisionList.addDivision(d1);
    }

    /**
     * This method deletes a Division object as long as the ArrayList is not empty
     */
    private void deleteDivision() {
        //list the divisions to the screen
        String divisionDetails = divisionList.listOfDivisions();
        System.out.println(divisionDetails);

        if(!divisionDetails.equals("There are no divisions in the list.")) {
            //ask the user to choose a division
            System.out.print("Enter the index of the division to Delete ==> ");
            int index = input.nextInt();
            if (!divisionList.removeDivision(index)) {
                System.out.println("There is not division for this index number.");
            } else {
                System.out.println("The division has been deleted.");
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
        String gender = input.nextLine().toUpperCase();
        System.out.print("  Day of Birth (1-31):  ");
        int dayOfBirth = input.nextInt();
        System.out.print("  Month of Birth (1-12):  ");
        int monthOfBirth = input.nextInt();

        System.out.print("  Enter Current Year:  ");
        int currentYear = input.nextInt();
        System.out.print("      Scout's Year of Birth:  ");

        int yearOfBirth = 0;
        //Ensures Scout is 4 years of age or over
        if ((currentYear - input.nextInt() > 3)) {
            yearOfBirth = input.nextInt();
        }
        else {
        }

        //Get the number of elements in the Arraylist
        int size = divisionList.numberOfDivisions();
        int index = 0;
        //If the Arraylist is empty
        if (size == 0) {
            addDivision();
            //list the divisions to the screen
            String divisionDetails = divisionList.listOfDivisions();
            System.out.println(divisionDetails);
            System.out.print("Choose " + Firstname + "'s Division by index ==>");
            index = input.nextInt();
        }
        else {
            //list the divisions to the screen
            String divisionDetails = divisionList.listOfDivisions();
            System.out.println(divisionDetails);
            System.out.print("Choose " + Firstname + "'s Division by index ==>");
            index = input.nextInt();
        }
        Division division = divisionList.getDivision(index);

        Scout s1 = new Scout(Firstname, Surname, address, dayOfBirth, monthOfBirth, yearOfBirth, gender, division);
        scoutList.addScout(s1);
    }
}
