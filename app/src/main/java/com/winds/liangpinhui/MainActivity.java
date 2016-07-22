package com.winds.liangpinhui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickButton(View view){
        switch (view.getId()){
            case R.id.first_btn:
                MyAsyncTask mat=new MyAsyncTask();
                mat.execute("http://uuyichu.com/api/home/data/v4");
                break;
            case R.id.second_btn:
                MyAsyncTask1 mat1=new MyAsyncTask1();
                mat1.execute("http://uuyichu.com/api/goods/list_v4/?cate=-1&brand=-1&condition=-1&sale=0&source=0&page=1");
                break;
            case R.id.goodDetail_btn:
                MyAsyncTask2 mat2=new MyAsyncTask2();
                mat2.execute("http://uuyichu.com/api/goods/detail_v4/34345");
        }
    }
}
