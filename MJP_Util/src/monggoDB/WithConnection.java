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
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pallerma_sd2082
 */
public class WithConnection {

    public void insertNumbers() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Started: " + timeStart);

        LocalTime timeFinish = null;

        try {
            for (int i = 1; i < 201; i++) {
                if (i == 200) {
                    timeFinish = LocalTime.now();
                    System.out.println("Time Finish: " + timeFinish);
                } else {
                    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
                    mongoLogger.setLevel(Level.SEVERE);
                    MongoClient mongoClient = new MongoClient("localhost", 27017);
                    DB db = mongoClient.getDB("dbTesting");
                    DBCollection collection = db.getCollection("WithConnection");
                    BasicDBObject add200 = new BasicDBObject("col1", i)
                            .append("col2", i + 1)
                            .append("col3", i + 2)
                            .append("col4", i + 3)
                            .append("col5", i + 4);
                    collection.insert(add200);
                    System.out.println("Inserted!");
                }
            }
        } catch (SecurityException e) {
            System.out.println("Error is: " + e);
        }
        long timeInterval = ChronoUnit.SECONDS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in seconds : " + timeInterval);
    }

    public void delete() {
        LocalTime timeStart = LocalTime.now();
        System.out.println("Time Sarted: " + timeStart);

        LocalTime timeFinish = null;

        try {

            for (int i = 1; i < 1001; i++) {
                if (i == 1000) {
                    timeFinish = LocalTime.now();
                    System.out.println("Time Finish: " + timeFinish);
                } else {
                    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
                    mongoLogger.setLevel(Level.SEVERE);
                    MongoClient mongoClient = new MongoClient("localhost", 27017);
                    DB db = mongoClient.getDB("dbTesting");
                    DBCollection collection = db.getCollection("WithConnection");
                    
                    BasicDBObject remove1000 = new BasicDBObject("col1", i);
                    collection.remove(remove1000);
                    System.out.println("Suuccessfully deleted!");
                }
            }
        } catch (SecurityException e) {
            System.out.println("Error connecting to database!");
        }
        long timeInterval = ChronoUnit.SECONDS.between(timeStart, timeFinish);
        System.out.println("Diffrence between time in seconds : " + timeInterval);
    }
}
