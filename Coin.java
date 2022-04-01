public abstract class Coin {

    public abstract double getValue();
    public abstract String getName();

    /**
     * method to return the plural name of a given coin
     * @return the plural name of the coin
     */
    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
