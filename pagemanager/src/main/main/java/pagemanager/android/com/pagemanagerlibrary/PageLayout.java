package pagemanager.android.com.pagemanagerlibrary;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhy on 15/8/26.
 */
public class PageLayout extends RelativeLayout {
    private View mLoadingView;
    private View mRetryView;
    private View mContentView;
    private View mEmptyView;
    private LayoutInflater mInflater;

    private static final String TAG = PageLayout.class.getSimpleName();


    public PageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }


    public PageLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PageLayout(Context context) {
        this(context, null);
    }

    private boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void showLoading() {
        if (isMainThread()) {
            showView(mLoadingView);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mLoadingView);
                }
            });
        }
    }

    public void showRetry() {
        if (isMainThread()) {
            showView(mRetryView);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mRetryView);
                }
            });
        }

    }

    public void showContent() {
        if (isMainThread()) {
            showView(mContentView);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mContentView);
                }
            });
        }
    }

    public void showEmpty() {
        if (isMainThread()) {
            showView(mEmptyView);
        } else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mEmptyView);
                }
            });
        }
    }


    private void showView(View view) {
        if (view == null) return;

        if (view == mLoadingView) {
            mLoadingView.setVisibility(View.VISIBLE);
            if (mRetryView != null)
                mRetryView.setVisibility(View.GONE);
            if (mContentView != null)
                mContentView.setVisibility(View.GONE);
            if (mEmptyView != null)
                mEmptyView.setVisibility(View.GONE);
        } else if (view == mRetryView) {
            mRetryView.setVisibility(View.VISIBLE);
            if (mLoadingView != null)
                mLoadingView.setVisibility(View.GONE);
            if (mContentView != null)
                mContentView.setVisibility(View.GONE);
            if (mEmptyView != null)
                mEmptyView.setVisibility(View.GONE);
        } else if (view == mContentView) {
            mContentView.setVisibility(View.VISIBLE);
            if (mLoadingView != null)
                mLoadingView.setVisibility(View.GONE);
            if (mRetryView != null)
                mRetryView.setVisibility(View.GONE);
            if (mEmptyView != null)
                mEmptyView.setVisibility(View.GONE);
        } else if (view == mEmptyView) {
            mEmptyView.setVisibility(View.VISIBLE);
            if (mLoadingView != null)
                mLoadingView.setVisibility(View.GONE);
            if (mRetryView != null)
                mRetryView.setVisibility(View.GONE);
            if (mContentView != null)
                mContentView.setVisibility(View.GONE);
        }


    }

    public View setContentView(int layoutId) {
        return setContentView(mInflater.inflate(layoutId, this, false));
    }

    public View setLoadingView(int layoutId) {
        return setLoadingView(mInflater.inflate(layoutId, this, false));
    }

    public View setEmptyView(int layoutId) {
        return setEmptyView(mInflater.inflate(layoutId, this, false));
    }

    public View setRetryView(int layoutId) {
        return setRetryView(mInflater.inflate(layoutId, this, false));
    }

    public View setLoadingView(View view) {
        View loadingView = mLoadingView;
        if (loadingView != null) {
            Log.w(TAG, "you have already set a loading view and would be instead of this new one.");
        }
        removeView(loadingView);
        addView(view);
        mLoadingView = view;
        return mLoadingView;
    }

    public View setEmptyView(View view) {
        View emptyView = mEmptyView;
        if (emptyView != null) {
            Log.w(TAG, "you have already set a empty view and would be instead of this new one.");
        }
        removeView(emptyView);
        addView(view);
        mEmptyView = view;
        return mEmptyView;
    }

    public View setRetryView(View view) {
        View retryView = mRetryView;
        if (retryView != null) {
            Log.w(TAG, "you have already set a retry view and would be instead of this new one.");
        }

        removeView(retryView);
        addView(view);
        mRetryView = view;
        return mRetryView;

    }

    public View setContentView(View view) {
        View contentView = mContentView;
        if (contentView != null) {
            Log.w(TAG, "you have already set a retry view and would be instead of this new one.");
        }
        removeView(contentView);
        addView(view);
        mContentView = view;
        return mContentView;
    }

    public View getRetryView() {
        return mRetryView;
    }

    public View getLoadingView() {
        return mLoadingView;
    }

    public View getContentView() {
        return mContentView;
    }

    public View getEmptyView() {
        return mEmptyView;
    }


    public View setEmptyCustomMessageLayout(int layoutId, String emptyMsg) {
        return setCustomEmptyMessage(layoutId, emptyMsg);
    }
    public View setRetryCustomMessageViewLayout(int layoutId, String retryMsg) {
        return setCustomRetryMessage(layoutId, retryMsg);
    }

    public View setLoadingCustomMessageLayout(int layoutId, String loadMsg) {
        return setCustomLodingMessage(layoutId, loadMsg);
    }



    public View setCurrentEmptyMessageLayout( String emptyMsg) {
        return setCustomEmptyMessage(PageManager.BASE_EMPTY_LAYOUT_ID, emptyMsg);
    }

    public View setCurrentRetryMessageViewLayout( String retryMsg) {
        return setCustomRetryMessage(PageManager.BASE_RETRY_LAYOUT_ID, retryMsg);
    }

    public View setCurrentLoadingMessageLayout( String loadMsg) {
        return setCustomLodingMessage(PageManager.BASE_LOADING_LAYOUT_ID, loadMsg);
    }

    private View setCustomRetryMessage(int layoutId, String retryMsg) {
        View emptyView = mInflater.inflate(layoutId, this, false);
        TextView viewById = (TextView) emptyView.findViewById(R.id.tv_error_msg);
        viewById.setText(retryMsg);
        return setRetryView(emptyView);
    }
    private View setCustomLodingMessage(int layoutId, String loadMsg) {
        View emptyView = mInflater.inflate(layoutId, this, false);
        TextView viewById = (TextView) emptyView.findViewById(R.id.tv_loading);
        viewById.setText(loadMsg);
        return setLoadingView(emptyView);
    }

    private View setCustomEmptyMessage(int layoutId, String emptyMsg) {
        View emptyView = mInflater.inflate(layoutId, this, false);
        TextView viewById = (TextView) emptyView.findViewById(R.id.tv_empty_msg);
        viewById.setText(emptyMsg);
        return setEmptyView(emptyView);
    }
}
