package one.android.com.one.wrapper.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import one.android.com.one.R;
import one.android.com.one.bean.LikeViewBean;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ViewMusicLikeBinding;
import one.android.com.one.http.HttpMethods;
import one.android.com.one.http.RxJavaHttpHelper;
import one.android.com.one.http.rxschedulers.RxSchedulersHelper;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/13 0013.
 */

public class MusicLikeView extends RelativeLayout {
    private Context context;
    private ViewMusicLikeBinding mBinding;
    private LikeViewBean mLikeViewBean;

    public MusicLikeView(Context context) {
        this(context, null);
    }

    public MusicLikeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        /*LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = DataBindingUtil.inflate(layoutInflater, R.layout.view_music_like,this,false);*/
        View view = View.inflate(context, R.layout.view_music_like, null);
        addView(view);
        mBinding = DataBindingUtil.bind(view);
        mBinding.setLikeView(this);
    }

    public void likeToServers() {

        Map  map = new HashMap<>();
        map.put("itemid",2222+"");
        map.put("type","music");
        map.put("deviceid","ffffffff-c620-e1fd-ffff-ffff989a822c");
        map.put("jwt","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE0OTk2MjcxNTgsInVzZXJpZCI6IjgxNTA2NTEifQ.EG64lDli8o3hs0OMGLDKBghveNoJqgQ-6-45lYtnABQ&");
        map.put("devicetype","android");

    //  String url ="http://v3.wufazhuce.com:8000/api/praise/add?channel=mi&source=summary&version=4.2.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android&source_id=12544";
      String url ="/api/praise/add?user_id=8150651&channel=yingyongbao&source_id=12502&source=channel_music&version=4.2.2&uuid=ffffffff-c620-e1fd-ffff-ffff989a822c&platform=android";
        HttpMethods.getInstance().apiService.praiseMusic(url,map) .compose(RxJavaHttpHelper.<Object>handleResult())
                .compose(RxSchedulersHelper.<Object>applyIoTransformer()).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Logger.d("点赞成功");
                mBinding.ivLike.setSelected(true);
            }
        });
    }

    public void setIsLike(boolean isLike) {
    /*    if (isLike){
            mBinding.ivLike.setSelected(true);
        }else {
            mBinding.ivLike.setSelected(false);
        }*/
        //是否点赞了
        mBinding.ivLike.setSelected(isLike);
        //设置点赞的颜色
        mBinding.tvNumber.setTextColor(isLike?context.getResources().getColor(R.color.colorAccent) :context.getResources().getColor(R.color.colorPrimary));
    }

    //设置点赞个数的方法
    public void setLikeCount(int count ){
        mBinding.tvNumber.setText(count+"");
    }

    public void setLikeInfo(MusicListInfo mData) {
        mBinding.tvNumber.setText(mData.like_count+"");
    }

    public void setLikeViewBean(LikeViewBean likeViewBean) {
        mLikeViewBean = likeViewBean;
            mBinding.tvNumber.setText(mLikeViewBean.mLikeNum+"");
    }
}
