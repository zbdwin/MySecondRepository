package com.bwf.tuanche.homepage.Search;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanli on 2016/8/20.
 * Description:
 */
public class Search_Details_ViewPaget_Adapater extends PagerAdapter {
    private List<RecyclerView> recyclerViews;

    private Context context;

    public Search_Details_ViewPaget_Adapater(List<RecyclerView> recyclerViews, Context context) {
        this.recyclerViews = recyclerViews;
        this.context = context;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(recyclerViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(recyclerViews.get(position));
        return recyclerViews.get(position);
    }

    @Override
    public int getCount() {
        return recyclerViews==null?0:recyclerViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
