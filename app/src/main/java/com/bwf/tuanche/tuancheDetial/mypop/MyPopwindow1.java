package com.bwf.tuanche.tuancheDetial.mypop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.bean.StyleList;
import com.bwf.framwork.utils.DisplayUtil;
import com.bwf.framwork.utils.ListViewUtils;
import com.bwf.tuanche.MyApplication;
import com.bwf.tuanche.R;
import com.bwf.tuanche.tuancheDetial.detialAdapter.DetialCarList;
import com.bwf.tuanche.tuancheDetial.myview.MyListView;

import java.util.List;

/**
 * 解释
 * Created by admin on 18/08/2016.
 */
public class MyPopwindow1 extends PopupWindow{
    private TextView tv_context1;
    private LinearLayout ll_list;
    private  int position;
    private List<StyleList> styleList;//列表数据
    private MyItemListviewCallBack callBack;//列表回调刷新数据

    public MyPopwindow1(Context context) {
        super(context);
    }

    public void setCallBack(MyItemListviewCallBack callBack) {
        this.callBack = callBack;
    }

    public MyPopwindow1(Context context, int postition) {
        super(context);
        this.position=postition;
        init(context);
    }

    public MyPopwindow1(Context context, int position, List<StyleList> styleList) {
        super(context);
        this.position = position;
        this.styleList = styleList;
        init(context);
    }

    public void init(Context context){
        if (position==0){
            View view=View.inflate(context, R.layout.detial_popwindow_jieshi,null);
            this.setContentView(view);
            //this.setHeight(DisplayUtil.getDensity_Height(context));
            this.setWidth(DisplayUtil.getDensity_Width(context)*2/3);
            this.setBackgroundDrawable(new BitmapDrawable());
            this.setOutsideTouchable(true);
            tv_context1= (TextView) view.findViewById(R.id.tv_context1);
            tv_context1.setText("1. 团长还在帮您砍价，还不确定底价\n" +
                    "2. 团购价格比较低，厂家不允许公开，公开后团购可能被取消，从而损害团友利益。");
        }
        if (position==1){
            View view=View.inflate(context,R.layout.detial_popwindow_list,null);
            this.setContentView(view);
            this.setHeight(DisplayUtil.getDensity_Height(context));
            this.setWidth(DisplayUtil.getDensity_Width(context));
            this.setBackgroundDrawable(new BitmapDrawable());
            this.setOutsideTouchable(true);
            ll_list= (LinearLayout) view.findViewById(R.id.ll_list);
            if (styleList!=null){
                Log.e("msg6",styleList.size()+"");
                for (int i=0;i<styleList.size();i++){
                    addView(ll_list,i);
                }
                }
            }

        }
    public void showPopWindow(View view,Context context) {
        if (!isShowing()) {
            this.showAsDropDown(view,DisplayUtil.getDensity_Width(context)/2,0);//显示在view的下方
            //this.showAtLocation(view, Gravity.BOTTOM, 30, 0);//可以显示在指定view的指定位置
        }
    }
    public void dismissPopWindow() {
        if (isShowing()) {
            this.dismiss();
        }
    }
    public void addView(LinearLayout ll_list,final int j){
        TextView textView =new TextView(MyApplication.getAppContext());
        textView.setPadding(5,5,5,5);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(18);
        textView.setText(styleList.get(j).brandName);
        ll_list.addView(textView);
        ListView listView=new ListView(MyApplication.getAppContext());
        LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        listView.setLayoutParams(params1);
        //listView.setDividerHeight(1);
        final DetialCarList carList=new DetialCarList(MyApplication.getAppContext());
        carList.settList(styleList.get(j).styleList);
        listView.setAdapter(carList);
        carList.notifyDataSetChanged();
        ListViewUtils.measureListViewHeight(listView);
        ll_list.addView(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (callBack!=null)
                callBack.onsuccess(styleList.get(j).styleList.get(i).logo,styleList.get(j).styleList.get(i).brandId,styleList.get(j).styleList.get(i).styleName);
                dismissPopWindow();
            }
        });

    }
    public interface MyItemListviewCallBack{
        void onsuccess(String logo,String brandId,String name);
    }
}
