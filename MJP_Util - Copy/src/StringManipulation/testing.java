/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.Scanner;

/**
 *
 * @author pallerma_sd2082
 */
public class testing {

    public static void main(String args[]) {
        WordCount w = new WordCount();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
//        String word = "University";
        System.out.println(w.wordCount(str));

    }
}
//University Of San Carlos