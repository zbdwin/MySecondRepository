package com.bwf.tuanche;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;

import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.IntentUtils;





import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.car_select.CarSelectActivity;
import com.bwf.tuanche.homepage.HomePage_FmentTitlebar01;
import com.bwf.tuanche.homepage.Home_service;
import com.bwf.tuanche.homepage.Home_service_My;
import com.bwf.tuanche.homepage.Search.Search_Details;
import com.bwf.tuanche.homepage.entity.Cheap_car_home_result;
import com.bwf.tuanche.homepage.version_Message.VersionCode;
import com.bwf.tuanche.homepage.version_Message.VersionCode_pop;


public class MainActivity extends BaseActivity implements Handler.Callback, View.OnClickListener {




    private HomePage_FmentTitlebar01 homePage_fmentTitlebar01;
    private Home_service homePage_fmentTitlebar02;
    private Home_service_My homePage_fmentTitlebar03;
    private Cheap_car_home_result cheap_car_home_result;
    private String cityId = "156";
    private boolean isBack = true;
    private Handler handler;
    private TextView Homepage1;
    private TextView Homepage2;
    private TextView Homepage3;
    private TextView Homepage4;
    private TextView search_Details;
    private ImageView icon_low_price01;
    private LinearLayout line1111111;
    private VersionCode_pop versionCode_pop;
    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        handler = new Handler(this);
        versionCode_pop=new VersionCode_pop(this);
    }
    @Override
    public void initView() {
        homePage_fmentTitlebar01 = (HomePage_FmentTitlebar01) getSupportFragmentManager().findFragmentById(R.id.homopagement01);
        homePage_fmentTitlebar02 = (Home_service) getSupportFragmentManager().findFragmentById(R.id.homopagement02);
        getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar02).commit();
        homePage_fmentTitlebar03 = (Home_service_My) getSupportFragmentManager().findFragmentById(R.id.homopagement03);
        getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar03).commit();
        Homepage1 = findViewByIdNoCast(R.id.Homepage1);
        Homepage2 = findViewByIdNoCast(R.id.Homepage2);
        Homepage3 = findViewByIdNoCast(R.id.Homepage3);
        Homepage4 = findViewByIdNoCast(R.id.Homepage4);
        search_Details  =findViewByIdNoCast(R.id.search_Details);
        icon_low_price01 =findViewByIdNoCast(R.id.icon_low_price01);
        line1111111 = findViewByIdNoCast(R.id.line1111111);
        Homepage1.setOnClickListener(this);
        Homepage2.setOnClickListener(this);
        Homepage3.setOnClickListener(this);
        Homepage4.setOnClickListener(this);
        line1111111.setOnClickListener(this);
        search_Details.setOnClickListener(this);
        icon_low_price01.setOnClickListener(this);
        handler.sendEmptyMessageDelayed(2, 1500);
//        versionCode_pop.show(search_Details);



    }

    @Override
    public void initData() {
        HttpHelper.getTopBrand(cityId, new HttpCallBack<Cheap_car_home_result>() {


            @Override
            public void onSuccess(Cheap_car_home_result result) {

            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Homepage1:
                line1111111.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().show(homePage_fmentTitlebar01).commit();
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar02).commit();
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar03).commit();

                DrawableUtils.drawableTop(MainActivity.this, Homepage1, R.mipmap.nav_icon_home_sel);
                DrawableUtils.drawableTop(MainActivity.this, Homepage2, R.mipmap.nav_icon_order_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage3, R.mipmap.nav_icon_server_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage4, R.mipmap.nav_icon_my_nor);
                Homepage2.setTextColor(Color.parseColor("#869D88"));
                Homepage3.setTextColor(Color.parseColor("#869D88"));
                Homepage4.setTextColor(Color.parseColor("#869D88"));
                Homepage1.setTextColor(Color.parseColor("#FF3837"));

                break;
            case R.id.Homepage2:

                //点击跳转
//                IntentUtils.openActivity(this, BlankPage.class);
                IntentUtils.openActivity(this, VersionCode.class);

                break;
            case R.id.icon_low_price01:
                //点击跳转
                IntentUtils.openActivity(MainActivity.this, CarSelectActivity.class);
                break;
            case R.id.search_Details:
                //点击搜索页面
                IntentUtils.openActivity(MainActivity.this, Search_Details.class);
                break;
            case R.id.Homepage3:
                //客服
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar01).commit();
                getSupportFragmentManager().beginTransaction().show(homePage_fmentTitlebar02).commit();
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar03).commit();

                line1111111.setVisibility(View.GONE);
                DrawableUtils.drawableTop(MainActivity.this, Homepage1, R.mipmap.nav_icon_home_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage2, R.mipmap.nav_icon_order_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage3, R.mipmap.nav_icon_server_sel);
                DrawableUtils.drawableTop(MainActivity.this, Homepage4, R.mipmap.nav_icon_my_nor);
//                DrawableUtils.drawableTop(MainActivity.this, Homepage1, R.mipmap.nav_icon_server_nor);
                Homepage3.setTextColor(Color.parseColor("#FF3837"));
                Homepage1.setTextColor(Color.parseColor("#869D88"));
                Homepage2.setTextColor(Color.parseColor("#869D88"));
                Homepage4.setTextColor(Color.parseColor("#869D88"));
                break;
            case R.id.Homepage4:
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar01).commit();
                getSupportFragmentManager().beginTransaction().hide(homePage_fmentTitlebar02).commit();
                getSupportFragmentManager().beginTransaction().show(homePage_fmentTitlebar03).commit();
                line1111111.setVisibility(View.GONE);
                DrawableUtils.drawableTop(MainActivity.this, Homepage1, R.mipmap.nav_icon_home_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage2, R.mipmap.nav_icon_order_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage3, R.mipmap.nav_icon_server_nor);
                DrawableUtils.drawableTop(MainActivity.this, Homepage4, R.mipmap.nav_icon_my_sel);
                Homepage3.setTextColor(Color.parseColor("#869D88"));
                Homepage1.setTextColor(Color.parseColor("#869D88"));
                Homepage2.setTextColor(Color.parseColor("#869D88"));
                Homepage4.setTextColor(Color.parseColor("#FF3837"));
//                DrawableUtils.drawableTop(MainActivity.this, Homepage1, R.mipmap.nav_icon_my_nor);
                break;


        }


    }
//点击底部图标更换界面


    /**
     * 按下监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {//按下返回键

            if (isBack) {
                ToastUtil.showToast("再次点击退出");
                isBack = false;
                handler.sendEmptyMessageDelayed(1, 1500);
            } else {
                //退出app
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean handleMessage(Message message) {

        switch (message.what) {
            case 1:
                isBack = true;
                break;
            case 2:
                //延迟验证版本信息
                versionCode_pop.show(line1111111, Gravity.CENTER,0,0);
                break;
        }

        return false;
    }
}
