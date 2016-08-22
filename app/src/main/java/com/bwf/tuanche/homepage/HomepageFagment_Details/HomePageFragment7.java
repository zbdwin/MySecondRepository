package com.bwf.tuanche.homepage.HomepageFagment_Details;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpCallBackArray;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.HomePageAdapter.HomePageFragment7_adapater;
import com.bwf.tuanche.homepage.entity.AdplistServlet_Result;
import com.bwf.tuanche.homepage.entity.AdplistServlet_Result_root;
import com.bwf.tuanche.homepage.entity.AdplistServlet_Root;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment7 extends BaseActivity {
    private SimpleDraweeView adplisthomepageimg;
    private RecyclerView adplisthomepagerec;
    private HomePageFragment7_adapater homePageFragment7_adapater;
    public List<AdplistServlet_Root> carstyleList;
    private ImageView adplistback;

    @Override
    public int getContentViewId() {
        return R.layout.activity_home_page_fragment7;
    }

    @Override
    public void beforeInitView() {
        carstyleList = new ArrayList<AdplistServlet_Root>();
    }

    @Override
    public void initView() {
        adplisthomepageimg = findViewByIdNoCast(R.id.adplisthomepageimg);
        adplisthomepagerec = findViewByIdNoCast(R.id.adplisthomepagerec);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        adplisthomepagerec.setLayoutManager(manager);
        adplisthomepagerec.setItemAnimator(new DefaultItemAnimator());
        findViewByIdNoCast(R.id.adplistback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomePageFragment7.this.finish();
            }
        });
    }

    @Override
    public void initData() {
        HttpHelper.getAdplistServlet(new HttpCallBack<AdplistServlet_Result>() {
            @Override
            public void onSuccess(AdplistServlet_Result result) {
                LogUtils.e("tttt", result.toString());
                if (result != null) {
                    homePageFragment7_adapater = new HomePageFragment7_adapater(HomePageFragment7.this, result.carstyleList);
                    adplisthomepageimg.setImageURI(result.adpLogo);
                    adplisthomepagerec.setAdapter(homePageFragment7_adapater);
                }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
