/** Complex program that detects substring in arguments to convert roman numerals into decimal form
 * @version 10/3/2021
 * @author seanbrundage
 */
public class RomanToDecimal {
    /**
     * handles the arguments, detects string within them and converts numerals to decimals
     * based on predetermined values, as well as detects invariants
     * @param roman
     * @return
     */
    public static int romanToDecimal(String roman)  {
        int decimal = 0;
        for(int i = 0; i < roman.length(); i++)  {
            //System.out.println(roman.substring(i, i+1).toUpperCase());
            if(roman.substring(i, i+1).toUpperCase().equals("I"))  {
                decimal += 1;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("V"))  {
                decimal += 5;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("X")) {
                decimal += 10;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("L")) {
                decimal += 50;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("C")) {
                decimal += 100;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("D")) {
                decimal += 500;
            }
            else if(roman.substring(i, i+1).toUpperCase().equals("M")) {
                decimal += 1000;
            }
            else  {
                return -1;
            }
        }
        // while loop is an extra, allows for multiple distinct invariants to be detected
        // but can not detect multiple of the same invariant this avoids args like "IXL" from being
        // read as 39 when, although illogical, should be 49
        do {
            roman = roman.toUpperCase();
            if (roman.indexOf("IV") != -1) {
                decimal -= 2;
                roman = roman.replace("IV", "");
            }
            if (roman.indexOf("IX") != -1) {
                decimal -= 2;
                roman = roman.replace("IX", "");
            }
            if (roman.indexOf("XL") != -1) {
                decimal -= 20;
                roman = roman.replace("XL", "");
            }
            if (roman.indexOf("XC") != -1) {
                decimal -= 20;
                roman = roman.replace("XC", "");
            }
            if (roman.indexOf("CD") != -1) {
                decimal -= 200;
                roman = roman.replace("CD", "");
            }
            if (roman.indexOf("CM") != -1) {
                decimal -= 200;
                roman = roman.replace("CM", "");
            } else {
                roman = "";
            }
        }
        while (roman != "");
        return decimal;
    }

    /**
     * main entry point, executes the program
     * @param args
     */
    public static void main(String[] args) {
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if (val == -1)
                System.out.println("Input: " + temp + "Output: invalid");
            else
                System.out.println("Input: " + temp + "=> output " + val);
        }
    }
}
