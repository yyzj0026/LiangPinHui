package com.winds.liangpinhui.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.winds.liangpinhui.models.Album;
import com.winds.liangpinhui.models.Banner;
import com.winds.liangpinhui.models.Dot;
import com.winds.liangpinhui.models.FlashSale;
import com.winds.liangpinhui.models.Goods;
import com.winds.liangpinhui.models.Recommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
public class TiaoZao_Dao {
    private TiaoZao_SqliteOpenHelper helper;

    public TiaoZao_Dao(Context context){
        helper=new TiaoZao_SqliteOpenHelper(context);
    }

    public boolean insertBanner(Banner banner){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("alias",banner.getAlias());
            values.put("bannerUrl",banner.getBannerUrl());
            values.put("image",banner.getImage());

            long id=db.insert("banner",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public boolean insertDot(Dot dot){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("alias",dot.getAlias());
            values.put("dotUrl",dot.getDotUrl());
            values.put("image",dot.getImage());
            values.put("title",dot.getTitle());

            long id=db.insert("dot",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public boolean insertRecommend(Recommend recommend){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("goods_id",recommend.getGoods_id());
            values.put("title",recommend.getTitle());
            values.put("icon",recommend.getIcon());
            values.put("price",recommend.getPrice());
            values.put("recommendName",recommend.getRecommendName());
            values.put("image",recommend.getImage());
            values.put("recommendUrl",recommend.getRecommendUrl());

            long id=db.insert("recommend",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public boolean insertFlashSale(FlashSale flashSale){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("goods_id",flashSale.getGoods_id());
            values.put("title",flashSale.getTitle());
            values.put("icon",flashSale.getIcon());
            values.put("subAction",flashSale.getSubAction());
            values.put("image",flashSale.getImage());
            values.put("begin",flashSale.getBegin());
            values.put("end",flashSale.getEnd());
            values.put("flashSaleUrl",flashSale.getFlashSaleUrl());

            long id=db.insert("flashSale",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public boolean insertAlbum(Album album){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("goods_id",album.getGoods_id());
            values.put("title",album.getTitle());
            values.put("subTitle",album.getSubTitle());
            values.put("tag",album.getTag());
            values.put("tag_bg",album.getTag_bg());
            values.put("album_image",album.getAlbum_image());
            values.put("albumUrl",album.getAlbumUrl());
            values.put("album_action_alias",album.getAlbum_action_alias());
            values.put("price",album.getPrice());
            values.put("name",album.getName());
            values.put("image",album.getImage());
            values.put("itemUrl",album.getItemUrl());

            long id=db.insert("album",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public boolean insertGoods(Goods goods){
        SQLiteDatabase db=helper.getReadableDatabase();

        try {
            ContentValues values=new ContentValues();
            values.put("id",goods.getId());
            values.put("goods_name",goods.getGoods_name());
            values.put("brand_name",goods.getBrand_name());
            values.put("original_price",goods.getOriginal_price());
            values.put("sell_price",goods.getSell_price());
            values.put("cover",goods.getCover());
            values.put("goodsUrl",goods.getGoodsUrl());
            values.put("is_onsale",goods.getIs_onsale());

            long id=db.insert("goods",null,values);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

    public List<HashMap<String,Object>> getTiaoZao(String table, String[] selectColumn,String selection,String[] selectionArgs,String orderBy) {  //table 查询的表，
        SQLiteDatabase db = null;                                                                                                                 //selection 查询条件,不能给null
        Cursor cursor = null;                                                                                                                     //selectionArgs 查询条件的参数
        List<HashMap<String,Object>> data = new ArrayList<HashMap<String,Object>>();                                                              //orderBy  排序desc,降序;升序就给null即可,默认的
        try {

            db = helper.getReadableDatabase();
            cursor=db.query(table,selectColumn,selection,selectionArgs,null,null,orderBy);
            Log.i("database","正在查询");
            while (cursor.moveToNext()) {
                HashMap<String,Object> map=new HashMap<>();

                for(int i=0;i<selectColumn.length;i++){
                    String columnName=selectColumn[i];
                    String columnValue=cursor.getString(cursor.getColumnIndex(columnName));
                    map.put(columnName,columnValue);
                }
                data.add(map);
            }
            Log.i("database",data.toString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("aaa","query执行错误");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        }

        return data;
    }

    public boolean updateImg(String table,String imgPath,String selection,String[] selectArgs) {   //主要用来改变数据库中图片地址
        SQLiteDatabase db = null;                                                                  //更新条件:selection
        try {                                                                                      //更新条件参数:selectArgs
            db = helper.getReadableDatabase();                                                     //最新的本地图片地址:imgPath
            ContentValues values = new ContentValues();
            values.put("litpic",imgPath);

            int rowcount = db.update(table, values, selection, selectArgs);
            return rowcount > 0;
        } catch (Exception e) {
            Log.i("database","更新失败");
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }
    public boolean deleteAll(String table){
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            int rowcount = db.delete(table, null,null);
            Log.i("aaa", rowcount + "---------");
            return rowcount > 0;
        } catch (Exception e) {
            Log.i("aaa","delete删除失败");
        } finally {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return false;
    }

}
