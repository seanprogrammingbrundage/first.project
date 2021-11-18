import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * BMICalculator receives the users height and weight and outputs their BMI
 * @version 14 November 2021
 * @author 23brundage
 */
public class BMICalculator {
    /**
     * takes the sanitized values for the height and weight of the user and calculates the BMI based on an equation
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, double pounds) {
        if(inches == 0)
            return 0;
        if(inches < 0)
            return 0;
        if(pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*0.0254, 2);
    }

    /**
     * takes the height input from the user and reworks it to an integer.
     * @param heightInput
     * @return
     */
    public static int extractInches(String heightInput) {
        int qtPos = heightInput.indexOf("'");
        int dblQtPos = heightInput.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(heightInput.substring(0, qtPos));
        int inches = Integer.parseInt(heightInput.substring(qtPos + 1, dblQtPos));

        if (inches < 0 || inches > 11 || feet < 0)
            return -1;
        return feet * 12 + inches;
    }
/**
 * main entry point for the program, executes the program
 * @param args if needed
 *
 */
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner in = new Scanner(System.in);
        String height = "";
        String cont = "";
        while (true) {
            System.out.print("Enter your height in feet and inches - Ex. 6'1\": ");
            height = in.nextLine();
            if(!height.contains("\"")){
                System.out.println("Invalid Input, try again");
                continue; }
            if(!height.contains("'")){
                System.out.println("Invalid Input, try again");
                continue;}
            int weight = 0;
            try {
                System.out.print("Enter your weight in pounds - Ex. 145: ");
                weight = in.nextInt();
            }
            catch(Exception e) {
                continue;
            }
            in.nextLine();
            double bmi = computeBMI(extractInches(height), weight);
            System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(bmi));
            System.out.print("Would you like to continue? (Y/N)");
            cont = in.nextLine();
            if (!cont.toLowerCase().equals("y"))
                break;
        }
    }
}
