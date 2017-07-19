package one.android.com.one.moudel.main.viewmodel;

import java.util.List;

import one.android.com.one.base.BaseViewModel;
import one.android.com.one.databinding.FragmentHomeContentBinding;
import one.android.com.one.moudel.main.model.HomeContentModel;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomeContentViewModel extends BaseViewModel<FragmentHomeContentBinding,HomeContentModel>  {

    private String dayId;

    @Override
    public void initNet() {
        mModel.getDayDataList(dayId).subscribe(new Subscriber<List<Object>>() {
            //完成
            @Override
            public void onCompleted() {

            }

            //错误
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Object> dayIdList) {
            }
        });
    }

    @Override
    public void initView() {
        dayId = mFragment.getArguments().getString("dayId");
        mBinding.tvText.setText(dayId);
    }

}
