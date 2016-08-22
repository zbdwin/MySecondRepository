package com.bwf.tuanche.homepage.Search;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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

/**
 * Created by wanli on 2016/8/21.
 * Description:
 */
public class Search_Details_ReclyView extends BaseActivity{

    //    private Search_Details_ReclyView_adapter search_details_reclyView_adapter;
    private RecyclerView Search_Details_ReclyView_layout;
    private String[] list;
    private List<String> listto = null;
    private List<RecyclerView> recyclerViewss = null;

    public RecyclerView getRecyclerViewss() {
        if(Search_Details_ReclyView_layout!=null)
        { return Search_Details_ReclyView_layout;}
       return null;
    }

    @Override
    public int getContentViewId() {
        return R.layout.search_details_reclyview_1;
    }

    @Override
    public void beforeInitView() {
//        list =new String[]{};
        listto = new ArrayList<String>();
    }

    @Override
    public void initView() {
        Search_Details_ReclyView_layout = findViewByIdNoCast(R.id.Search_Details_ReclyView_layout);
        GridLayoutManager manager = new GridLayoutManager(this,3);
        Search_Details_ReclyView_layout.setLayoutManager(manager);
        Search_Details_ReclyView_layout.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initData() {
        HttpHelper.getSearchhotServlet("156", new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {

                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
                if (baseBean != null) {

                    list = baseBean.result.replace("[", "").replace("]", "").split(",");
                    for (String c : list) {

                        listto.add(c.substring(1,c.length()-1));
                    }
                    Search_Details_ReclyView_adapter search_details_reclyView_adapter = new Search_Details_ReclyView_adapter(Search_Details_ReclyView.this, listto);
                    Search_Details_ReclyView_layout.setAdapter(search_details_reclyView_adapter);
                }
            }
        });

        recyclerViewss = new ArrayList<>();

        recyclerViewss.add(Search_Details_ReclyView_layout);
    }

    @Override
    public void onClick(View view) {

    }
}
