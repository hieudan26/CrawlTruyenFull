package Model;

import Ultil.VNCharacterUtils;
import org.bson.types.ObjectId;

public class dautruyen {
    ObjectId _id;
    String tentruyen;
    String tacgia;
    String theloai;
    String nguoidangtruyen;
    String trangthai;
    String hinhanh;
    String noidung;
    String url;



    String status;
    double danhgia;
    int soluongdanhgia;
    int luotdoc;

    public dautruyen(String tentruyen, String tacgia, String theloai, String trangthai, String nguoidangtruyen, String hinhanh,String noidung,String url) {
        this.tentruyen = tentruyen;
        this.tacgia = tacgia;
        this.theloai = theloai;
        this.nguoidangtruyen = nguoidangtruyen;
        this.trangthai = trangthai;
        this.hinhanh = hinhanh;
        this.noidung = noidung;
        this.soluongdanhgia = 0;
        this.danhgia = 0;
        this.luotdoc = 0;
        this.status = "public";
        this.url =url;
    }

    public dautruyen() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public double getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(double danhgia) {
        this.danhgia = danhgia;
    }

    public int getSoluongdanhgia() {
        return soluongdanhgia;
    }

    public void setSoluongdanhgia(int soluongdanhgia) {
        this.soluongdanhgia = soluongdanhgia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getNguoidangtruyen() {
        return nguoidangtruyen;
    }

    public void setNguoidangtruyen(String nguoidangtruyen) {
        this.nguoidangtruyen = nguoidangtruyen;
    }

    public int getLuotdoc() {
        return luotdoc;
    }

    public void setLuotdoc(int luotdoc) {
        this.luotdoc = luotdoc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
