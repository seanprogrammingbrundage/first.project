public class Waypoint /*implements Comparable<Waypoint>*/ {
    private String type, state, name;
    private double toSpringer, toKatahdin;;
    private int elevation;

    /**
     * accessor method
     * @return the type of feature the waypoint is
     */
    public String getType() {
        return type;
    }

    /**
     * accessor method
     * @return the state in which the waypoint is
     */
    public String getState() {
        return state;
    }
    /**
     * accessor method
     * @return the name of the waypoint
     */
    public String getName() {
        return name;
    }
    /**
     * accessor method
     * @return the distance to the beginning of the trail (northbound)
     */
    public double getToSpringer() {
        return toSpringer;
    }
    /**
     * accessor method
     * @return the distance to the end of the trail (northbound)
     */
    public double getToKatahdin() {
        return toKatahdin;
    }
    /**
     * accessor method
     * @return the elevation of the waypoint
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * prints each attribute of a waypoint
     * @return a string showing every attribute of a given waypoint object
     */
    public String toString() {
        return
                type +
                ", " + state +
                ", " + name +
                ", dist to Springer " + toSpringer +
                ", dist to Katahdin " + toKatahdin +
                ", elev " + elevation;
    }

    /*public int compareTo(Waypoint other) {
        return this.elevation - other.elevation;
    } */

    /**
     * constructor for the class
     * @param t
     * @param n
     * @param s
     * @param tS
     * @param tK
     * @param e
     */
    public Waypoint(String t, String n, String s, double tS, double tK, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = tS;
        toKatahdin = tK;
        elevation = e;
    }

    /**
     * copy constructor
     * @param o
     */
    public Waypoint(Waypoint o) {
        this(o.getType(), o.getName(), o.getState(), o.getToSpringer(), o.getToKatahdin(), o.getElevation());
    }

}
