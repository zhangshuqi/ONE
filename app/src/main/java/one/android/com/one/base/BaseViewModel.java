package one.android.com.one.base;

import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import one.android.com.one.utils.TUtil;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public abstract class BaseViewModel <V extends ViewDataBinding,M extends BaseModel>{
    protected AppCompatActivity mActivity;
    protected V mBinding ;
    protected M mModel;
    protected Fragment mFragment;

    //初始化mBinding,mModel,mActivity
    public void init(ViewDataBinding viewDataBinding, AppCompatActivity activity) {
        mActivity = activity;
        mBinding= (V) viewDataBinding;
        mModel = TUtil.getT(this, 1);
        initView();
        initNet();

    }  public void init(ViewDataBinding viewDataBinding, AppCompatActivity activity, Fragment fragment) {
       this.mFragment =fragment;
        init(viewDataBinding,activity);
    }

    public abstract void  initNet() ;

    public abstract void  initView() ;

    public void onResume() {
        
    }

    public void onPause() {
    }

    public void onDestroy() {
        mModel= null;
        mActivity = null;
        mBinding = null;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
