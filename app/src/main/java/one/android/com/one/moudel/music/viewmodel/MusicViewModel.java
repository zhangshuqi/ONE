package one.android.com.one.moudel.music.viewmodel;


import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import one.android.com.one.R;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ActivityMusicBinding;
import one.android.com.one.databinding.ItemMusicListBinding;
import one.android.com.one.moudel.music.model.MusicModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseDataBindingDecorator;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BindingViewHolder;
import one.android.com.one.wrapper.recyclerview.databindingadapter.MultiTypeBindingAdapter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.SingleTypeBindingAdapter;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class MusicViewModel extends BaseViewModel<ActivityMusicBinding, MusicModel> implements BaseBindingItemPresenter<MusicListInfo> {

    private SingleTypeBindingAdapter adapter;

    @Override
    public void initNet() {

        mModel.getMusicListData().subscribe(new Subscriber<List<MusicListInfo>>() {
            //完成
            @Override
            public void onCompleted() {

            }

            //错误
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MusicListInfo> musicListInfo) {
                adapter.refresh(musicListInfo);
            }
        });
    }

    @Override
    public void initView() {

        //创建一个item布局
        adapter = new SingleTypeBindingAdapter(mActivity, null, R.layout.item_music_list);

        //设置点击事件
        adapter.setItemPresenter(this);
        //设置Adapter
        mBinding.rvContent.setAdapter(adapter);
        //设置布局管理器(线性布局管理器)
        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(mActivity));
        //设置集合
        final List<MusicListInfo> list = new ArrayList<>();

        //创建MultiTypeBindingAdapter对象
        MultiTypeBindingAdapter adapter1 = new MultiTypeBindingAdapter(mActivity, list, R.layout.item_music_list) {
            //获得item类型
            @Override
            public int getMyItemViewType(int position, ArrayMap multiTypeMap) {

                return ITEM_VIEW_NORMAL_TYPE;
            }
        };

        //获得集合对象
        ArrayMap multiTypeMap = new ArrayMap();
        //添加到集合
        multiTypeMap.put(1, R.layout.pager_empty);
        //关联item布局
        adapter1.addMultiTypeMap(multiTypeMap);
        //
        adapter1.setItemDecorator(new BaseDataBindingDecorator<MusicListInfo>() {

            @Override
            public void decorator(BindingViewHolder holder, int position, int viewType, MusicListInfo mData) {
                //得到XML布局对象
                ItemMusicListBinding binding = (ItemMusicListBinding) holder.getBinding();
                binding.tvTitle.setText("我是1");

                Glide.with(mActivity).load(mData.img_url).into(binding.ivMusicItem);

            }
        });
    }


    @Override
    public void onItemClick(int position, MusicListInfo itemData) {
        Logger.d("-------");
    }

    public void clickAvatat(MusicListInfo itemData) {
        String id = itemData.id;
    }


}
