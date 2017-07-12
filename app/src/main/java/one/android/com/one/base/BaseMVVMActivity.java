package one.android.com.one.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import one.android.com.one.utils.TUtil;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public abstract class BaseMVVMActivity<VM extends BaseViewModel>extends AppCompatActivity {
    protected Bundle savedInstanceState;
    private ViewDataBinding viewDataBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //保存实例状态
        this.savedInstanceState = savedInstanceState;
        //判断,返回的ID如果是小于或者等于0,抛出空指针异常
        if (getLayoutId() <= 0) {
                throw new NullPointerException("activity layout is null");
        }
        //setContentView(getLayoutId());
        //关联布局
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        //通过泛型拿到具体对象
        mViewModel = TUtil.getT(this, 0);
        //获取viewDataBinding ,activity
        mViewModel.init(viewDataBinding,this);
    }

    //让子类实现来关联布局
    public abstract int getLayoutId();

    //继续
    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    //暂停
    @Override
    protected void onPause() {
        super.onPause();
        mViewModel.onPause();
    }

    //销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.onDestroy();
        mViewModel= null;
        viewDataBinding = null;

    }

    //activity结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel. onActivityResult( requestCode,  resultCode,  data);
    }

}
