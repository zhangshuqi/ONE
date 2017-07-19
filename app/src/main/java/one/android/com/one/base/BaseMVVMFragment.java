package one.android.com.one.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import one.android.com.one.utils.TUtil;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public abstract class BaseMVVMFragment <VM extends BaseViewModel>extends Fragment {

    private ViewDataBinding fragmentRootViewDataBinding;
    private BaseViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() <= 0) {
            throw new NullPointerException("fragment layout is null");
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(getLayoutId(), container, false);
        fragmentRootViewDataBinding = DataBindingUtil.bind(rootView);
        //通过泛型拿到具体对象
        mViewModel = TUtil.getT(this, 0);
        //获取viewDataBinding ,activity
        mViewModel.init(fragmentRootViewDataBinding, (AppCompatActivity) getActivity(),this);
        return rootView;
    }

    //让子类实现来关联布局
    public abstract int getLayoutId();
}
