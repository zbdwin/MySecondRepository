package com.bwf.tuanche.homepage.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class Search_Details_All extends BaseActivity {
    private RecyclerView Search_Details_ReclyView_layout1;
    private String[] list;
    private List<String> listto = null;
    private List<RecyclerView> recyclerViews = null;



    @Override
    public int getContentViewId() {
        return R.layout.activity_search__details__all;
    }

    @Override
    public void beforeInitView() {
        listto = new ArrayList<String>();
    }

    @Override
    public void initView() {
        Search_Details_ReclyView_layout1 = findViewByIdNoCast(R.id.Search_Details_ReclyView_layout1);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        Search_Details_ReclyView_layout1.setLayoutManager(manager);
        Search_Details_ReclyView_layout1.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initData() {

    }
    private void getData(){

    }
    public RecyclerView getRecyclerViews() {
        getData();
        recyclerViews = new ArrayList<>();
        recyclerViews.add(Search_Details_ReclyView_layout1);
        return Search_Details_ReclyView_layout1;
    }
    @Override
    public void onClick(View view) {

    }
}
