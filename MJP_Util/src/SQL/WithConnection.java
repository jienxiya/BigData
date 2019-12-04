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
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2022
 */
public class WithConnection {

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
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Start : " + timeStart);

        LocalTime timeFinish = null;
        for (int i = 0; i < 201; i++) {

            if (i == 200) {
                timeFinish = LocalTime.now();
                System.out.println("Time Finish : " + timeFinish);

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
        Long intervalTime = ChronoUnit.SECONDS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in seconds : " + intervalTime);
    }

    public void delete() {

        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Start : " + timeStart);

        LocalTime timeFinish = null;
        try {
            for (int i = 0; i < 201; i++) {
                Connection con = null;
                Statement stmt = null;
                String query;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql_vs_nosql", "root", "");
                stmt = con.createStatement();
                if (i == 200) {
                    timeFinish = LocalTime.now();
                    System.out.println("Time Finish : " + timeFinish);
                    con.close();
                } else {
                    query = String.format("DELETE FROM tbl_sql WHERE id = '%d'", i);
                    int result = stmt.executeUpdate(query);
                    System.out.println(result);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Long intervalTime = ChronoUnit.SECONDS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in seconds : " + intervalTime);
    }

}
