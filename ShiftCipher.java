package io.github.hmatt33.ciphers;

import java.util.ArrayList;

/**
 * Implements the shift cipher algorithm to encrypt and decrypt a message
 * @author Matt Hunt
 * @version 1.0 (Sept 23, 2019)
 */
public class ShiftCipher {

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
     * Helper method to shiftCipherDecrypt
     * runs a frequency analysis on the ciphertext and maps the most common letter to the first 10 common english plaintext letters
     * this generatres 10 different possible shift values that act of the key
     * @param ciphertext the text to be decrypted
     * @return the list of possible shift values
     */
    public int[] getPossibleKeys(String ciphertext) {
        FrequencyAnalysis fa = new FrequencyAnalysis();
        char[] normFreq = fa.getNormalFrequency();
        ArrayList<String> results = fa.getFrequency(ciphertext);
        ArrayList<Character> newFreq = new ArrayList<>();
        for(int i = 0; i < results.size(); i++) {
            String temp = results.get(i);
            newFreq.add(temp.charAt(temp.length() - 1));
        }
        int shift;
        int[] possibleShifts = new int[10];
        //maps the first new frequency character to the first 10 normal frequencies to get 10 possible shift keys
        for(int i = 0; i < 10; i++) {
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
    public String[] shiftCipherDecrypt(String ciphertext) {
        int[] possibleShifts = getPossibleKeys(ciphertext);
        String plain = "";
        String[] plains = new String[10];

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

}