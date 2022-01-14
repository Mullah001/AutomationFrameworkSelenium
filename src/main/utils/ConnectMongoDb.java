package main.utils;


import com.mongodb.MongoClient;

public class ConnectMongoDb {

    MongoClient mongoClient = new MongoClient("192.168.2.26", 27017);

}
