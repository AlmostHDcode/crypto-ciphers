package io.github.hmatt33.ciphers;

/**
 * Shift Cipher Tester
 * @author Matt Hunt
 * @version 1.0 (Sept 23, 2019)
 */
public class ShiftCipherTester {
    /**
     * Tester main method
     * @param args
     */
    public static void main (String [] args) {
        ShiftCipher shift = new ShiftCipher();
        String plain = "thisisacipherencrypttesthereistheletterz";
        int shiftKey = 5;
        String cipher = shift.shiftCipherEncrypt(plain, shiftKey);
        System.out.println("Plaintext: " + plain + ", Shifted: " + shiftKey + " Characters" + "\nCiphertext: " + cipher + "\n");

        cipher = "xultpaajcxitltlxaarpjhtiwtgxktghidhipxciwtvgtpilpitghlxiwiwtxgqadds";
        int[] keys = shift.getPossibleKeys(cipher);
        String[] plains = shift.shiftCipherDecrypt(cipher);
        for(int i = 0; i < plains.length; i++) {
            System.out.println("plaintext " + (i + 1) +  " with shift " + keys[i] + ", " + plains[i]);
        }
    }
}