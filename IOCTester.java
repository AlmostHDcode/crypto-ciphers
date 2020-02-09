/**
 *
 */
package io.github.hmatt33.coincidence;

import java.text.DecimalFormat;
import io.github.hmatt33.ciphers.AffineCipher;

/**
 * @author Matt Hunt
 * @version 1.0
 * Oct 10, 2019
 */
public class IOCTester {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DecimalFormat formatter = new DecimalFormat("#0.000");
        IOC index = new IOC();
        String plain = "Alexander the Great was a successful ruler because his actions created long lasting effects on cultures that continue to the present day. One example of his legacy was the creation of a Hellenistic society. Hellenism was the combination of Greek, Persian, and Egyptian cultures. During this remarkable time period, people were encouraged to pursue a formal education and produce many different kinds of art. New forms of math, science, and design made a great impact on society.";
        plain = plain.replaceAll("[^A-Za-z]+", "").toUpperCase();

        AffineCipher ac = new AffineCipher(7, 13);
        String cipher = ac.affineEncrypt(plain);
        System.out.println("Plaintext: " + plain + "\nCipherText: " + cipher);

        double iocPlain = index.CalcIOC(plain);
        double iocCipher = index.CalcIOC(cipher);
        System.out.println("I.O.C of plaintext: " + formatter.format(iocPlain));
        System.out.println("I.O.C of Ciphertext: " + formatter.format(iocCipher));

        if(formatter.format(iocPlain).equals(formatter.format(iocCipher))) {
            System.out.println("I.O.C is the same for both the plaintext and ciphertext");
        } else {
            System.out.println("I.O.C is different for plaintext and ciphertext");
        }
    }

}
