package io.github.hmatt33.ciphers;

/**
 * Tests FrequencyAnalysis
 * @author Matt Hunt
 * @version 1.0 (Sept 19, 2019)
 */
public class FrequencyAnalysisTester {

    /**
     * main class that tests FrequencyAnalysis
     * @param args
     */
    public static void main (String[] args) {
        FrequencyAnalysis fa = new FrequencyAnalysis();
        System.out.print("Normal Frequency of letters: ");
        System.out.println(fa.getNormalFrequency());
        String str = "hellothisisatesttoseehowofteneachletterappears";
        System.out.println("Input string: " + str);
        System.out.println("Frequency Analysis of " + str + ":");
        System.out.println(fa.getFrequency(str));
    }
}
