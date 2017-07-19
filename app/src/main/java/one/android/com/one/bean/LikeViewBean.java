package one.android.com.one.bean;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/7/14.
 */

public class LikeViewBean {

    public String mUrl;
    public int mLikeNum;
    public Drawable mLikeSrc;
    public boolean mType;
    public Context mContext;

    public LikeViewBean() {
    }

    public LikeViewBean(String url, int likeNum, Drawable likeSrc, boolean type, Context context) {

        mUrl = url;
        mLikeNum = likeNum;
        mLikeSrc = likeSrc;
        mType = type;
        mContext = context;
    }


}