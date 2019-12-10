/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monggoDB;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author pallerma_sd2082
 */
public class WithoutConnection {

    public void insertNumbers() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Started: " + timeStart);

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("dbTesting");
        DBCollection collection = db.getCollection("WithoutConnection");

        LocalTime timeFinish = null;

        try {
            for (int i = 1; i < 1001; i++) {
                if (i == 1000) {
                    timeFinish = LocalTime.now();
                    System.out.println("Time Finish: " + timeFinish);
                } else {
                    BasicDBObject add1000 = new BasicDBObject("col1", i)
                            .append("col2", i + 1)
                            .append("col3", i + 2)
                            .append("col4", i + 3)
                            .append("col5", i + 4);
                    collection.insert(add1000);
                    System.out.println("Inserted!");
                }
            }
        } catch (SecurityException e) {
            System.out.println("Error is: " + e);
        }
        long timeInterval = ChronoUnit.MILLIS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in milliseconds : " + timeInterval);
    }

    public void delete() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Sarted: " + timeStart);

        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("dbTesting");
        DBCollection collection = db.getCollection("WithoutConnection");

        LocalTime timeFinish = null;

        try {

            for (int i = 1; i < 1001; i++) {
                if (i == 1000) {
                    timeFinish = LocalTime.now();
                    System.out.println("Time Finish: " + timeFinish);
                } else {
                    BasicDBObject remove1000 = new BasicDBObject("col1", i);
                    collection.remove(remove1000);
                    System.out.println("Suuccessfully deleted!");
                }
            }
        } catch (SecurityException e) {
            System.out.println("Error connecting to database!");
        }
        long timeInterval = ChronoUnit.MILLIS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in milliseconds : " + timeInterval);
    }
}
