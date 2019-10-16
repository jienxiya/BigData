/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pallerma_sd2082
 */
public class WordCount {

//    public String wordCount(String str) {
//
//        // split text to array of words
//        String[] words = str.split(" ");
//
//        // frequency array
//        int[] frequency = new int[words.length];
//
//        // init frequency array
//        for (int i = 0; i < frequency.length; i++) {
//            frequency[i] = 0;
//        }
//
//        // count words frequency
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (words[i].equals(words[j])) {
//                    frequency[i]++;
//                }
//            }
//        }
//
//        // clean duplicates
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (words[i].equals(words[j])) {
//                    if (i != j) {
//                        words[i] = "";
//                    }
//                }
//            }
//        }
//
//        // show the output
//        int total = 0;
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < words.length; i++) {
//            if (words[i] != "") {
//                list.add(words[i] + " = " + frequency[i] + "\n");
//                this.InsertData(words[i], frequency[i], "USC");
//            }
//            
//        }
//        return list.toString();
//        
//        
//    }
    
    public HashMap<String, Integer> wordCount(String words) {
//        Create insert = new Create();
        String[] list = words.trim().split("\\s+");
        HashSet<String> mySet = new HashSet<>(Arrays.asList(list));
        HashMap<String, Integer> countWords = new HashMap<>();
        for (String unique_string : mySet) {
            int counter = 0;
            for (String test_string : list) {
                if (unique_string.equals(test_string)) {
                    ++counter;
                }
            }
            countWords.put(unique_string, counter);
            this.InsertData(unique_string, counter, "Usc");
        }
        return countWords;
    }

    public void InsertData(String word, int count,String school){
        
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/dbwordcounter";
        final String USER = "root";
        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;
        String insertQuery; 

        insertQuery = String.format("INSERT INTO `tblcounter` (word,count,school) " + "VALUES ('%s','%d','%s')", word, count,school);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            int result = stmt.executeUpdate(insertQuery);
            System.out.println(result);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    
}
