package one.android.com.one.wrapper.recyclerview.databindingadapter;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2017/2/10 0010.
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private   T mBinding;


    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding=binding;
    }
    //返回一个view
    public T getBinding(){
        return mBinding;
    }

}
