package com.bwf.tuanche.homepage.Search;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.DrawableWrapper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by wanli on 2016/8/21.
 * Description:
 */
public class Search_Details_ReclyView_adapter extends RecyclerView.Adapter<Search_Details_ReclyView_adapter.Viewholder> {
    private Context context;

    private List<String> listto2;
    private View view;

    public Search_Details_ReclyView_adapter(Context context, List<String> listto) {
        this.context = context;
        listto2 = new ArrayList<>();
        if (listto != null) {
            if (listto.size() <= 9) {
                return;
            } else if (listto.size() > 9) {
                for (int i = 9; i < listto.size(); i++) {
                    this.listto2.add(listto.get(i));
                }
            }
        }
        listto2.add("全部车型");
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Viewholder viewholder = null;
        view = View.inflate(context, R.layout.search_viewpager_item, null);
        viewholder = new Viewholder(view);
        viewholder.search_Details_textview = (TextView) view.findViewById(R.id.search_Details_textview);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.search_Details_textview.setText(listto2.get(position));
        if (position == listto2.size() - 1) {
            holder.search_Details_textview.setTextColor(Color.parseColor("#FF0000"));
        }

        if ((position + 1) % 3 == 0) {
            DrawableUtils.drawableRight(context, (TextView) view.findViewById(R.id.search_Details_textview), R.color.withe);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showToast("点我干嘛！！！你又买不起");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listto2 == null ? 0 : listto2.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView search_Details_textview;

        public Viewholder(View itemView) {
            super(itemView);
        }
    }
}
