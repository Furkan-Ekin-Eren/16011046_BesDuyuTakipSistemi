package com.example.asdf;

import java.io.Serializable;
import java.util.ArrayList;

public class company implements Serializable {
    private String ad;
    private ArrayList<customer> Customers = new ArrayList<customer>();
    private ArrayList<media> Medias = new ArrayList<media>();

    public company(String ad, ArrayList<customer> customers, ArrayList<media> medias) {
        this.ad = ad;
        Customers = customers;
        Medias = medias;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public ArrayList<customer> getCustomers() {
        return Customers;
    }

    public void setCustomers(ArrayList<customer> customers) {
        Customers = customers;
    }

    public ArrayList<media> getMedias() {
        return Medias;
    }

    public void setMedias(ArrayList<media> medias) {
        Medias = medias;
    }
}
