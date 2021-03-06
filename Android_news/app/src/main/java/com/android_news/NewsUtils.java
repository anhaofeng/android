package com.android_news;

import android.content.Context;

import java.util.ArrayList;

public class NewsUtils {

    //封装新闻的假数据到list中返回
    public static ArrayList<NewsBean> getAllNews(Context context) {

        ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();

        for(int i = 0 ;i <100;i++)
        {
            NewsBean newsBean = new NewsBean();
            newsBean.title ="谢霆锋经纪人：偷拍系侵权行为：";
            newsBean.des= "称谢霆锋隐私权收到侵犯，将保留追究法律责任";
            newsBean.news_url= "http://www.sina.cn";
            newsBean.icon = context.getResources().getDrawable(android.R.mipmap.sym_def_app_icon);//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(newsBean);


            NewsBean newsBean1 = new NewsBean();
            newsBean1.title ="知情人：王菲是谢霆锋心头最爱的人";
            newsBean1.des= "身边的人都知道谢霆锋最爱王菲，二人早有复合迹象";
            newsBean1.news_url= "http://www.baidu.cn";
            newsBean1.icon = context.getResources().getDrawable(android.R.mipmap.sym_def_app_icon);//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(newsBean1);



            NewsBean newsBean2 = new NewsBean();
            newsBean2.title ="热烈祝贺黑马74高薪就业";
            newsBean2.des= "74期平均薪资20000，其中有一个哥们超过10万，这些It精英都迎娶了白富美.";
            newsBean2.news_url= "http://www.itheima.com";
            newsBean2.icon = context.getResources().getDrawable(android.R.mipmap.sym_def_app_icon);//通过context对象将一个资源id转换成一个Drawable对象。
            arrayList.add(newsBean2);
        }
        return arrayList;
    }

}
