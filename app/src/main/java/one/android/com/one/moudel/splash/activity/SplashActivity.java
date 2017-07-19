package one.android.com.one.moudel.splash.activity;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMActivity;
import one.android.com.one.moudel.splash.viewmodel.SplashViewModel;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class SplashActivity extends BaseMVVMActivity<SplashViewModel> {
    @Override
    //关联布局
    public int getLayoutId() {
        return R.layout.activity_splash;
    }
}
