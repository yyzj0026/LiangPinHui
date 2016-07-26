package com.winds.liangpinhui;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/26.
 */
public class MyOkhttp {
    public static String getWebInfo(String url){
        String content = null;
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();

            if (response.isSuccessful()) {   //返回码在200-300间（可为200，也就是网络访问的返回码为200）
                content = response.body().string();//response.body().还可以是返回InputStream，Reader,byte[]等
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content;
    }

}
