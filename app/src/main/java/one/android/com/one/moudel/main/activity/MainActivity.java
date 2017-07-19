package one.android.com.one.moudel.main.activity;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMActivity;
import one.android.com.one.moudel.main.viewmodel.MainViewModel;


public class MainActivity extends BaseMVVMActivity <MainViewModel>{


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
