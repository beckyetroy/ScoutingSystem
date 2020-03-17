import java.util.ArrayList;

/**
 * This class creates an ArrayList and contains methods to access and edit the objects (divisions) in the ArrayList
 *
 * @author Becky Troy
 */
public class DivisionList {
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

    public Division getDivision(int index) {
        if((index < (divisions.size()) && (index > 0))){
           return divisions.get(index);
        }
        else {
            return null;
        }
    }

    public int numberOfDivisions () {
        return divisions.size();
    }

    public boolean removeDivision(int index) {
        boolean removed = false;
        if ((index < (divisions.size()) && (index > 0))) {
            return true;
        }
        else {
            return false;
        }
    }

    public String listOfDivisions() {
        if (divisions.size() == 0) {
            return "There are no divisions in the list.";
        }
        else {
            String listOfDivisions = "";
            for (int i = 0; i < divisions.size(); i++) {
                listOfDivisions = listOfDivisions + "Index: " + i + ": " + divisions.get(i) + "\n";
            }
            return listOfDivisions;
        }
    }
}
