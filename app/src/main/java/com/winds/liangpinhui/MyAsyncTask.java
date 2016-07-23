package com.winds.liangpinhui;

import android.os.AsyncTask;
import android.util.Log;

import com.winds.liangpinhui.dao.TiaoZao_Dao;
import com.winds.liangpinhui.jsonUtils.JsonUtils_FirstPage;
import com.winds.liangpinhui.models.Album;
import com.winds.liangpinhui.models.Banner;
import com.winds.liangpinhui.models.Dot;
import com.winds.liangpinhui.models.FlashSale;
import com.winds.liangpinhui.models.Recommend;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyAsyncTask extends AsyncTask<String,Void,JsonUtils_FirstPage>{
    private TiaoZao_Dao dao;

    public MyAsyncTask(TiaoZao_Dao dao) {
        this.dao = dao;
    }

    @Override
    protected JsonUtils_FirstPage doInBackground(String... strings) {
        byte[] b=HttpUtils.getWebCache(strings[0]);
        try {
            String jsonStr=new String(b,"utf-8");

            JsonUtils_FirstPage json=new JsonUtils_FirstPage();
            json.getJsonStr(jsonStr);

            List<Banner> banners=json.getBannerList();
            Log.i("banner","--------"+banners.size());

            List<Dot> dots=json.getDotList();
            Log.i("dot","--------"+dots.size());

            List<Recommend> recommends=json.getRecommendList();
            Log.i("recommend","--------"+recommends.size());

            List<FlashSale> flashSales=json.getFlashSaleList();
            Log.i("flashSale","--------"+flashSales.size());

            HashMap<String,List<Album>> map=json.getAlbum();
            Log.i("album","---------mapSize:"+map.size());

            for(int i=0;i<banners.size();i++){
                dao.insertBanner(banners.get(i));
            }
            for(int i=0;i<dots.size();i++){
                dao.insertDot(dots.get(i));
            }
            for(int i=0;i<recommends.size();i++){
                dao.insertRecommend(recommends.get(i));
            }
            for(int i=0;i<flashSales.size();i++){
                dao.insertFlashSale(flashSales.get(i));
            }

            for(String key:map.keySet()){
                List<Album> list=map.get(key);
                for(int i=0;i<list.size();i++){
                    dao.insertAlbum(list.get(i));
                }
            }
            return json;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(JsonUtils_FirstPage json) {
        super.onPostExecute(json);

    }
}
