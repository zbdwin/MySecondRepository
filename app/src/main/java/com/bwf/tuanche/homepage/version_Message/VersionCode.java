package com.bwf.tuanche.homepage.version_Message;

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.webkit.WebView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.entity.VersionUpadteServlet;
import com.bwf.tuanche.homepage.entity.VersionUpadteServletRoot;

/**
 * Created by wanli on 2016/8/22.
 * Description:
 */
public class VersionCode extends BaseActivity {
    private WebView VersionCodeview;

    private int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // 获取软件版本号，
            versionCode = context.getPackageManager().getPackageInfo("com.szy.update", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    @Override
    public int getContentViewId() {
        return R.layout.versioncode;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        VersionCodeview = findViewByIdNoCast(R.id.VersionCode1);

    }

    @Override
    public void initData() {
        getdata();

    }

    @Override
    public void onClick(View view) {

    }

    public void getdata() {
        HttpHelper.getVersionUpadteServlet(new HttpCallBack<VersionUpadteServlet>() {
            @Override
            public void onSuccess(VersionUpadteServlet result) {
                VersionCodeview.loadUrl(result.url);
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("++" + errMsg.toString());
            }
        });
    }
}
