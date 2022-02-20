
import Mapper.Crawler;
import Model.dautruyen;
import MongoDB.Mongo;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
//        Helper helper = new Helper();
        String url = "https://truyenfull.vn/ban-long/";
        Crawler crawler = new Crawler(url);


        dautruyen dt = crawler.getDautruyen();
        Mongo test = new Mongo();
        test.MongoStart(dt,url);
//
//        System.out.println(dt);
//        String url = "https://truyenfull.vn/anh-huong-dao-em-huong-anh/";
//        CrawlerOnepiece crawler = new CrawlerOnepiece(url);


        //System.out.println(crawler.crawlContent(url));
        //Mongo test = new Mongo();
       // test.MongoStart(crawler.crawlContent());
    }

    static void menu() {
        System.out.println("----- OnePiece -----");
        System.out.println("1. Get list Model.Chap.");
        System.out.println("2. Dowload chap");
        System.out.println("3. Exit");
    }

}
