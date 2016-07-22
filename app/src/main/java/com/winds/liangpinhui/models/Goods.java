package com.winds.liangpinhui.models;

/**
 * Created by Administrator on 2016/7/20.
 */
public class Goods {
    private String goods_name;   //商品名
    private String brand_name;   //品牌名
    private String original_price;  //原始价格
    private String sell_price;   //现售价格
    private String cover;    //图片封面
    private String goodsUrl;    //商品跳转页面地址

    public Goods(String goods_name, String brand_name, String original_price, String sell_price, String cover, String goodsUrl) {
        this.goods_name = goods_name;
        this.brand_name = brand_name;
        this.original_price = original_price;
        this.sell_price = sell_price;
        this.cover = cover;
        this.goodsUrl = goodsUrl;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
        this.original_price = original_price;
    }

    public String getSell_price() {
        return sell_price;
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_name='" + goods_name + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", original_price='" + original_price + '\'' +
                ", sell_price='" + sell_price + '\'' +
                ", cover='" + cover + '\'' +
                ", goodsUrl='" + goodsUrl + '\'' +
                '}';
    }
}
