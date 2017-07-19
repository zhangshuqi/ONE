package one.android.com.one.moudel.main.fragment;

import android.os.Bundle;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMFragment;
import one.android.com.one.moudel.main.viewmodel.HomeContentViewModel;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class HomeContentFragment extends BaseMVVMFragment <HomeContentViewModel>{
    public static HomeContentFragment newInstance(String dayId) {
        Bundle args = new Bundle();
        args.putString("dayId", dayId);
        HomeContentFragment fragment = new HomeContentFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_content;
    }
}
