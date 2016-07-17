package com.winds.liangpinhui.models;

/**
 * Created by Administrator on 2016/7/16.
 */
public class FlashSale {
    private String title;
    private String icon;

    private String subAction;
    private String image;
    private String begin;
    private String end;
    private String flashSaleUrl;

    public FlashSale(String title, String icon, String subAction, String image, String begin, String end, String flashSaleUrl) {
        this.title = title;
        this.icon = icon;
        this.subAction = subAction;
        this.image = image;
        this.begin = begin;
        this.end = end;
        this.flashSaleUrl = flashSaleUrl;
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

    public String getSubAction() {
        return subAction;
    }

    public void setSubAction(String subAction) {
        this.subAction = subAction;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getFlashSaleUrl() {
        return flashSaleUrl;
    }

    public void setFlashSaleUrl(String flashSaleUrl) {
        this.flashSaleUrl = flashSaleUrl;
    }

    @Override
    public String toString() {
        return "FlashSale{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", subAction='" + subAction + '\'' +
                ", image='" + image + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", flashSaleUrl='" + flashSaleUrl + '\'' +
                '}';
    }
}
