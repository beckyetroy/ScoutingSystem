import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class creates an ArrayList and contains methods to access and edit the objects (scouts) in the ArrayList
 *
 * @author Becky Troy
 */

public class ScoutList {

    /**
     * Default Constructor for class Scoutlist
     */
    public ScoutList() {
    }

    /**
     * Declares and initiates a private ArrayList of type Scout, called scouts
     */
    private ArrayList<Scout> scouts = new ArrayList<>();

    /**
     * Method to add a Division object to the ArrayList
     */
    public void addScout(Scout scout) {
        scouts.add(scout);
    }

    /**
     * Method to return a Division object by its index
     */
    public Scout getScout(int index) {
        //Validation statement - ensures the index entered is not empty in the Arraylist
        if((index < (scouts.size()) && (index > 0))) {
            return scouts.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * Method to remove a Scout object from the Arraylist
     */
    public boolean removeScout(int index) {
        boolean removed = false;
        //Validation statement - ensures index entered is not empty in the Arraylist
        if ((index < (scouts.size()) && (index > 0))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to return the number of objects in the Arraylist
     */
    public int numberOfScouts () {
        return scouts.size();
    }

    /**
     * Method to build and return a String with all the Scout objects in the ArrayList
     */
    public String listOfScouts() {
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            return "There are no scouts in the list.";
        }
        else {
            String listOfScouts = "";
            for (int i = 0; i < scouts.size(); i++) {
                listOfScouts = listOfScouts + "Index: " + i + ": " + scouts.get(i).toString() + "\n";
            }
            return listOfScouts;
        }
    }

    /**
     * Method to build and return a String of all Scout objects in the Arraylist whose divisionName matches the one passed as parameter
     */
    public String listScoutsBySpecificDivision(String String) {
        String result = new String();
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            return "There are no scouts stored in the list.";
        }
        else {
            for (int i = 0; i < scouts.size(); i++) {
                String scout = scouts.get(i).toString();

                if (scout.toUpperCase().contains(String.toUpperCase())) {
                    result = "Scout details ==> " + scout + "\n";
                }
                //If the Arraylist is empty for the parameter passed
                else {
                    result = "There are no scouts for the Division: " + String;
                }
            }
            return result;
        }
    }

    /**
     * Method to build and return a String of all Scout objects in the Arraylist whose gender matches the one passed as parameter
     */
    public String listScoutsByGender(String String) {
        String result = new String();
        //If the Arraylist is empty
        if (scouts.size() == 0) {
            return "There are no scouts stored in the list.";
        }
        else {
            for (int i = 0; i < scouts.size(); i++) {
                String scout = scouts.get(i).toString();
                String gender = scouts.get(i).getGender();

                if (gender.toUpperCase().equals(String.toUpperCase())) {
                    result = "Scout details ==> " + scout + "\n";
                }
                //If the Arraylist is empty for the parameter passed
                else if ((!gender.toUpperCase().equals(String.toUpperCase())) && ((String.toUpperCase().equals("M")) | (String.toUpperCase().equals("F")))) {
                    result = "There are no scouts of the gender: " + String;
                }
                else {
                    result = "Invalid format. Please enter either (M/F)";
                }
            }
            return result;
        }
    }

    /**
     * Method to save all objects in Arraylist to an external .xml file
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("divisions.xml"));
        out.writeObject(scouts);
        out.close();
    }

    /**
     * Method to load all objects in Arraylist from an external .xml file
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("divisions.xml"));
        scouts = (ArrayList<Scout>) is.readObject();
        is.close();
    }

}
