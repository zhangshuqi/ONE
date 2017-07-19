package one.android.com.one.moudel.home.activity;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMActivity;
import one.android.com.one.moudel.home.viewmodel.HomeViewModel;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomeActivity extends BaseMVVMActivity<HomeViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
