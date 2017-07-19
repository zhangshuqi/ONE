package one.android.com.one.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    public List<String> mTitleList;
    public   List<Fragment> mFragmentsList;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment>fragmentsList) {
        super(fm);
        this.mFragmentsList=fragmentsList;
    } public BaseFragmentAdapter(FragmentManager fm, List<Fragment>fragmentsList,List<String> titleList) {
        super(fm);
        this.mFragmentsList=fragmentsList;
        this.mTitleList=titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList==null ||mTitleList.size()==0) {
            return super.getPageTitle(position);
        }else {
            return mTitleList.get(position);
        }
    }
}
