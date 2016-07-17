package com.winds.liangpinhui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.winds.liangpinhui.jsonUtils.JsonUtils;
import com.winds.liangpinhui.models.Banner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAsyncTask mat=new MyAsyncTask();
        mat.execute("http://uuyichu.com/api/home/data/v4");
    }
}
