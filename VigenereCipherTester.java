package io.github.hmatt33.ciphers;

/**
 * Tester class that implements the VigenereCipher
 */
public class VigenereCipherTester {

    /**
     * Tester method for VigenereCipher
     * @param args
     */
    public static void main (String [] args) {
        VigenereCipher vc = new VigenereCipher();
        String plain = "HELLENISM WAS THE COMBINATION OF GREEK, PERSIAN, AND EGYPTIAN CULTURES. DURING THIS REMARKABLE TIME PERIOD, PEOPLE WERE ENCOURAGED TO PURSUE A FORMAL EDUCATION AND PRODUCE MANY DIFFERENT KINDS OF ART. NEW FORMS OF MATH, SCIENCE, AND DESIGN MADE A GREAT IMPACT ON SOCIETY";
        System.out.println("Original Plaintext: " + plain + "\n");

        String keyword = "FIRSTKEY";
        String key = vc.createKey(plain, keyword);
        System.out.println("Created key using keyword " + keyword + ": " + key);
        String cipher = vc.vigenereEncrypt(plain, key);
        System.out.println("Encrypted Ciphertext: " + cipher);
        plain = vc.vigenereDecrypt(cipher, key);
        System.out.println("Decrypted Plaintext: " + plain + "\n");

        String keyword2 = "SECONDKEY";
        String key2 = vc.createKey(plain, keyword2);
        System.out.println("Created key using keyword " + keyword2 + ": " + key2);
        String cipher2 = vc.vigenereEncrypt(plain, key2);
        System.out.println("Encrypted Ciphertext: " + cipher2);
        plain = vc.vigenereDecrypt(cipher2, key2);
        System.out.println("Decrypted Plaintext: " + plain);
    }
}
