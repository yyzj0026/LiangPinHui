package com.winds.liangpinhui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.winds.liangpinhui.dao.TiaoZao_Dao;

public class MainActivity extends AppCompatActivity {
    private TiaoZao_Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao=new TiaoZao_Dao(this);
    }

    public void clickButton(View view){
        switch (view.getId()){
            case R.id.first_btn:
                MyAsyncTask mat=new MyAsyncTask(dao);
                mat.execute("http://uuyichu.com/api/home/data/v4");
                break;
            case R.id.second_btn:
                MyAsyncTask1 mat1=new MyAsyncTask1(dao);
                mat1.execute("http://uuyichu.com/api/goods/list_v4/?cate=-1&brand=-1&condition=-1&sale=0&source=0&page=1");
                break;
            case R.id.goodDetail_btn:
//                MyAsyncTask2 mat2=new MyAsyncTask2();
//                mat2.execute("http://uuyichu.com/api/goods/detail_v4/34345");
                break;
            case R.id.find_btn:
                new Thread(){
                    public void run(){
                        String[] select={"goods_id"};
                        dao.getTiaoZao("recommend",select,null,null,null);
                    }
                }.start();
                break;
            case R.id.goodDetail_activity_btn:
                Intent intent=new Intent(this,GoodDetailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
