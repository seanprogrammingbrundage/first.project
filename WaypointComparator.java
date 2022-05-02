import java.util.Comparator;

/**
 * A waypoint comparator is passed to a sorting method in order to define which object is "before" or "after" another
 * @version 05/01/2022
 * @author 23brundage
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;


    /**
     * primary constructor for the class
     * @param c category of the waypoint comparator
     * @param a direction of the waypoint comparator
     */
    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;

    }

    /**
     * constructs a Waypoint comparator without a given order asc/dsc
     * @param c the category of the waypoint comparator
     */
    public WaypointComparator(int c) {
        category = c;
        asc = true;
    }

    /**
     * constructs a waypoint comparator with no given criteria on sorting
     */
    public WaypointComparator() {
        category = 4;
        asc = true;
    }

    /**
     * required method for the comparator interface organizes objects based on set criteria
     * @param one the first object to be compared.
     * @param two the second object to be compared.
     * @return Which of two waypoints objects is "ahead" of another.
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if (category == 1)
            diff = one.getType().compareTo(two.getType());
        else if(category == 2)
            diff = one.getName().compareTo(two.getName());
        else if(category == 3)
            diff = one.getState().compareTo(two.getState());
        else if(category == 4) {
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 5) {
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 6)
            diff = one.getElevation() - two.getElevation();
        return asc ? diff : -diff;
    }

    /**
     * testing method to see what the instance variables were assigned to.
     * @return a string showing which category and direction the comparator was given
     */
    public String toString()    {
        return "WC " + category + ", " + asc;
    }

}
