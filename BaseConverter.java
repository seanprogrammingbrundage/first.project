import java.util.Scanner;
import java.io.*;
import java.util.*;
/**
 * Base Converter opens a data files, reads, converts numbers, prints
 * @version 11/18/2021
 * @author 23brundage
 */
public class BaseConverter {
    // Constructor for class.
    public BaseConverter() {
    }

    /**
     *  Convert a String num in fromBase to base-10 int.
     * @param num, fromBase
     */
    public static int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0, exp = 0;
        String toNum = "";
        for(int i = num.length()-1; i >= 0;i--) {
            sum += alpha.indexOf("" + num.charAt(i)) * Math.pow(base, exp);
            exp++;
        }
        return sum;
    }

    /**
     * Convert a base-10 int to a String number of base toBase.
     * @param num, toBase
     */
    public static String intToStr(int num, int toBase){
        String alpha = "0123456789ABCDEF";
        String toNum = "";

        while(num > 0) {
            toNum = alpha.charAt(num % toBase) + toNum;
            num /= toBase;
        }
        if(toNum.equals(""))
            return "0";
        return toNum;
    }
    /**
     * Opens the file stream, inputs data one line at a time,
     * converts, prints the result to the console window and writes data to the output stream.
      */

    public void inputConvertPrintWrite(){
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values30.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("Invalid input base " + fromBase + "\t");
                }
                else if(toBase < 2 || toBase > 16) {
                    System.out.println("Invalid output base " + toBase + "\t");
                }
                else {
                    for(String val : line){
                        //System.out.println(val + "\t");
                        //pw.print(val + "\t");

                    }
                    System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + " base " + toBase);
                    pw.print(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase + "\n");

                }
                for (String val : line){}
                    //System.out.println(val + "\t");
                //System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        if(sc != null)
            sc.close();
        if(pw != null)
            pw.close();
    }

    /**
     * Main method for class BaseConverter
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
        // attempted extra, I think that the closing of the print writer stop main from continuing
        /*
        Scanner n = new Scanner(System.in);
        String cont = n.nextLine();
        System.out.println("Would you like to continue converting? ");
        while (true) {
            if (!cont.toLowerCase().contains("y")) {
                break;
            }
            System.out.println("What number would you like to convert? ");
            String num = n.nextLine();
            System.out.println("What base is your number in? ");
            String startBase = n.nextLine();
            System.out.println("What base would you like to convert to? ");
            int endBase = n.nextInt();
            System.out.println("Your number: " + num + " in base " + endBase + " is" + intToStr(strToInt(num, startBase), endBase));


        }*/
    }
}
