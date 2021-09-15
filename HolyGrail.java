/**
 * HolyGrail is a BasicIO talk back program that takes, stores, and prints back user input.
 * @version 09/15/2021
 * @author seanbrundage
 */

import java.util.Scanner;

public class HolyGrail {

    public static void main(String[] args) {
        /**
         * Main entry point for public class HolyGrail, executes program
         * @param args none
         */
        System.out.println("* A chat with the bridge keeper *" + '\n' + "Who would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        String name = input.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = input.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = input.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"");
        System.out.println("Your name is: " + name);
        System.out.println("Your quest is: " + quest);
        System.out.println("Your favorite color is: " + color);
        System.out.println("* end of program *");
    }
}


