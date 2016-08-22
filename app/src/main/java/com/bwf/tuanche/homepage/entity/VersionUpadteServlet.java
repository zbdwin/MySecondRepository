package com.bwf.tuanche.homepage.entity;

/**
 * Created by wanli on 2016/8/22.
 * Description:
 */
public class VersionUpadteServlet {
    public String versionCode;

    public String versionName;

    public String url;

    public String md5file;

    public String description;

    public String upgradeStringervalWarn;

    public String isFourceUpGrade;

    public String isPromtUpGrade;

    public String titleText;

    public String giveUpText;

    public String upgradeText;

    public String textPic;

    public String isForce;

    public String specificEdition;

    public String minVersion;


    @Override
    public String toString() {
        return "VersionUpadteServlet{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", url='" + url + '\'' +
                ", md5file='" + md5file + '\'' +
                ", description='" + description + '\'' +
                ", upgradeStringervalWarn='" + upgradeStringervalWarn + '\'' +
                ", isFourceUpGrade='" + isFourceUpGrade + '\'' +
                ", isPromtUpGrade='" + isPromtUpGrade + '\'' +
                ", titleText='" + titleText + '\'' +
                ", giveUpText='" + giveUpText + '\'' +
                ", upgradeText='" + upgradeText + '\'' +
                ", textPic='" + textPic + '\'' +
                ", isForce='" + isForce + '\'' +
                ", specificEdition='" + specificEdition + '\'' +
                ", minVersion='" + minVersion + '\'' +
                '}';
    }
}
