package com.bwf.tuanche.homepage.Search;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by wanli on 2016/8/20.
 * Description:搜索页面里面的热门搜索
 */
public class Search_Details extends BaseActivity {
    private Search_Details_All details_all;
    private Search_Details_ReclyView reclyView;
    private ViewPager search_Details_viewpager;
    private Search_Details_ViewPaget_Adapater paget_adapater;
    private List<RecyclerView> recyclerViews;
    private String[] list;
    private List<String> listto = null;
    private EditText Search_Detailsedittext;

    @Override
    public int getContentViewId() {
        return R.layout.search_setails;
    }

    @Override
    public void beforeInitView() {
    }

    @Override
    public void initView() {
        search_Details_viewpager = findViewByIdNoCast(R.id.search_Details_viewpager);
        Search_Detailsedittext = findViewByIdNoCast(R.id.Search_Detailsedittext);
        Search_Detailsedittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ToastUtil.showToast(Search_Detailsedittext.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void initData() {
        details_all = new Search_Details_All();
        reclyView = new Search_Details_ReclyView();
        recyclerViews = new ArrayList<>();
        final RecyclerView recyclerView = new RecyclerView(this);
        final RecyclerView recyclerView1 = new RecyclerView(this);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        GridLayoutManager manager1 = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView1.setLayoutManager(manager1);
        HttpHelper.getSearchhotServlet("156", new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                BaseBean baseBean = JSON.parseObject(response, BaseBean.class);
                if (baseBean != null) {
                    listto = new ArrayList<>();
                    list = baseBean.result.replace("[", "").replace("]", "").split(",");
                    for (String c : list) {
                        listto.add(c.substring(1, c.length() - 1));
                    }
                    //no2Search_Details_All_Adapter
                    Search_Details_All_Adapter search_details_all_adapter = new Search_Details_All_Adapter(Search_Details.this, listto);
                    recyclerView.setAdapter(search_details_all_adapter);
                    //no1
                    Search_Details_ReclyView_adapter search_details_reclyView_adapter = new Search_Details_ReclyView_adapter(Search_Details.this, listto);
                    recyclerView1.setAdapter(search_details_reclyView_adapter);
                }
            }
        });
        recyclerViews.add(recyclerView);
        recyclerViews.add(recyclerView1);
        paget_adapater = new Search_Details_ViewPaget_Adapater(recyclerViews, this);
        search_Details_viewpager.setAdapter(paget_adapater);
        paget_adapater.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {

    }
}
