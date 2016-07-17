package com.winds.liangpinhui;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/16.
 */
public class HttpUtils {
    public static byte[] getWebCache(String urlPath){
        try {
            URL url=new URL(urlPath);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);

            connection.connect();
            if(connection.getResponseCode()==200){
                InputStream is=connection.getInputStream();
                ByteArrayOutputStream baos=new ByteArrayOutputStream();
                byte[] b=new byte[1024*5];
                int len=0;

                while((len=is.read(b,0,b.length))!=-1){
                    baos.write(b,0,len);
                    baos.flush();
                }

                if(is!=null){
                    is.close();
                }
                return baos.toByteArray();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
