package one.android.com.one.moudel.music.viewmodel;


import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import one.android.com.one.R;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.LikeViewBean;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ActivityMusicBinding;
import one.android.com.one.databinding.ItemMusicListBinding;
import one.android.com.one.moudel.music.model.MusicModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemPresenter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseDataBindingDecorator;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BindingViewHolder;
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

        //设置布局管理器(线性布局管理器)
        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(mActivity));
        //设置集合
        final List<MusicListInfo> list = new ArrayList<>();

     /*   //创建MultiTypeBindingAdapter对象
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
        //*/
        adapter.setItemDecorator(new BaseDataBindingDecorator<MusicListInfo>() {

            @Override
            public void decorator(BindingViewHolder holder, int position, int viewType, MusicListInfo mData) {
                //得到XML布局对象
                final ItemMusicListBinding binding = (ItemMusicListBinding) holder.getBinding();
                //binding.tvTitle.setText("我是1");
             //   Glide.with(mActivity).load(mData.img_url).into(binding.ivMusicItem);
        /*        //设置成没点赞
                binding.likeView.setIsLike(false);
                //设置点赞的个数
                binding.likeView.setLikeCount(mData.like_count);
                //binding.likeView.setLikeInfo(mData);*/
                LikeViewBean bean = new LikeViewBean();
                bean.mLikeNum= mData.like_count;
                binding.likeView.setLikeViewBean(bean);
                //显示图片并把图片改成圆形
                Glide.with(mActivity).load(mData.img_url).asBitmap().centerCrop().into(new BitmapImageViewTarget(binding.ivMusicItem) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mActivity.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        binding.ivMusicItem.setImageDrawable(circularBitmapDrawable);
                    }
                });
            }
        });
        //设置Adapter
        mBinding.rvContent.setAdapter(adapter);
    }


    @Override
    public void onItemClick(int position, MusicListInfo itemData) {
        Logger.d("-------");
    }

    public void clickAvatat(MusicListInfo itemData) {
        String id = itemData.id;
    }


}
