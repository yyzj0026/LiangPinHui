package com.winds.liangpinhui;

import android.os.AsyncTask;
import android.util.Log;

import com.winds.liangpinhui.dao.TiaoZao_Dao;
import com.winds.liangpinhui.jsonUtils.JsonUtils_FirstPage;
import com.winds.liangpinhui.jsonUtils.JsonUtils_SecondPage;
import com.winds.liangpinhui.models.Goods;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public class MyAsyncTask1 extends AsyncTask<String,Void,List<Goods>>{
    private TiaoZao_Dao dao;

    public MyAsyncTask1(TiaoZao_Dao dao) {
        this.dao = dao;
    }

    @Override
    protected List<Goods> doInBackground(String... strings) {
        byte[] b=HttpUtils.getWebCache(strings[0]);
        try {
            String jsonStr=new String(b,"utf-8");

            JsonUtils_SecondPage json=new JsonUtils_SecondPage();
            List<Goods> list=json.getJsonStr(jsonStr);

            for(int i=0;i<list.size();i++){
                dao.insertGoods(list.get(i));
            }

            return list;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Goods> goodses) {
        super.onPostExecute(goodses);

        Log.i("goods","--------"+goodses.size());

    }
}
