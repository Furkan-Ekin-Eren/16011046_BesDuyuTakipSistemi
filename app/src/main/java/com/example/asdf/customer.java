package com.example.asdf;

import android.net.Uri;

import java.io.Serializable;
import java.util.ArrayList;

public class customer implements Serializable {
    private String ad,soyAd,telNo,eMail,tc,cusUri;
    private int cusImage;
    private ArrayList<report> Reports = new ArrayList<report>();

    public customer(){}

    public customer(String ad, String soyAd, String telNo, String eMail, String tc, String cusUri, int cusImage, ArrayList<report> reports) {
        this.ad = ad;
        this.soyAd = soyAd;
        this.telNo = telNo;
        this.eMail = eMail;
        this.tc = tc;
        this.cusUri = cusUri;
        this.cusImage = cusImage;
        Reports = reports;
    }

    public String getCusUri() {
        return cusUri;
    }

    public void setCusUri(String cusUri) {
        this.cusUri = cusUri;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public int getCusImage() {
        return cusImage;
    }

    public void setCusImage(int cusImage) {
        this.cusImage = cusImage;
    }

    public ArrayList<report> getReports() {
        return Reports;
    }

    public void setReports(ArrayList<report> reports) {
        Reports = reports;
    }
}
