package io.github.hmatt33.ciphers;

/**
 * Main class that tests AffineCipher
 * @author Matt Hunt
 * @version 1.0 (Sept 23, 2019)
 */
public class AffineCipherTester {
    /**
     * main class that tests AffineCipher
     * @param args
     */
    public static void main (String[] args) {
        AffineCipher ac = new AffineCipher(5,7);

        String plain = "HOWAREYOU";
        String ciphertext = ac.affineEncrypt(plain);
        System.out.println("Encrypted CipherText: " + ciphertext);

        String plaintext = ac.affineDecrypt(ciphertext);
        System.out.println("Decrypted Plaintext: " + plaintext);
    }
}