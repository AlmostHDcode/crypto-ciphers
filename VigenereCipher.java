package io.github.hmatt33.ciphers;

/**
 * Class that shows the vingenere algortihm to encrypt and decrypt
 * @author Matt hunt
 * @version 1.0 (sept 23, 2019)
 */
public class VigenereCipher {

    /**
     * method that creates the key from the keyword
     * repeats the keyword until it makes the length of the plaintext
     * @param plain the String to encrypt
     * @param keyWord the word that is used to create the key
     * @return the created key
     */
    public String createKey(String plain, String keyWord) {
        int len = plain.length();
        String key = "";
        for(int i = 0; i < len; i++) {
            if((key.length() != plain.length())) {
                if(i == keyWord.length()) {
                    i = -1;
                } else {
                    key = key + keyWord.charAt(i);
                }
            }
        }
        return key;
    }

    /**
     * encyption method with vigenere algorithm
     * @param plain the string to encrypt
     * @param key the created key from createKey()
     * @return the encrypted ciphertext
     */
    public String vigenereEncrypt(String plain, String key) {
        //only works with upper case
        //tried to get it to work with lower case but the math seems to not work out the same for some reason
        String cipher = "";

        for(int i = 0; i < plain.length(); i++) {
            char plainChar = plain.charAt(i);
            char keyChar = key.charAt(i);
            char c = (char) (((plainChar + keyChar) % 26) + 'A');
            cipher = cipher + c;
        }
        return cipher;
    }

    /**
     * decryption vingenere method
     * @param cipher the cipher to decrypt
     * @param key the created key with createKey()
     * @return the decrypted plaintext
     */
    public String vigenereDecrypt(String cipher, String key) {
        //only works with upper case
        //tried to get it to work with lower case but the math seems to not work out the same for some reason
        String plain = "";

        for(int i = 0; i < cipher.length(); i++) {
            char cipherChar = cipher.charAt(i);
            char keyChar = key.charAt(i);
            char c = (char) (((26 + (cipherChar - keyChar)) % 26) + 'A');
            plain = plain + c;
        }
        return plain;
    }

}
