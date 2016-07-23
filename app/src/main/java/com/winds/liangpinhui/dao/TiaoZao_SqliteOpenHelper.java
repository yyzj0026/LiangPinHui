package com.winds.liangpinhui.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/24.
 */
public class TiaoZao_SqliteOpenHelper extends SQLiteOpenHelper{
    public TiaoZao_SqliteOpenHelper(Context context) {
        super(context, "TiaoZao.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists banner(alias varchar(30) primary key," +  //banner表
                "image varchar(100)," +
                "bannerUrl varchar(100))");
        sqLiteDatabase.execSQL("create table if not exists dot(alias varchar(30) primary key," +     //dot表
                "dotUrl varchar(100)," +
                "image varchar(100)," +
                "title varchar(50))");
        sqLiteDatabase.execSQL("create table if not exists recommend(goods_id integer primary key," +  //recommend表
                "title varchar(50)," +
                "icon varchar(100)," +
                "price integer," +
                "recommendName varchar(100)," +
                "image varchar(100)," +
                "recommendUrl varchar(100))");
        sqLiteDatabase.execSQL("create table if not exists flashSale(goods_id integer primary key," +  //flashSale表
                "title varchar(50)," +
                "icon varchar(100)," +
                "subAction varchar(30)," +
                "image varchar(100)," +
                "begin varchar(100)," +
                "end varchar(100)," +
                "flashSaleUrl varchar(100))");
        sqLiteDatabase.execSQL("create table if not exists album(goods_id varchar(20) primary key," +  //album表
                "title varchar(50)," +
                "subTitle varchar(50)," +
                "tag varchar(30)," +
                "tag_bg varchar(100)," +
                "album_image varchar(100)," +
                "albumUrl varchar(100)," +
                "album_action_alias varchar(50)," +
                "price integer," +
                "name varchar(30)," +
                "image varchar(100)," +
                "itemUrl varchar(100))");
        sqLiteDatabase.execSQL("create table if not exists goods(id integer primary key," +  //闲置页的goods表
                "goods_name varchar(30)," +
                "brand_name varchar(30)," +
                "original_price varchar(20)," +
                "sell_price varchar(20)," +
                "cover varchar(100)," +
                "goodsUrl varchar(100)," +
                "is_onsale varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
