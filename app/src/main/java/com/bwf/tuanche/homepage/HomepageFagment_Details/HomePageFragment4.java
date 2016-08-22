package com.bwf.tuanche.homepage.HomepageFagment_Details;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.Home_margin;
import com.bwf.tuanche.homepage.entity.Banner.BannerResultBean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 婚姻座驾
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment4 extends BaseFragment {
    private SimpleDraweeView homePageFragment4_01;
    private SimpleDraweeView homePageFragment4_02;
    private SimpleDraweeView homePageFragment4_03;
    private SimpleDraweeView homePageFragment4_04;
    private SimpleDraweeView homePageFragment4_05;
    private SimpleDraweeView homePageFragment4_06;
    private SimpleDraweeView homePageFragment4_07;
    private SimpleDraweeView homePageFragment4_08;


    @Override
    protected int getResource() {
        return R.layout.fragment_home_page_fragment4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        homePageFragment4_01 = findViewByIdNoCast(R.id.homePageFragment4_01);
        homePageFragment4_02 = findViewByIdNoCast(R.id.homePageFragment4_02);
        homePageFragment4_03 = findViewByIdNoCast(R.id.homePageFragment4_03);
        homePageFragment4_04 = findViewByIdNoCast(R.id.homePageFragment4_04);
        homePageFragment4_05 = findViewByIdNoCast(R.id.homePageFragment4_05);
        homePageFragment4_06 = findViewByIdNoCast(R.id.homePageFragment4_06);
        homePageFragment4_07 = findViewByIdNoCast(R.id.homePageFragment4_07);
        findViewByIdNoCast(R.id.marriagelin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.openActivity(getContext(),HomePageFragment7.class);
            }
        });

        homePageFragment4_08 = findViewByIdNoCast(R.id.homePageFragment4_08);
        homePageFragment4_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.openActivity(getContext(), Home_margin.class);
            }
        });

    }

    @Override
    protected void initData() {
        HttpHelper.getBannerServlet("156", new HttpCallBack<BannerResultBean>() {
            @Override
            public void onSuccess(BannerResultBean result) {
                homePageFragment4_01.setImageURI(Uri.parse(result.center_banner.get(0).adImgUrl));
                homePageFragment4_02.setImageURI(Uri.parse(result.center_banner.get(1).adImgUrl));
                homePageFragment4_03.setImageURI(Uri.parse(result.position_banner.get(0).iconUrl));
                homePageFragment4_04.setImageURI(Uri.parse(result.position_banner.get(1).iconUrl));
                homePageFragment4_05.setImageURI(Uri.parse(result.position_banner.get(5).iconUrl));
                homePageFragment4_06.setImageURI(Uri.parse(result.position_banner.get(2).iconUrl));
                homePageFragment4_07.setImageURI(Uri.parse(result.position_banner.get(3).iconUrl));
                homePageFragment4_08.setImageURI(Uri.parse(result.position_banner.get(4).iconUrl));
                Log.e("XXXX", "onSuccess: " + result.toString());
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
