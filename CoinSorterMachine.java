import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


/**
 * A program that takes in a text file containing coin values to be
 * deposited and prints the amount deposited as well as a summary of the transactions
 * @version 3/30/2022
 * @author 23brundage
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinMap;



    /**
     * initializes coins ArrayList
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
    }

    /**
     *  use one or two Scanner objects, prompting user for the appropriate file
     *  name and importing the data from filename – MUST handle diabolic values!
     */

    public void depositCoins() {
        String input = "";
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the data file for coin deposit: ");
            input = sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            Scanner in = new Scanner(new File(input));
            while(in.hasNext()) {
                int amount = in.nextInt();
                if(amount == 1)
                    coins.add(new Penny());
                else if(amount == 5)
                    coins.add(new Nickel());
                else if(amount == 10)
                    coins.add(new Dime());
                else if(amount == 25)
                    coins.add(new Quarter());
                else if(amount == 50)
                    coins.add(new HalfDollar());
                else if(amount == 100)
                    coins.add(new Dollar());
                else
                    System.out.println("Coin value "+ amount + " not recognized");

            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Prints deposit summary using a DecimalFormat object (see output section)
     */

    public void printDepositSummary() {
        int pennyCount = 0;
        int nickelCount = 0;
        int dimeCount = 0;
        int quarterCount = 0;
        int halfDollarCount = 0;
        int dollarCount = 0;
        for(Coin c : coins) {
            if(c.getName() == "penny")
                pennyCount += 1;
            if(c.getName() == "nickel")
                nickelCount += 1;
            if(c.getName() == "dime")
                dimeCount += 1;
            if(c.getName() == "quarter")
                quarterCount += 1;
            if(c.getName() == "half dollar")
                halfDollarCount += 1;
            if(c.getName() == "dollar")
                dollarCount += 1;
        }
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Summary of deposit: ");
        System.out.println("\t" + pennyCount + " pennies $" + df.format(pennyCount/100.));
        System.out.println("\t" + nickelCount + " nickels $" + df.format((nickelCount*5)/100.));
        System.out.println("\t" + dimeCount + " dimes $" + df.format((dimeCount*10)/100.));
        System.out.println("\t" + quarterCount + " quarters $" + df.format((quarterCount*25)/100.));
        System.out.println("\t" + halfDollarCount + " half dollars $" + df.format((halfDollarCount*50)/100.));
        System.out.println("\t" + dollarCount + " dollars $" + df.format(dollarCount));
        System.out.println("TOTAL DEPOSIT: $" + df.format(getTotalValue()));


    }

    /**
     *  return the total value of all Coin objects stored in coins as a double
     * @return the total deposit amount
     */

    public double getTotalValue() {
        double total = 0;
        for(Coin temp : coins)
            total += temp.getValue();
        return total;

    }

    /**
     * main method for the program executes code
     * @param args
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
