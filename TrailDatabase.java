import java.util.*;
import java.io.File;

/**
 * Trail Database takes in a set of locations along the Appalachian trail and organizes them based on the users input.
 * @version 05/01/2022
 * @author 23brundage
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private static int searchTerm;
    private boolean asc;


    /**
     * constructor for the class
     * @return none
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
        //sortDB();
    }

    /**
     * takes input from the user, and uses selection structure to decide how the data will be organized.
     * @return none
     */
    public void getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints + \n" +
                "TY: by type\n" +
                "NA: by name\n" +
                "ST: by state\n" +
                "DS: by distance to Springer\n" +
                "DK: by distance to Katahdin\n" +
                "EL: by elevation\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your preferred sort by term or 'Q' to quit: ");
        String term = in.nextLine().toUpperCase();
            if (term.equals("TY"))
                searchTerm = 1;
            else if (term.equals("NA"))
                searchTerm = 2;
            else if (term.equals("ST"))
                searchTerm = 3;
            else if (term.equals("DS"))
                searchTerm = 4;
            else if (term.equals("DK"))
                searchTerm = 5;
            else if (term.equals("EL"))
                searchTerm = 6;
            else
                searchTerm = 0;

            System.out.print("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
            term = in.nextLine();
            asc = (term.equals("A")) ? true : false;
    }

    private void selectionSort() {
        WaypointComparator wc = new WaypointComparator(searchTerm, asc);
        Waypoint toSwap;
        int index;
        //
        for(int out = 0; out < database.size();out++) {
            index = out;
            toSwap = database.get(out);
            for(int in = out+1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    index = in;
                    toSwap = new Waypoint(database.get(index));
                }

            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
    }
    /*
    private void recursiveSort(ArrayList<Waypoint> a, int from, int to) {
        WaypointComparator comp1 = new WaypointComparator(searchTerm, asc);
        if(to - from < 2) {
            if(to > from && comp1.compare(a.get(to), a.get(from)) < 0) {
                Waypoint aTemp = a.get(to);
                a.set(to, a.get(from));
                a.set(from, a.get(from));
            }
        }
        else {
            int middle = (from + to)/2;
            recursiveSort(a, from, middle);
            recursiveSort(a, middle+1, to);
            merge(a, from, middle, to);
        }
    }

    public void merge(ArrayList<Waypoint> a, int from, int to, int middle) {
        int i = from, j = middle + 1, k = from;
        WaypointComparator comp2 = new WaypointComparator(searchTerm, asc);
        while(i <= middle && j <= to) {
            if(comp2.compare(a.get(i), a.get(j)) < 0) {
                database.set(k, a.get(i));
                i++;
            }
            else {
                database.set(k, a.get(j));
                j++;
            }
            k++;
        }
        while(i <= middle) {
            database.set(k, a.get(i));
            i++;
            k++;
        }
        while(j <= to) {
            database.set(k, a.get(i));
            j++;
            k++;
        }
        a = new ArrayList<>(database);

    }
*/

    /**
     * uses a scanner to organize text file into an arraylist of waypoints.
     * @return none
     */
    public void populateDatabase() {
        try {
            Scanner in = new Scanner(new File("apptrailDB.txt"));
            while(in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                database.add(new Waypoint(line[0], line[1], line[2],
                        Double.parseDouble(line[5]), Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *prints organized data
     * @return none
     */
    public void printDB() {
        for(Waypoint w: database)
            System.out.println(w);
    }

    //public void sortDB() {
    //    Collections.sort(database, new WaypointComparator(2, false));
    //}

    /**
     * main method for the lab executes the program.
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        while(true) {
            db.getSearchTerm();
            if(searchTerm == 0)
                break;
            db.selectionSort();
            //db.sortDB();
            //db.recursiveSort(db.database, 0, db.database.size());
            //if(db.searchTerm == 0)
            db.printDB();
        }
    }
}
