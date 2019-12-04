/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author pallerma_sd2082
 */
public class WithoutConnection {

    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/db_sql_vs_nosql";
    final String USER = "root";
    final String PASS = "";

    public void insertNumbers() throws SQLException {

        int col1 = 0;
        int col2 = 0;
        int col3 = 0;
        int col4 = 0;
        int col5 = 0;

        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Start : " + timeStart);

        LocalTime timeFinish = null;
        Connection conn = null;
        Statement stmt = null;
        String insertQuery;
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();

        for (int i = 0; i < 1001; i++) {
            if (i == 1000) {
                timeFinish = LocalTime.now();
                System.out.println("Time Finish : " + timeFinish);
                conn.close();

            } else {
                col1++;
                col2++;
                col3++;
                col4++;
                col5++;
                insertQuery = String.format("INSERT INTO `tbl_sql` (col1,col2,col3,col4,col5)"
                        + "VALUES ('%d','%d','%d','%d','%d')", col1, col2 + 1, col3 + 2, col4 + 3, col5 + 4);
                try {
                    int result = stmt.executeUpdate(insertQuery);
                    System.out.println(result);
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
            Connection con = null;
            Statement stmt = null;
            String query;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql_vs_nosql", "root", "");
            stmt = con.createStatement();

            for (int i = 0; i < 1001; i++) {
                if (i == 1000) {
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

    public void getAverageWithoutConnection() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Start : " + timeStart);

        LocalTime timeFinish = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql_vs_nosql", "root", "");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT SUM(col1) FROM tbl_sql");
            while (rs.next()) {
                float avg = rs.getFloat(1)/1000;
                System.out.println("Column 1 Average : " + avg);
            }

            ResultSet rs2 = stmt.executeQuery("SELECT SUM(col2) FROM tbl_sql");
            while (rs2.next()) {
                float avg = rs2.getFloat(1)/1000;
                System.out.println("Column 2 Average : " + avg);
            }
            ResultSet rs3 = stmt.executeQuery("SELECT SUM(col3) FROM tbl_sql");
            while (rs3.next()) {
                float avg = rs3.getFloat(1)/1000;
                System.out.println("Column 3 Average : " + avg);
            }

            ResultSet rs4 = stmt.executeQuery("SELECT SUM(col4) FROM tbl_sql");
            while (rs4.next()) {
                float avg = rs4.getFloat(1)/1000;
                System.out.println("Column 4 Average : " + avg);
            }

            ResultSet rs5 = stmt.executeQuery("SELECT SUM(col5) FROM tbl_sql");
            while (rs5.next()) {
                float avg = rs5.getFloat(1)/1000;
                System.out.println("Column 5 Average : " + avg);
            }

            timeFinish = LocalTime.now();
            System.out.println("Time Finish : " + timeFinish);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        Long intervalTime = ChronoUnit.MILLIS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in millis : " + intervalTime);
    }
    
    public void getAverageWithInternalFunction() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Start : " + timeStart);

        LocalTime timeFinish = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_sql_vs_nosql", "root", "");
            stmt = con.createStatement();

            rs = stmt.executeQuery("SELECT AVG(col1) FROM tbl_sql");
            if (rs.next()) {
                System.out.println("Column 1 Average : " + rs.getFloat(1));
            }

            ResultSet rs2 = stmt.executeQuery("SELECT AVG(col2) FROM tbl_sql");
            if (rs2.next()) {
                System.out.println("Column 2 Average : " + rs2.getFloat(1));
            }
            ResultSet rs3 = stmt.executeQuery("SELECT AVG(col3) FROM tbl_sql");
            if (rs3.next()) {
                System.out.println("Column 3 Average : " + rs3.getFloat(1));
            }

            ResultSet rs4 = stmt.executeQuery("SELECT AVG(col4) FROM tbl_sql");
            if (rs4.next()) {
                System.out.println("Column 4 Average : " + rs4.getFloat(1));
            }

            ResultSet rs5 = stmt.executeQuery("SELECT AVG(col5) FROM tbl_sql");
            if (rs5.next()) {
                System.out.println("Column 5 Average : " + rs5.getFloat(1));
            }

            timeFinish = LocalTime.now();
            System.out.println("Time Finish : " + timeFinish);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        Long intervalTime = ChronoUnit.MILLIS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in millis : " + intervalTime);
    }
}
