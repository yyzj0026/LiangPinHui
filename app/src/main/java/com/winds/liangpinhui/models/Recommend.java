package com.winds.liangpinhui.models;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Recommend {
    private String title;
    private String icon;

    private String price;
    private String recommendName;
    private String image;
    private String recommendUrl;

    public Recommend(String title, String icon, String price, String recommendName, String image, String recommendUrl) {
        this.title = title;
        this.icon = icon;
        this.price = price;
        this.recommendName = recommendName;
        this.image = image;
        this.recommendUrl = recommendUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRecommendName() {
        return recommendName;
    }

    public void setRecommendName(String recommendName) {
        this.recommendName = recommendName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRecommendUrl() {
        return recommendUrl;
    }

    public void setRecommendUrl(String recommendUrl) {
        this.recommendUrl = recommendUrl;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", recommendName='" + recommendName + '\'' +
                ", image='" + image + '\'' +
                ", recommendUrl='" + recommendUrl + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
