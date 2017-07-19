package one.android.com.one.moudel.splash.viewmodel;


import com.orhanobut.logger.Logger;

import java.util.List;

import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ActivitySplashBinding;
import one.android.com.one.moudel.splash.model.SplashModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.SingleTypeBindingAdapter;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class SplashViewModel extends BaseViewModel<ActivitySplashBinding, SplashModel> implements BaseBindingItemPresenter<MusicListInfo> {

    private SingleTypeBindingAdapter adapter;

    @Override
    public void initNet() {

        mModel.getMusicListData().subscribe(new Subscriber<List<MusicListInfo>>() {
            //完成
            @Override
            public void onCompleted() {

            }

            //错误
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MusicListInfo> musicListInfo) {
                adapter.refresh(musicListInfo);
            }
        });
    }

    @Override
    public void initView() {


    }


    @Override
    public void onItemClick(int position, MusicListInfo itemData) {
        Logger.d("-------");
    }

}
