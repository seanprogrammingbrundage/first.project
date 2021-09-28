/**
 * SimpleIOMath is a relatively basic input output that takes, stores, manipulates, and outputs user input
 * @version 9/27/2021
 * @author seanbrundage
 */
import java.util.Scanner;
import java.lang.String;

public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;
    public int smallestPrime(int age) {
        for (int i = 2; i <= (int) (Math.sqrt(age)) + 1; i++) {
            if (age % i == 0)
                return i;
        }
        return age;
    }

    /**
     * Takes the user information and stores it in the predeclared variables
     * @param args none
     */
    public void promptUser()   {
        Scanner input = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.print("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.print("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();

    }

    public void printInfo()   {
        System.out.println("I'm gonna teach you how to sing it out \nCome on, come on, come on \nLet me tell you what it's all about \nReading, writing, arithmetic \nAre the branches of the learning tree");
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        int nextAge = Integer.valueOf(age)+1;
        //https://www.javatpoint.com/java-string-to-int
        System.out.println("At your next birthday, you will turn " + nextAge);
        System.out.println("The first prime factor of "+age+ " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: "+favNumber);
        System.out.println("Your favorite number squared is "+favNumber*favNumber);

    }

    /**
     * main entry point for SimpleIOMath, executes program
     * @param args none
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *\n* All you gotta do is repeat after me *");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
        System.out.println("* end of program *");
    }
}
