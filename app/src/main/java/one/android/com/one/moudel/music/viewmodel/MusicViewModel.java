package one.android.com.one.moudel.music.viewmodel;


import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;

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

public class MusicViewModel extends BaseViewModel<ActivityMusicBinding,MusicModel> implements BaseBindingItemPresenter<MusicListInfo>{

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
        adapter = new SingleTypeBindingAdapter(mActivity,null, R.layout.item_music_list);
        adapter.setItemPresenter(this);
        //设置Adapter
        mBinding.rvContent.setAdapter(adapter);
        //设置布局管理器(线性布局管理器)
        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(mActivity));
        final List<MusicListInfo> list  = new ArrayList<>();
        MultiTypeBindingAdapter adapter1 =  new MultiTypeBindingAdapter(mActivity,list, R.layout.item_music_list){
            @Override
            public int getMyItemViewType(int position, ArrayMap multiTypeMap) {
                MusicListInfo musicListInfo = list.get(position);
                if (musicListInfo.ad_type==1){
                    return 1;
                }
                return ITEM_VIEW_NORMAL_TYPE;
            }
        };
        ArrayMap multiTypeMap = new ArrayMap();
        multiTypeMap.put(1,R.layout.pager_empty);
        adapter1.addMultiTypeMap(multiTypeMap);
        adapter1.setItemDecorator(new BaseDataBindingDecorator<MusicListInfo>() {
            @Override
            public void decorator(BindingViewHolder holder, int position, int viewType, MusicListInfo mData) {
                ItemMusicListBinding binding = (ItemMusicListBinding) holder.getBinding();
                if (mData.ad_type==1){
                    binding.tvTitle.setText("我是1");
                }
            }
        });
    }



    @Override
    public void onItemClick(int position ,MusicListInfo itemData) {
        Logger.d("-------");
    }
    public void clickAvatat(MusicListInfo itemData){
        String id = itemData.id;
    }
}
