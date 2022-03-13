package Model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.bson.types.ObjectId;

/**
 *
 * @author Administrator
 */
public class Chap {
    private ObjectId _id;
    private ObjectId dautruyen_id;
    private String tenchap;
    private String content;
    private int chapnumber;

    public Chap(ObjectId idtruyen, String tenchap, String content, int chapnumber) {
        this.dautruyen_id = idtruyen;
        this.tenchap = tenchap;
        this.content = content;
        this.chapnumber = chapnumber;
    }

    public Chap() {
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId getDautruyenId() {
        return dautruyen_id;
    }

    public void setDautruyenId(ObjectId dautruyen_id) {
        this.dautruyen_id = dautruyen_id;
    }

    public String getTenchap() {
        return tenchap;
    }

    public void setTenchap(String tenchap) {
        this.tenchap = tenchap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getChapnumber() {
        return chapnumber;
    }

    public void setChapnumber(int chap_number) {
        this.chapnumber = chap_number;
    }
}
