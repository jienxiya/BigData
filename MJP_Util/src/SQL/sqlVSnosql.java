/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
*
* @author pallerma_sd2022
*/
public class sqlVSnosql {

   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   final String DB_URL = "jdbc:mysql://localhost/db_sql_vs_nosql";
   final String USER = "root";
   final String PASS = "";

   public void insertNumbers() {
       int col1 = 0;
       int col2 = 0;
       int col3 = 0;
       int col4 = 0;
       int col5 = 0;
       Date timeStart = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
       System.out.println("Time Started: " + dateFormat.format(timeStart));

       for (int i = 0; i < 1001; i++) {
           if (i == 1000) {
               Date timeFinish = new Date();
               SimpleDateFormat dateFormatFinish = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
               System.out.println("Time Finish: " + dateFormatFinish.format(timeFinish));
               
           } else {
               col1++;
               col2++;
               col3++;
               col4++;
               col5++;
               Connection conn = null;
               Statement stmt = null;
               String insertQuery;

               insertQuery = String.format("INSERT INTO `tbl_sql` (col1,col2,col3,col4,col5)"
                       + "VALUES ('%d','%d','%d','%d','%d')", col1, col2 + 1, col3 + 2, col4 + 3, col5 + 4);
               try {
                   conn = DriverManager.getConnection(DB_URL, USER, PASS);
                   stmt = conn.createStatement();
                   int result = stmt.executeUpdate(insertQuery);
                   System.out.println(result);
                   conn.close();
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, ex);
                   System.out.println(ex.getMessage());
               }

           }
       }

   }
   
   public void insertUsingNoSQL(){
       
   }

}