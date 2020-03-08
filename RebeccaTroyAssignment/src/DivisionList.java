import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * This class creates an ArrayList and contains methods to access and edit the objects (divisions) in the ArrayList
 *
 * @author Becky Troy
 */
public class DivisionList {

    /**
     * Default Constructor for class Divisionlist
     */
    public DivisionList() {
    }

    /**
     * Declares and initiates a private ArrayList of type Division, called divisions
     */
    private ArrayList<Division> divisions = new ArrayList<>();

    /**
     * Method to add a Division object to the ArrayList
     */
    public void addDivision(Division division) {
        divisions.add(division);
    }

    /**
     * Method to return a Division object by its index
     */
    public Division getDivision(int index) {
        //Validation statement - ensures the index entered is not empty in the Arraylist
        if((index < (divisions.size()) && (index > 0))) {
            return divisions.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * Method to return the number of objects in the Arraylist
     */
    public int numberOfDivisions () {
        return divisions.size();
    }

    /**
     * Method to remove a Division object from the Arraylist
     */
    public boolean removeDivision(int index) {
        divisions.remove(index);
        //Validation statement - ensures index entered is not empty in the Arraylist
        if ((index < (divisions.size()) && (index >= 0))) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method to build and return a String with all the Division objects in the ArrayList
     */
    public String listOfDivisions() {
        //Validation statement - ensures that the Arraylist is not empty
        if (divisions.size() == 0) {
            return "There are no divisions in the list.";
        }
        else {
            String listOfDivisions = "";
            for (int i = 0; i < divisions.size(); i++) {
                listOfDivisions = listOfDivisions + "Index: " + i + ": " + divisions.get(i).toString() + "\n";
            }
            return listOfDivisions;
        }
    }

    /**
     * Method to save all objects in Arraylist to an external .xml file
     */
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("divisions.xml"));
        out.writeObject(divisions);
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
        divisions = (ArrayList<Division>) is.readObject();
        is.close();
    }
}
