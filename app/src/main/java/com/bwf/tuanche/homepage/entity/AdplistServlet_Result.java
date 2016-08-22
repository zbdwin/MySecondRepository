package com.bwf.tuanche.homepage.entity;

import java.util.List;

/**
 * Created by wanli on 2016/8/20.
 * Description:
 */
public class AdplistServlet_Result {
    public String adpTitle;//": "婚姻座驾",
    public String adpLogo;//": "http://pic.tuanche.com/ams/20150919/14426718579625495.png",
    public String shareUrl;//": "http://umapi.tuanche.com/wx/ad/popular?cityId=156&adpId=30&logo=http://pic.tuanche.com/ams/20150919/14426718579625495.png&title=婚姻座驾",
    public String sharePic;//": "http://pic.tuanche.com/ams/20150921/14428131954665581.png",
    public String shareCtx;//": "空间、经济、实用，家庭成员多就怕一车坐不下",
    public String shareSlogan;//": "婚姻座驾,给她最好的",
    public String isShare;//": 1,
    public String cardTotal;//": 14,
    public String offset;//": 20,
    public String count;//": 20
    public List<AdplistServlet_Root> carstyleList;

    @Override
    public String toString() {
        return "AdplistServlet_Result{" +
                "adpTitle='" + adpTitle + '\'' +
                ", adpLogo='" + adpLogo + '\'' +
                ", shareUrl='" + shareUrl + '\'' +
                ", sharePic='" + sharePic + '\'' +
                ", shareCtx='" + shareCtx + '\'' +
                ", shareSlogan='" + shareSlogan + '\'' +
                ", isShare='" + isShare + '\'' +
                ", cardTotal='" + cardTotal + '\'' +
                ", offset='" + offset + '\'' +
                ", count='" + count + '\'' +
                ", carstyleList=" + carstyleList +
                '}';
    }
}
