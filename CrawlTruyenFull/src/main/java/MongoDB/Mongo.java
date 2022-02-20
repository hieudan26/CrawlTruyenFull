package MongoDB;

import Model.Chap;
import Model.dautruyen;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.bson.types.ObjectId;
import Mapper.*;

import java.io.IOException;
import java.util.List;
public class Mongo {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static MongoCollection collection;
    public static MongoCollection collectionChap;
    public void MongoStart(dautruyen dt,String url){
//        mongoClient = new MongoClient("mongodb+srv://hieudan:01627798269Aa@cluster0.ygger.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
//        database = mongoClient.getDatabase("NovelDB");
        ConnectionString connectionString = new ConnectionString("mongodb+srv://hieudan:01627798269Aa@cluster0.ygger.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("NovelDB");
        collection = database.getCollection("NovelCollection");
        collectionChap = database.getCollection("ChapterCollection");
        Gson gson = new Gson();
        BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(dt));
        Document sample = new Document(obj);
        collection.insertOne(sample);


        BasicDBObject fields = new BasicDBObject("tentruyen", dt.getTentruyen());
        Document doc = (Document)collection.find(fields).first();

        ObjectId id = new ObjectId("6211e2ec90f2720ec0e0983f");
        try {
            Crawler crawler = new Crawler(id,url);
            List<Chap> list = crawler.GetListChap();
            for(Chap tempchap :list){
                obj = (BasicDBObject) JSON.parse(gson.toJson(tempchap));
                sample = new Document(obj);
                collectionChap.insertOne(sample);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
