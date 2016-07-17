package com.winds.liangpinhui.models;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Dot {
    private String dotUrl;
    private String image;
    private String title;

    public Dot(String dotUrl, String image, String title) {
        this.dotUrl = dotUrl;
        this.image = image;
        this.title = title;
    }

    public String getDotUrl() {
        return dotUrl;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setDotUrl(String dotUrl) {
        this.dotUrl = dotUrl;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "dotUrl='" + dotUrl + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
