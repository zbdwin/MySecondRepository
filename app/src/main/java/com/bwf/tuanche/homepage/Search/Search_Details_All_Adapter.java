package com.bwf.tuanche.homepage.Search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanli on 2016/8/21.
 * Description:
 */
public class Search_Details_All_Adapter extends RecyclerView.Adapter<Search_Details_All_Adapter.ViewHolder1> {
    private Context context;
//    private String[] list;

    private List<String> listto1;
    private View view;

    public Search_Details_All_Adapter(Context context, List<String> listto) {
        this.context = context;
        listto1 = new ArrayList<>();
        if (listto != null) {


            for (int i = 0; i < 9; i++) {
                this.listto1.add(listto.get(i));

            }
        }

    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder1 viewholder = null;
        view = View.inflate(context, R.layout.search_viewpager_item, null);
        viewholder = new ViewHolder1(view);
        viewholder.search_Details_textview = (TextView) view.findViewById(R.id.search_Details_textview);
        return viewholder;


    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {


        holder.search_Details_textview.setText(listto1.get(position));
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
        return listto1 == null ? 0 : listto1.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        private TextView search_Details_textview;

        public ViewHolder1(View itemView) {
            super(itemView);
        }
    }
}
