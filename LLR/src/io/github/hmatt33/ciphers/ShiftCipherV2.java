package io.github.hmatt33.ciphers;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implements the shift cipher algorithm to encrypt and decrypt a message
 * Frequency analysis to get the possible keys uses HashMap
 * LLR is implemented in decrypt method to pick the right key
 * @author Matt Hunt
 * @version 2.0 (Oct 27, 2019)
 */
public class ShiftCipherV2 {

    /**
     * Encrypt using the shift cipher algorithm
     * @param plaintext the text to be encrypted
     * @param shiftKey the amount of shift
     * @return the encrypted ciphertext
     */
    public String shiftCipherEncrypt(String plaintext, int shiftKey) {
        String cipher = "";
        for(int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if(c <= ('z' - shiftKey)) {
                char newChar = (char) (c + shiftKey);
                cipher = cipher + newChar;
            } else {
                char newChar = (char) (c - (26 - shiftKey));
                cipher = cipher + newChar;
            }
        }
        return cipher;
    }

    /**
     * runs a frequency analysis and gets back the hashmap of the frequencies
     * uses the new frequencies and compares to normal frequencies to get possible keys
     * @param ciphertext the text to be decrypted
     * @return the list of possible shift values
     */
    public int[] getPossibleKeys(String ciphertext) {
        FrequencyAnalysisV2 fa = new FrequencyAnalysisV2();
        char[] normFreq = fa.getNormalFrequency();
        HashMap results = fa.getFrequency(ciphertext);
        ArrayList<Character> newFreq = new ArrayList<>();
        for(Object k : results.keySet()) {
            newFreq.add((Character) k);
        }
        int shift;
        int[] possibleShifts = new int[26];
        //maps the first new frequency character to the first 10 normal frequencies to get 10 possible shift keys
        for(int i = 0; i < 26; i++) {
            int x = newFreq.get(0);
            int y = normFreq[i];
            if(x >= y) {
                shift = x - y;
                possibleShifts[i] = shift;
            } else {
                shift = ('z' - y) + (x - 'a');
                possibleShifts[i] = shift;
            }
        }
        return possibleShifts;
    }

    /**
     * decryption method that takes the ciphertext and the calculated possible shifts from getPossibleKeys() to decrypt
     * @param ciphertext the text to be decrypted
     * @return the list of possible decrypted plaintexts
     */
    public String[] getPossiblePlains(String ciphertext) {
        int[] possibleShifts = getPossibleKeys(ciphertext);
        String plain = "";
        String[] plains = new String[26];

        for(int i = 0; i < possibleShifts.length; i++) {
            plain = "";
            for(int j = 0; j < ciphertext.length(); j++) {
                int shiftKey = possibleShifts[i];
                char c = ciphertext.charAt(j);
                if(c >= ('a' + shiftKey)) {
                    char newChar = (char) (c - shiftKey);
                    plain = plain + newChar;
                    plains[i] = plain;
                } else {
                    char newChar = (char) ((c - shiftKey) + 26);
                    plain = plain + newChar;
                    plains[i] = plain;
                }
            }
        }
        return plains;
    }

    /**
     * takes the list of possible plains from getPossiblePlains and calculates the LLR of each plain
     * the plain with the highest LLR is the most likely to be the correct plaintext decryption
     * @param plains the list of possible plains
     * @return plain, the correct plaintext decryption that had the highest LLR
     */
    public String shiftCipherDecrypt(String[] plains) {
        LLR tester = new LLR();
        String plain = tester.calcLLR(plains);
        return plain;
    }

}