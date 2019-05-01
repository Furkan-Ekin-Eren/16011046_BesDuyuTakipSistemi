package com.example.asdf;

import java.io.Serializable;
import java.util.ArrayList;

public class media implements Serializable {
    private int medImage;
    private String ad,mediaId,eMail,telNo,type,medUri;
    private ArrayList<news> News = new ArrayList<news>();

    public media(){}

    public media(int medImage, String ad, String mediaId, String eMail, String telNo, String type, String medUri, ArrayList<news> news) {
        this.medImage = medImage;
        this.ad = ad;
        this.mediaId = mediaId;
        this.eMail = eMail;
        this.telNo = telNo;
        this.type = type;
        this.medUri = medUri;
        News = news;
    }

    public String getMedUri() {
        return medUri;
    }

    public void setMedUri(String medUri) {
        this.medUri = medUri;
    }

    public int getMedImage() {
        return medImage;
    }

    public void setMedImage(int medImage) {
        this.medImage = medImage;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<news> getNews() {
        return News;
    }

    public void setNews(ArrayList<news> news) {
        News = news;
    }
}
