package com.winds.liangpinhui;


import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.text.ClipboardManager;
import android.util.Log;
import android.widget.TextView;

import com.winds.liangpinhui.jsonUtils.JsonUtils_GoodDetailPage;
import com.winds.liangpinhui.models.goodDetail_model.GoodDetail;


/**
 * Created by Administrator on 2016/7/22.
 */
public class MyAsyncTask2 extends AsyncTask<String,Void,GoodDetail> {
    private TextView tv_now_price,tv_before_price,tv_discount;

    public MyAsyncTask2(TextView tv_now_price, TextView tv_before_price, TextView tv_discount) {
        this.tv_now_price = tv_now_price;
        this.tv_before_price = tv_before_price;
        this.tv_discount = tv_discount;
    }

    @Override
    protected GoodDetail doInBackground(String... strings) {
//        byte[] b=HttpUtils.getWebCache(strings[0]);
//        try {
//            String str=new String(b,"utf-8");
//            JsonUtils_GoodDetailPage json=new JsonUtils_GoodDetailPage();
//            return json.getJsonStr(str);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        String str=MyOkhttp.getWebInfo(strings[0]);
        JsonUtils_GoodDetailPage json=new JsonUtils_GoodDetailPage();


        return json.getJsonStr(str);
    }

    @Override
    protected void onPostExecute(GoodDetail goodDetail) {
//        super.onPostExecute(goodDetail);

        Log.i("GoodDetail",goodDetail.toString());
        GoodDetailActivity.goodDetail=goodDetail;

        tv_before_price.setText("￥"+goodDetail.getOriginal_price());
        tv_before_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_now_price.setText("￥"+goodDetail.getSell_price());
        tv_discount.setText(goodDetail.getDiscount());

    }
}
