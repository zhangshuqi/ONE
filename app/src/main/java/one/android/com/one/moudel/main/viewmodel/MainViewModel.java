package one.android.com.one.moudel.main.viewmodel;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import one.android.com.one.R;
import one.android.com.one.base.BaseFragmentAdapter;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.databinding.ActivityMainBinding;
import one.android.com.one.moudel.main.fragment.ArticleFragment;
import one.android.com.one.moudel.main.fragment.HomeFragment;
import one.android.com.one.moudel.main.fragment.MovieFragment;
import one.android.com.one.moudel.main.fragment.MusicFragment;
import one.android.com.one.moudel.main.model.MainModel;

/**
 * Created by Administrator on 2017/7/19.
 */

public class MainViewModel extends BaseViewModel<ActivityMainBinding, MainModel> implements RadioGroup.OnCheckedChangeListener {

    private int currentFragmentPosition;

    @Override
    public void initNet() {

    }

    @Override
    public void initView() {
        mBinding.rg.setOnCheckedChangeListener(this);
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new HomeFragment());
        listFragment.add(new MusicFragment());
        listFragment.add(new ArticleFragment());
        listFragment.add(new MovieFragment());
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(mActivity.getSupportFragmentManager(), listFragment);
        mBinding.vpContent.setAdapter(adapter);
        mBinding.vpContent.setOffscreenPageLimit(2);
        mBinding.vpContent.setPagingEnabled(false);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                if (currentFragmentPosition == 0) return;
                currentFragmentPosition = 0;
                mBinding.vpContent.setCurrentItem(currentFragmentPosition);
                // 首页
                break;
            case R.id.rb2:
                if (currentFragmentPosition == 1) return;
                currentFragmentPosition = 1;
                mBinding.vpContent.setCurrentItem(1);
                mBinding.vpContent.setCurrentItem(currentFragmentPosition);
                // 音乐
                break;
            case R.id.rb3:
                if (currentFragmentPosition == 2) return;
                currentFragmentPosition = 2;
                mBinding.vpContent.setCurrentItem(2);
                mBinding.vpContent.setCurrentItem(currentFragmentPosition);
                // 阅读
                break;
            case R.id.rb4:
                if (currentFragmentPosition == 3) return;
                currentFragmentPosition = 3;
                mBinding.vpContent.setCurrentItem(currentFragmentPosition);
                // 视频
                break;
        }


    }
}
