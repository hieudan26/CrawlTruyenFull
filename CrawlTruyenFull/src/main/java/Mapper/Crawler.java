package Mapper;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import Model.Chap;
import Model.dautruyen;
import org.bson.types.ObjectId;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Crawler {
    ArrayList<String> listChapurl = new ArrayList<>();
    ArrayList<Chap> listChap = new ArrayList<>();
    ObjectId idtruyen=null;
    String url="";
    int index = 1;
    public Crawler(ObjectId idtruyen, String url) {
        this.idtruyen = idtruyen;
        this.url = url;
    }
    public Crawler(String url) {
        this.url = url;
    }


    public List<Chap> GetListChap() throws IOException {
        List<Chap> chapList = new ArrayList<>();
        int sotrang = this.getSoTrang(url);

        for(int i = 1; i<= sotrang;i++){
            String urlpaging = url+"trang-"+i+"/#list-chapter";
            chapList.addAll(getAllChapPaging(urlpaging));
        }
        return chapList;
    }


    private List<Chap> getAllChapPaging(String urlpaging) throws IOException {
        Document document = Jsoup.connect(urlpaging).get();
        int sochap = document.select("ul.list-chapter li").size();
        List<Chap> templist = new ArrayList<>();
        for(int i = 0;i<sochap;i++)
        {
            String tenchap =document.select("ul.list-chapter li a").get(i).text();
            String content =crawlContent(document.select("ul.list-chapter li a").get(i).attr("href"));
            int chapter =index;
            index++;
            Chap tempChap = new Chap(idtruyen,tenchap,content,chapter);
            templist.add(tempChap);
        }

        return templist;
    }
    private void printListChap() {
        System.out.println("List Chaps : ");
        for (int i = 0; i < listChap.size(); i++) {
            System.out.println("Model.Chap : " + listChap.get(i).getChap_number());
            System.out.println("" + listChap.get(i).getContent());
            System.out.println("===================================================");
        }
    }
    public dautruyen getDautruyen() throws IOException {
        Document document = Jsoup.connect(url).get();
        String tentruyen = document.select("h3.title").text();
        String tacgia = document.select(".info a").get(0).text();
        String theloai;
        if(document.select(".info a").size() == 1){
            theloai = "None";

        }
        else{
            theloai = document.select(".info a").get(1).text();
        }

        String trangthai;
        if(document.select(".info span").size() == 1)
        {
             trangthai = document.select(".info span").get(0).text();
        }else{
             trangthai = document.select(".info span").get(1).text();
        }


        document.select("br").append("\\n");
        document.select("p").prepend("\\n\\n");
        String noidung = document.select(".desc-text").text().replaceAll("\\\\n", "\n");
        noidung = Jsoup.clean(noidung, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));

        String urlHinhAnh = document.select(".book img").attr("src");
        dautruyen dt = new dautruyen(tentruyen,tacgia,theloai,trangthai,"admin",urlHinhAnh,noidung);
        return dt;
    }
    // lấy tất cả chap 
    private int getSoTrang(String urls) throws IOException {
        Document document = Jsoup.connect(urls).get();
        List<String> temp = Arrays.stream(document.select(".pagination li:nth-last-child(1) a").attr("href").replaceAll("[^0-9]", " ").split(" ")).collect(Collectors.toList());

        if(temp.size() == 0)
            return 1;
        if(temp.get(temp.size()-1)=="")
            return 1;

        int soTrang = Integer.parseInt(temp.get(temp.size()-1));
        if(soTrang == 0){
            temp = Arrays.stream(document.select(".pagination li:nth-last-child(2) a").attr("href").replaceAll("[^0-9]", " ").split(" ")).collect(Collectors.toList());
            soTrang = Integer.parseInt(temp.get(temp.size()-1));
        }
        return soTrang;
    }

    public String crawlContent(String pageURL) throws IOException {

        Document document = Jsoup.connect(pageURL).get();
        document.select("br").append("\\n");
        document.select("p").prepend("\\n\\n");
        String content = document.select("div#chapter-c").text().replaceAll("\\\\n", "\n");
        content = Jsoup.clean(content, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
        return content;
    }


}
