
import Mapper.Crawler;
import Model.dautruyen;
import MongoDB.Mongo;
import Ultil.VNCharacterUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        List<String> listruyen = new ArrayList<String>();
        listruyen.add("https://truyenfull.vn/luu-nguyet-han-tinh/");
        listruyen.add("https://truyenfull.vn/song-kiem/");
        listruyen.add("https://truyenfull.vn/gap-anh-la-su-bat-ngo-tuyet-voi-nhat/");
        listruyen.add("https://truyenfull.vn/cong-tu-lien-thanh/");
        listruyen.add("https://truyenfull.vn/dai-than-em-nuoi-anh/");
        listruyen.add("https://truyenfull.vn/lam-yeu-nu-gap-phai-dai-than/");
        listruyen.add("https://truyenfull.vn/thien-thuong-hong-phi/");
        listruyen.add("https://truyenfull.vn/tinh-co-anh-da-gap-phai-em/");
        listruyen.add("https://truyenfull.vn/boss-qua-gian-xao/");
        listruyen.add("https://truyenfull.vn/vo-sac-cung-khuynh-thanh/");
        listruyen.add("https://truyenfull.vn/anh-se-yeu-em-tu-cai-nhin-dau-tien/");
        listruyen.add("https://truyenfull.vn/tu-than-chi-tien/");
        listruyen.add("https://truyenfull.vn/boss-qua-gian-xao/");
        listruyen.add("https://truyenfull.vn/vo-han-khung-bo/");

        for (String tentruyen: listruyen
             ) {
            String url = tentruyen;
            Crawler crawler = new Crawler(url);


            dautruyen dt = crawler.getDautruyen();
            Mongo test = new Mongo();
            test.MongoStart(dt,url);
        }



//        String name = "Ta Thăng Cấp Trong Thời Đại Tu Tiên";
//        System.out.println(VNCharacterUtils.removeAccent(name));
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
