/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.ArrayList;

/**
 *
 * @author pallerma_sd2082
 */
public class WordCount {

    public String wordCount(String str) {

        // split text to array of words
        String[] words = str.split(" ");

        // frequency array
        int[] frequency = new int[words.length];

        // init frequency array
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = 0;
        }

        // count words frequency
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    frequency[i]++;
                }
            }
        }

        // clean duplicates
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    if (i != j) {
                        words[i] = "";
                    }
                }
            }
        }

        // show the output
        int total = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i] != "") {
                list.add(words[i] + " = " + frequency[i] + "\n");
            }
        }
        return list.toString();
    }

}
