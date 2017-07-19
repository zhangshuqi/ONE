package one.android.com.one.moudel.home.viewmodel;

import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.HomeContentListInfo;
import one.android.com.one.databinding.ActivityHomeBinding;
import one.android.com.one.moudel.home.model.HomeModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomeViewModel extends BaseViewModel<ActivityHomeBinding,HomeModel> implements BaseBindingItemPresenter<HomeContentListInfo> {

    @Override
    public void initNet() {

    }

    @Override
    public void initView() {
    //    SingleTypeBindingAdapter singleTypeBindingAdapter = new SingleTypeBindingAdapter(mActivity, null, R.layout.item_home_list);

    }

    @Override
    public void onItemClick(int position, HomeContentListInfo itemData) {

    }
}
