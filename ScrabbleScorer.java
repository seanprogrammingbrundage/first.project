import java.io.File;
import java.util.*;

/**
 * ScrabbleScorer is a basic io that takes user input in the form of a word, finds the scrabble score associated with the word, and outputs this information
 * @version 01/24/2022
 * @author 23brundage
 */

public class ScrabbleScorer {
    private static ArrayList<String> dictionary;
    private static int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private static String alpha;

    /**
     * Constructor for the class
     * @param
     * @return void
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();

    }

    /**
     * Scans the dictionary file in and stores it in an arraylist
     * @param
     * @return void
     */
    public void buildDictionary() {
        //try/catch -- scanner - data file -- close stream when finished -- sort using Collections.sort()
        Scanner dict = null;
        try {
            dict = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(dict.hasNext()) {
                dictionary.add(dict.next());
            }
            dict.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        Collections.sort(dictionary);
    }

    /**
     * Checks whether or not the user inputs a word that exists in the dictionary
     * @param word
     * @return boolean
     */

    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine().toUpperCase();
                if (userWord.contains("0")) {
                    System.out.println("Exiting the program thanks for playing!");
                    break;
                }
                if(app.isValidWord(userWord)) {
                    int pointScore = app.getWordScore(userWord);
                    System.out.println(userWord.toLowerCase() + " = " +pointScore);
                }
                else {
                    System.out.println("Invalid Word, Try Again");
                }
            }
    }

    /**
     * evaluates the score of the user's word based on predetermined values of letters
     * @param word
     * @return int
     */
    public int getWordScore(String word) {
        int sum = 0;
        for(int i = 0; i < word.length(); i++)
            sum += points[alpha.indexOf(word.charAt(i))];
        return sum;
        
    }



}
