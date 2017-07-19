package one.android.com.one.moudel.read.viewmodel;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import one.android.com.one.R;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.databinding.ActivityReadBinding;
import one.android.com.one.databinding.ItemMusicListBinding;
import one.android.com.one.moudel.read.model.ReadModel;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseBindingItemLongPresenter;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BaseDataBindingDecorator;
import one.android.com.one.wrapper.recyclerview.databindingadapter.BindingViewHolder;
import one.android.com.one.wrapper.recyclerview.databindingadapter.SingleTypeBindingAdapter;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ReadViewModel extends BaseViewModel<ActivityReadBinding,ReadModel> implements BaseBindingItemLongPresenter<MusicListInfo> {

    private SingleTypeBindingAdapter adapter;

    @Override
    public void initNet() {

        mModel.getReadData().subscribe(new Subscriber<List<MusicListInfo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<MusicListInfo> musicListInfos) {
                adapter.refresh(musicListInfos);
            }


        });

    }

    @Override
    public void initView() {
        adapter = new SingleTypeBindingAdapter(mActivity,null, R.layout.item_music_list);


        //设置Adapter
        mBinding.rvContent.setAdapter(adapter);
        //设置布局管理器(线性布局管理器)
        mBinding.rvContent.setLayoutManager(new LinearLayoutManager(mActivity));


        adapter.setItemDecorator(new BaseDataBindingDecorator<MusicListInfo>() {
            @Override
            public void decorator(BindingViewHolder holder, int position, int viewType, MusicListInfo mData) {
                final ItemMusicListBinding binding = (ItemMusicListBinding) holder.getBinding();


                //设置成没点赞
                binding.likeView.setIsLike(false);
                //设置点赞的个数
                binding.likeView.setLikeCount(mData.like_count);

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
    }

    @Override
    public void onItemLongClick(int position, MusicListInfo itemData) {

    }


}
