/**
 *
 */
package io.github.hmatt33.coincidence;

import java.util.ArrayList;

/**
 * @author Matt Hunt
 * @version 1.0
 * Oct 10, 2019
 */

public class IOC {

    public double CalcIOC(String str) {
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

        ArrayList<Integer> newFreqList = new ArrayList<Integer>();
        for(int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] > 0) {
                int hits = frequencies[i];
                newFreqList.add(hits);
            }
        }

        double ioc = 0.0;
        double total = str.length();
        for(int i = 0; i < newFreqList.size(); i++) {
            double x = (newFreqList.get(i) / total);
            double y = Math.pow(x, 2);
            ioc = ioc + y;
        }
        return ioc;
    }
}
