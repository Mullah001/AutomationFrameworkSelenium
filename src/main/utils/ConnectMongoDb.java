package main.utils;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class ConnectMongoDb {

    public static MongoClient mongoClient;
    public static DB db;
    public static DBCollection dbCollection;

    @SuppressWarnings("deprecation")
    public void Connect_MongoDb(){
        mongoClient = new MongoClient("192.168.2.26", 27017);
        db = mongoClient.getDB("MongoDBTest");
    }

    //MongoClient mongoClient = new MongoClient("192.168.2.26", 27017);

}
