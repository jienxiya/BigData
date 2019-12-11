/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SQL;

import java.sql.SQLException;

/**
 *
 * @author pallerma_sd2082
 */
public class Main {
    public static void main(String args[]) throws SQLException{
        WithConnection sql = new WithConnection();
        
//        sql.insertNumbers();
//        sql.delete();
        
        WithoutConnection walayKoneksyon = new WithoutConnection();
//        walayKoneksyon.insertNumbers();
//        walayKoneksyon.delete();
//        walayKoneksyon.getAverageWithoutConnection();
        walayKoneksyon.getAverageWithInternalFunction();
    }
    
}
