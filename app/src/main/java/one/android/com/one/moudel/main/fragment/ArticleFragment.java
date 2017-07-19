package one.android.com.one.moudel.main.fragment;

import one.android.com.one.R;
import one.android.com.one.base.BaseMVVMFragment;
import one.android.com.one.moudel.main.viewmodel.ArticleViewModel;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class ArticleFragment extends BaseMVVMFragment<ArticleViewModel> {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_article;
    }
}
