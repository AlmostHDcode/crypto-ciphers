package io.github.hmatt33.ciphers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * calculates the frequency of letters in a string
 * @author Matt Hunt
 * @version 1.0 (Sept 19, 2019)
 */
public class FrequencyAnalysis {
    //array of characters that are the most frequent in words from most to least
    //ex: 'e' is the most common and first in array, 'z' is least common and last in array
    private static char[] normalFrequency = {'e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'};

    /**
     * Get method for normal frequency
     * @return the normal frequency of letters
     */
    public char[] getNormalFrequency() {
        return normalFrequency;
    }

    /**
     * takes a string input and analyses the frequency of the letters in the string
     * @param str the string to analyse
     * @return
     */
    public ArrayList<String> getFrequency(String str) {
        //array is length characters (122) because 122 is the ascii code for z which is the last character needed
        //every other alphabetic character is before 122
        int characters = 122;
        int[] frequencies = new int[characters];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //when putting a char as index of int array, it translates to ascii code for the character
            //index corresponds to ascii code of the character
            //value in array represents how many times the character is seen
            frequencies[c]++;
        }

        ArrayList<String> cipherFrequencies = new ArrayList<String>();
        for(int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] > 0) {
                char c = (char) i;
                int hits = frequencies[i];
                double freq = (double) hits / (double) str.length();
                DecimalFormat formatter = new DecimalFormat("#0.00");
                cipherFrequencies.add(hits + " hits " + formatter.format(freq) + "% Frequency:" + c);
            }
        }
        //because there is the number of times the character repeats first, sort will take the string and sort by the number
        //returns the list of the number of times seen and the character it corresponds to
        Collections.sort(cipherFrequencies, Collections.reverseOrder());
        return cipherFrequencies;
    }
}
