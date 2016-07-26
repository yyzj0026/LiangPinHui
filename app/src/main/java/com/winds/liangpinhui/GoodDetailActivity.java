package com.winds.liangpinhui;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winds.liangpinhui.models.goodDetail_model.GoodDetail;

public class GoodDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout ll;
    private FloatingActionButton btn_return, btn_share;
    private TextView tv_now_price,tv_before_price,tv_discount;

    private AlertDialog dialog;
    public static GoodDetail goodDetail;  //这点好像目前没用
    private AlertDialog.Builder builder;
    private ClipboardManager cmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_good_detail);

        ll = (LinearLayout) this.findViewById(R.id.gd_bottom_ll);
        btn_return= (FloatingActionButton) this.findViewById(R.id.gd_activity_return_btn);
        btn_share= (FloatingActionButton) this.findViewById(R.id.gd_activity_share_btn);
        tv_before_price= (TextView) this.findViewById(R.id.gd_bottom_before_price);
        tv_now_price= (TextView) this.findViewById(R.id.gd_bottom_now_price);
        tv_discount= (TextView) this.findViewById(R.id.gd_bottom_discount);

//        tv_before_price.setText("￥"+goodDetail.getOriginal_price());
//        tv_before_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//        tv_now_price.setText("￥"+goodDetail.getSell_price());
//        tv_discount.setText(goodDetail.getDiscount());

        ll.setOnClickListener(this);
        btn_share.setOnClickListener(this);
        btn_return.setOnClickListener(this);
        builder = new AlertDialog.Builder(this);

        cmb = (ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);  //已过时，但为了兼容低版本使用这个包下的

        MyAsyncTask2 mat2 = new MyAsyncTask2(tv_now_price,tv_before_price,tv_discount);
        mat2.execute("http://uuyichu.com/api/goods/detail_v4/34345");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.gd_bottom_ll:
                if(goodDetail!=null){
                    builder.setMessage("您的专属客服是："+goodDetail.getWx_kefu()+"。将她加为微信好友即可为您服务（微信号已复制，可直接粘贴使用）");
                }else {
                    builder.setMessage("请稍候...");
                }
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.i("aaa", "确定");
                    }
                });
                dialog = builder.create();
                dialog.show();
                cmb.setText(goodDetail.getWx_kefu());
                break;
            case R.id.gd_activity_return_btn:
                finish();
                break;
        }
    }
}
