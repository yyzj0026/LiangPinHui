package com.winds.liangpinhui;

import android.os.AsyncTask;
import android.util.Log;

import com.winds.liangpinhui.jsonUtils.JsonUtils_GoodDetailPage;
import com.winds.liangpinhui.models.goodDetail_model.GoodDetail;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MyAsyncTask2 extends AsyncTask<String,Void,GoodDetail> {
    @Override
    protected GoodDetail doInBackground(String... strings) {
        byte[] b=HttpUtils.getWebCache(strings[0]);
        try {
            String str=new String(b,"utf-8");
            JsonUtils_GoodDetailPage json=new JsonUtils_GoodDetailPage();
            return json.getJsonStr(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(GoodDetail goodDetail) {
//        super.onPostExecute(goodDetail);

        Log.i("GoodDetail",goodDetail.toString());
    }
}
