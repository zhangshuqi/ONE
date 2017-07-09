package one.android.com.one.moudel.music.activity;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMActivity;
import one.android.com.one.moudel.music.viewmodel.MusicViewModel;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class MusicActivity extends BaseMVVMActivity<MusicViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.activity_music;
    }
}
