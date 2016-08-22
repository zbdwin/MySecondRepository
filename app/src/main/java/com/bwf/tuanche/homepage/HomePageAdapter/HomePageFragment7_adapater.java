package com.bwf.tuanche.homepage.HomePageAdapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.entity.AdplistServlet_Root;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanli on 2016/8/20.
 * Description:
 */
public class HomePageFragment7_adapater extends RecyclerView.Adapter<HomePageFragment7_adapater.Viewhoder> {
    private Context context;
    private List<AdplistServlet_Root> carstyleList;


    public HomePageFragment7_adapater(Context context, List<AdplistServlet_Root> carstyleList) {
//        carstyleList =new ArrayList<AdplistServlet_Root>();
        this.context = context;
        this.carstyleList = carstyleList;
    }

    @Override
    public Viewhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adplist_item, null);
        Viewhoder viewhoder = new Viewhoder(view);
        viewhoder.adplistimg = (SimpleDraweeView) view.findViewById(R.id.adplistimg);
        viewhoder.adplistname = (TextView) view.findViewById(R.id.adplistname);
        viewhoder.adplistmoney = (TextView) view.findViewById(R.id.adplistmoney);
        viewhoder.adplistperson = (TextView) view.findViewById(R.id.adplistperson);

        return viewhoder;
    }

    @Override
    public void onBindViewHolder(Viewhoder holder, int position) {
        if (carstyleList!=null){
            AdplistServlet_Root adplistServlet_root=carstyleList.get(position);
            holder.adplistimg.setImageURI(Uri.parse(adplistServlet_root.logo));
            holder.adplistname.setText(adplistServlet_root.styleName);
            holder.adplistmoney.setText("指导价： "+adplistServlet_root.factoryPrice);
            holder.adplistperson.setText(adplistServlet_root.content);
        }
    }

    @Override
    public int getItemCount() {
        return carstyleList==null?0:carstyleList.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        SimpleDraweeView adplistimg;//图片
        TextView adplistname;// 名字
        TextView adplistmoney;//价格
        TextView adplistperson;//报名


        public Viewhoder(View itemView) {
            super(itemView);
        }
    }
}
