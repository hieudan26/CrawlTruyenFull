package MongoDB;

import Model.Chap;
import Model.dautruyen;
import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.util.JSON;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import Mapper.*;

import java.io.IOException;
import java.util.List;
public class Mongo {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    public static  MongoCollection<dautruyen> collection;
    public static MongoCollection<Chap> collectionChap;
    public void MongoStart(dautruyen dt,String url){
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        ConnectionString connectionString = new ConnectionString("mongodb+srv://hieudan:01627798269Aa@cluster0.ygger.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("NovelDB");
        collection = database.getCollection("NovelCollection",dautruyen.class);
        collectionChap = database.getCollection("ChapterCollection",Chap.class);

        collection.insertOne(dt);

        dautruyen doc = collection.find(Filters.eq("tentruyen", dt.getTentruyen())).first();
        ObjectId id = doc.getId();
        try {
            Crawler crawler = new Crawler(id,url);
            List<Chap> list = crawler.GetListChap();
            for(Chap tempchap :list){
                collectionChap.insertOne(tempchap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}