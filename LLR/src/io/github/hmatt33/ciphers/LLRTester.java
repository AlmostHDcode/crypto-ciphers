package io.github.hmatt33.ciphers;

/**
 * tester class that tests the improved version of the ShiftCipher which now uses LLR
 * @author Matt Hunt
 * @version 1.0 (Oct 27, 2019)
 */
public class LLRTester {
    public static void main (String [] args) {
        ShiftCipherV2 shift = new ShiftCipherV2();
        String plain = "thisisacipherencrypttesthereistheletterz";
        int shiftKey = 5;
        String cipher = shift.shiftCipherEncrypt(plain, shiftKey);
        System.out.println("Plaintext: " + plain + ", Shifted: " + shiftKey + " Characters" + "\nCiphertext: " + cipher + "\n");

        cipher = "gyznkjgeycktzheznkkburazoutulroqkotzurubkcgygiikrkxgzkjcnozklgtmnosykrlhkmgtzumxucgcgxkulozznuamnotnoyiutyiouaytkyynkqtkctuzcngzrubkcgyozsgtolkyzkjozykrlzunosgygbuojotnoyhkotmgnatmxeginotmekgxtotmbuojzngzirgsuaxkjzuhklorrkjozcgygvgotgtjgtatxkyzgtjozxkikobkjkgyksktzutreheznkzuainulznktkcmujoyvxkyktikgzyainzoskyrubkcgypuezunosgcorjqkktznxorrotmygzoylgizouthazcnktgcgelxusnoymujznkvgotgtjznkatxkyzxkzaxtkjznkbuojotnosyvxgtmavgtjvxkyykjgmgotyznoscoznozyksvzotkyygtjznknatmkxmtgckjgtjmtgckjatikgyotmre";
        System.out.println("CipherText to Decrypt: " + cipher);
        int[] keys = shift.getPossibleKeys(cipher);
        String[] plains = shift.getPossiblePlains(cipher);
        for(int i = 0; i < plains.length; i++) {
            System.out.println("plaintext " + (i + 1) +  " with shift " + keys[i] + ", " + plains[i]);
        }
        //LLR method implemented as part of shift cipher decrypt method
        plain = shift.shiftCipherDecrypt(plains);
        System.out.println("\nDecrypted Plaintext found using LLR: " + plain);
    }
}
