package io.github.hmatt33.ciphers;

import java.util.*;

/**
 * Class that takes a list of possible plaintexts and calculates the LLR of each to find the real plaintext
 * Highest LLR is the real english plaintext
 * @author Matt Hunt
 * @version 1.0 (Oct 27, 2019)
 */
public class LLR {

    public String calcLLR(String[] plains) {
        //normal frequency of letters in english
        HashMap<Character, Double> nFreq = new HashMap<>();
        //all normal frequencies
        nFreq.put('a', 0.082);
        nFreq.put('b', 0.015);
        nFreq.put('c', 0.028);
        nFreq.put('d', 0.043);
        nFreq.put('e', 0.127);
        nFreq.put('f', 0.022);
        nFreq.put('g', 0.020);
        nFreq.put('h', 0.061);
        nFreq.put('i', 0.070);
        nFreq.put('j', 0.002);
        nFreq.put('k', 0.008);
        nFreq.put('l', 0.040);
        nFreq.put('m', 0.024);
        nFreq.put('n', 0.067);
        nFreq.put('o', 0.075);
        nFreq.put('p', 0.019);
        nFreq.put('q', 0.001);
        nFreq.put('r', 0.060);
        nFreq.put('s', 0.063);
        nFreq.put('t', 0.091);
        nFreq.put('u', 0.028);
        nFreq.put('v', 0.010);
        nFreq.put('w', 0.023);
        nFreq.put('x', 0.001);
        nFreq.put('y', 0.020);
        nFreq.put('z', 0.001);

        //all plains and their calculated LLR will be put into this map
        HashMap<String, Double> allLLR = new HashMap<>();
        //frequency distribution of noise, always 1/26
        double pn = 1.0 / 26.0;

        //loop through all plains
        for(int i = 0; i < plains.length; i++) {
            //LLR of this plain
            Double LLRx = 0.0;
            String p = plains[i];
            //run frequency analysis on each plain
            FrequencyAnalysisV2 faV2 = new FrequencyAnalysisV2();
            //frequency analysis returns a hash map for each plain
            HashMap<Character, Integer> pFreq = faV2.getFrequency(p);

            //loop through hash map
            Set set = pFreq.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry me = (Map.Entry)iterator.next();
                //the character key in the hash map
                Character c = (Character) me.getKey();
                //the frequency count of each character
                Integer count = (Integer) me.getValue();
                //the normal frequency of that same character
                Double pe = nFreq.get(c);
                //calculated llr of plain using formula
                LLRx = LLRx + ((count / (double) p.length()) * Math.log(pe / pn));
            }
            //add plain and llr to all llr hash map
            allLLR.put(p, LLRx);
        }
        //find the max LLR
        //the String associated with the max LLR is the real decrypted plaintext
        String realPlain = Collections.max(allLLR.entrySet(), Map.Entry.comparingByValue()).getKey();
        return realPlain;
    }
}
