package one.android.com.one.moudel.main.viewmodel;

import one.android.com.one.R;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.HomeContentListInfo;
import one.android.com.one.databinding.FragmentMusicBinding;
import one.android.com.one.moudel.main.model.MusicModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.SingleTypeBindingAdapter;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MusicViewModel extends BaseViewModel<FragmentMusicBinding,MusicModel> implements BaseBindingItemPresenter<HomeContentListInfo> {

    @Override
    public void initNet() {

    }

    @Override
    public void initView() {
        SingleTypeBindingAdapter singleTypeBindingAdapter = new SingleTypeBindingAdapter(mActivity, null, R.layout.item_home_list);

    }

    @Override
    public void onItemClick(int position, HomeContentListInfo itemData) {

    }
}
