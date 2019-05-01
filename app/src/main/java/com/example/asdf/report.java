package com.example.asdf;

import java.io.Serializable;
import java.util.ArrayList;

public class report implements Serializable {
    private String type;
    private int customerTc,reportId,price;
    private ArrayList<news> News = new ArrayList<news>();

    public report(String type, int customerTc, int reportId, int price, ArrayList<news> news) {
        this.type = type;
        this.customerTc = customerTc;
        this.reportId = reportId;
        this.price = price;
        News = news;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCustomerTc() {
        return customerTc;
    }

    public void setCustomerTc(int customerTc) {
        this.customerTc = customerTc;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<news> getNews() {
        return News;
    }

    public void setNews(ArrayList<news> news) {
        News = news;
    }
}
