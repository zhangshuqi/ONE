package one.android.com.one.wrapper.recyclerview.databindingadapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import one.android.com.one.BR;

/**
 * Created by Administrator on 2017/2/10 0010.
 */

public class SingleTypeBindingAdapter<T> extends BaseDataBindingAdapter<T> {
    private int mLayoutRes;
    protected Object footSingleFootData;
    protected int footSingleFootRes;
    protected int footSingleKey;
    private Object headSingleData;
    private int headSingleKey;
    private int headSingleFootRes;
    private BindingViewHolder footBindingHolder;

    //初始化
    public SingleTypeBindingAdapter(Context context, List data, int layoutRes) {
        super(context);
        mData = data;
        if (mData==null)mData= new ArrayList<>();
        mLayoutRes = layoutRes;
    }

    //创建
    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //返回创建一个item的ID
        return new BindingViewHolder(DataBindingUtil.inflate(mLayoutInflater, getLayoutRes(), parent, false));
    }

    //绑定
    @Override
    public void onBindViewHolder(BindingViewHolder holder, final int position) {
        if (mData == null) {
            throw new NullPointerException("BaseDataBindingAdapter  data is null");
        }

        //因为有头跟尾布局,会导致item获得错误的数据
        Object data = null;
        ViewDataBinding binding = holder.getBinding();
        int itemViewType = getItemViewType(position);
        if (isHeaderView(position)) {
            if (headSingleData == null) return;
            data = headSingleData;
            if (headDecorator != null)
                headDecorator.decorator(holder, position, itemViewType, headSingleData);
            if (headPresenter != null)
                binding.setVariable(BR.presenter, headPresenter);
        } else if (isFooterView(position)) {
            if (footSingleFootData == null) return;
            data = footSingleFootData;
            if (footPresenter != null)
                binding.setVariable(BR.presenter, footPresenter);
            if (footDecorator != null) {
                footDecorator.decorator(holder, position - getHeadAndItemCount(), itemViewType, footSingleFootData);
            }
            footBindingHolder = holder;
        } else {
            data = mData.get(position - getHeadCount());
            if (itemDecorator != null)
                itemDecorator.decorator(holder, position - getHeadCount(), itemViewType, data);
            if (mPresenter != null) {
                binding.setVariable(BR.presenter, mPresenter);
            }
        }
        if (canLongClick) {
            holder.getBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemLongPresenter.onItemLongClick(position, mData.get(position));
                    return canLongClick;
                }
            });
        }
        // 分配数据
        holder.getBinding().setVariable(BR.itemData, data);
        holder.getBinding().setVariable(BR.itemPosition, position);
        holder.getBinding().executePendingBindings();
    }

    @Override
    @LayoutRes
    public int getLayoutRes() {
        //根据ID获得布局
        return mLayoutRes;
    }

    //尾部布局
    @Override
    public boolean isFooterView(int position) {
        if (footSingleKey <= 0) {
            return false;
        } else if (footSingleFootRes <= 0) {
            return false;
        }
        int count = mData.size();
        return position >= count && position <= getItemCount();
    }

    //头布局
    @Override
    protected boolean isHeaderView(int position) {
        if (headSingleKey <= 0) {
            return false;
        } else if (footSingleFootRes <= 0) {
            return false;
        } else if (headSingleData == null) {
            return false;
        }
        return position == 0;

    }

    //获得头+item个数
    @Override
    protected int getHeadAndItemCount() {
        int count = 0;
        count += getHeadCount();
        count += mData.size();
        return count;
    }

    //获得头个数
    private int getHeadCount() {
        int count = 0;
        if (headSingleData != null && headSingleKey > 0 && footSingleFootRes > 0) {
            count++;
        }
        return count;
    }

    //添加尾部设置
    public void addSingleFootConfig(int footKey, int footRes, Object footData) {
        footSingleKey = footKey;
        footSingleFootRes = footRes;
        if (footData == null) {
            footData = new Object();
        }
        footSingleFootData = footData;
    }

    //添加头部设置
    public void addSingleHeaderConfig(int headKey, int headRes, Object headData) {
        headSingleKey = headKey;
        headSingleFootRes = headRes;
        if (headData == null) {
            headData = new Object();
        }
        headSingleData = headData;
    }

    //获得item个数
    @Override
    public int getItemCount() {
        int size = mData.size();
        if (footSingleKey > 0) {
            size = size + 1;
        }
        return size;
    }
}
