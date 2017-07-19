package one.android.com.one.moudel.main.viewmodel;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import one.android.com.one.base.BaseFragmentAdapter;
import one.android.com.one.base.BaseViewModel;
import one.android.com.one.databinding.FragmentHomeBinding;
import one.android.com.one.moudel.home.model.HomeModel;
import one.android.com.one.moudel.main.fragment.HomeContentFragment;
import one.android.com.one.utils.SPControler;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomeViewModel extends BaseViewModel<FragmentHomeBinding,HomeModel>  {

    @Override
    public void initNet() {

    }

    @Override
    public void initView() {
        List<String> dayIdList = SPControler.DayId.getDayIdList();
        if (dayIdList==null || dayIdList.size()==0){
            return;
        }
        List<Fragment> homeContentFragment = new ArrayList<>();
        for (String dayId:dayIdList
             ) {
            homeContentFragment.add(  HomeContentFragment.newInstance(dayId));
        }
        BaseFragmentAdapter adapter = new BaseFragmentAdapter(mActivity.getSupportFragmentManager(),homeContentFragment);
        mBinding.vpContent.setAdapter(adapter);
        mBinding.vpContent.setOffscreenPageLimit(3);
    }

}
