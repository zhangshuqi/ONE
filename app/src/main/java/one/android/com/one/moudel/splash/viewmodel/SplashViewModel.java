package one.android.com.one.moudel.splash.viewmodel;


import com.alibaba.fastjson.JSON;
import com.orhanobut.logger.Logger;

import java.util.List;

import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ActivitySplashBinding;
import one.android.com.one.moudel.splash.model.SplashModel;
import one.android.com.one.utils.IntentUtils;
import one.android.com.one.utils.SPControler;
import one.android.com.one.utils.TimerUtils;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class SplashViewModel extends BaseViewModel<ActivitySplashBinding, SplashModel> implements BaseBindingItemPresenter<MusicListInfo> {
    @Override
    public void initNet() {

        mModel.getDayIdList().subscribe(new Subscriber<List<String>>() {
            //完成
            @Override
            public void onCompleted() {

            }

            //错误
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<String> dayIdList) {
                SPControler.DayId.saveDayIdList(JSON.toJSONString(dayIdList));
            }
        });
    }

    @Override
    public void initView() {
        TimerUtils.countdown(4).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                IntentUtils.toMainActivity(mActivity);
                mActivity.finish();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {

            }
        });

    }


    @Override
    public void onItemClick(int position, MusicListInfo itemData) {
        Logger.d("-------");
    }

}
