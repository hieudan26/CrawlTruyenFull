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
    private int chap_number;

    public Chap(ObjectId idtruyen, String tenchap, String content, int chap_number) {
        this.dautruyen_id = idtruyen;
        this.tenchap = tenchap;
        this.content = content;
        this.chap_number = chap_number;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId getdautruyenId() {
        return dautruyen_id;
    }

    public void setdautruyenId(ObjectId dautruyen_id) {
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

    public int getChap_number() {
        return chap_number;
    }

    public void setChap_number(int chap_number) {
        this.chap_number = chap_number;
    }
}
