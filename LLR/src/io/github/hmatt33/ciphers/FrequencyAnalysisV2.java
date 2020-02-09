package io.github.hmatt33.ciphers;

import java.text.DecimalFormat;
import java.util.*;

/**
 * calculates the frequency of letters in a string
 * changed the getFrequency method to insert the calculated frequency into a hash map
 * @author Matt Hunt
 * @version 2.0 (Oct 27, 2019)
 */
public class FrequencyAnalysisV2 {
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
    public HashMap getFrequency(String str) {
        //array is length characters (122) because 122 is the ascii code for z which is the last character needed
        //every other alphabetic character is before 122
        //changed to 123 characters so looking for 'z' character 122, it won't go out of bounds
        int characters = 123;
        int[] frequencies = new int[characters];
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //when putting a char as index of int array, it translates to ascii code for the character
            //index corresponds to ascii code of the character
            //value in array represents how many times the character is seen
            frequencies[c]++;
        }

        //map created to hold frequency info
        HashMap cipherFrequencies = new HashMap<>();

        for(int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] > 0) {
                char c = (char) i;
                int hits = frequencies[i];
                double freq = (double) hits / (double) str.length();
                DecimalFormat formatter = new DecimalFormat("#0.00");
                cipherFrequencies.put(c, hits);
            }
        }
        //custom comparator used to sort the map by value in descending order
        cipherFrequencies = sortMap(cipherFrequencies);
        return cipherFrequencies;
    }

    /**
     * Custom sort method for hashmap that sorts by the value in descending order
     * @param map the map to be sorted
     * @return the sorted map based on value desc
     */
    private static HashMap sortMap(HashMap map) {
        List list = new LinkedList(map.entrySet());
        //Custom Comparator
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        //changes from ascending to descending
        Collections.reverse(list);

        //copies sorted map to LinkedHashMap to keep insert order correct
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
