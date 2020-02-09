package io.github.hmatt33.ciphers;

/**
 * Class that has both encrypt and decrypt Affine Cipher methods
 * @author Matt Hunt
 * @version 1.0 (Sept 23, 2019)
 */
public class AffineCipher {

    private int a;
    private int b;

    /**
     * AffineCipher Constructor, creates AffinceCipher with a and b as a key
     * @param a part of the key
     * @param b part of the key
     */
    public AffineCipher(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Takes the plaintext input and runs the encryption function
     * @param plaintext the text to be encrypted
     * @return ciphertext string
     */
    public String affineEncrypt(String plaintext) {
        String cipher = "";
        for(int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            char x = (char) (c - 'A');
            cipher = cipher + (char) ((((a * x) + b) % 26) + 'A');
        }
        return cipher;
    }

    /**
     *
     * @param ciphertext the cipher to be decrypted
     * @return plaintext string
     */
    public String affineDecrypt(String ciphertext) {
        String plain = "";
        int inverse = 0;

        for(int i = 0; i < 26; i++) {
            if((a * i) % 26 == 1) {
                inverse = i;
            }
        }

        for(int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char x = (char) ((c + 'A' - b));
            plain = plain + (char) (((inverse * x % 26)) + 'A');
        }
        return plain;
    }

}
