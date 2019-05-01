package com.example.asdf;

import java.io.Serializable;
import java.util.Date;

public class news implements Serializable {
    private String content;
    private Date releaseDay;
    private int customerTc,mediaId,newsId;

    public news(String content, Date releaseDay, int customerTc, int mediaId, int newsId) {
        this.content = content;
        this.releaseDay = releaseDay;
        this.customerTc = customerTc;
        this.mediaId = mediaId;
        this.newsId = newsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(Date releaseDay) {
        this.releaseDay = releaseDay;
    }

    public int getCustomerTc() {
        return customerTc;
    }

    public void setCustomerTc(int customerTc) {
        this.customerTc = customerTc;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }
}
