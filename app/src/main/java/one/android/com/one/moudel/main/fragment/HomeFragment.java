package one.android.com.one.moudel.main.fragment;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMFragment;
import one.android.com.one.moudel.main.viewmodel.HomeViewModel;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class HomeFragment extends BaseMVVMFragment<HomeViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
