import java.util.*;
import java.io.*;

/**
 * program built to find all words in the dictionary built up of two smaller words, which also are contained in the dictionary
 * @version 02/01/2022
 * @author 23brundage
 */

public class SubWordFinder {
    private ArrayList<ArrayList<String>> dictionary;
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * constructor for the class
     * @param
     * @return null
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * Searches for the supplied word in the dictionary using Collections.binarySearch or the programmer defined indexOf method
     * @param word
     * @return whether or not a word is contained inside the dictionary, in boolean form
     */
    private boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
    }

    /*public String findShortestWord() {
        String shortestWord = dictionary.get(0).get(0);
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                if(word.length() < shortestWord.length())
                    shortestWord = word;
            }
        }
        return shortestWord;
    }*/

    /**
     * Scans a text file in and adds every word, already sorted alphabetically, to an arraylist
     * @param
     * @return null
     */
    public void populateDictionary() {
        try {
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Splits up each word in the dictionary into two words, and searches for whether
     * @return an arraylist filled with all words in the dictionary that contain subwords
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subWords = new ArrayList<>();
        int count = 0;
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                for(int i = 3; i < word.length()-2; i++) {
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);
                    if(inDictionary(sub1) && inDictionary(sub2)) {
                        subWords.add(new SubWord(word, sub1, sub2));
                        //count += 1;
                    }
                }
            }
        }
        for(int i = 0; i < subWords.size(); i++)
            System.out.println(subWords.get(i));
        //System.out.println(count);
        return subWords;
    }
    /*public void printDictionary() {
        for(ArrayList<String> bucket : dictionary) {
            System.out.println(bucket);
        }
    }*/
    
    private int indexOf(ArrayList<String> bucket, String word) {
        int low = 0, high = bucket.size()-1;
        while(low <= high) {
            int mid = (low + high)/2;
            if(bucket.get(mid).compareTo(word) == 0)
                return mid;
            else if(bucket.get(mid).compareTo(word) < 0)
                low = mid +1;
            else
                high = mid-1;
        }
        return -1;
    }

    /**
     * main entry point for the program executes the code
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        //System.out.println(app.findShortestWord());
        app.getSubWords();

    }

}
