package com.winds.liangpinhui.models;

/**
 * Created by Administrator on 2016/7/16.
 */
public class Banner {
    private String bannerUrl;
    private String image;

    public Banner(String bannerUrl, String image) {
        this.bannerUrl = bannerUrl;
        this.image = image;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public String getImage() {
        return image;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerUrl='" + bannerUrl + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
