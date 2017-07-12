package one.android.com.one.http.rxsubscriber;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import one.android.com.one.http.rxexception.DefaultErrorBundle;
import one.android.com.one.http.rxexception.ErrorManager;
import one.android.com.one.utils.DialogUitls;
import pagemanager.android.com.pagemanager.PageManager;
import rx.Subscriber;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public abstract class ProgressSubscriber<T> extends Subscriber<T> {
    public final static int TYPE_PROFRESS_NONE = 0;
    public final static int TYPE_PROGRESS_DIALOG = 1;
    public final static int TYPE_PROFRESS_PAGEMANAGER = 2;
    private   Runnable pageManagerRunable;
    private   View pageManagerView;
    private   AppCompatActivity activity;
    public String loadingMessage;
    public int showProgressType;
    private ProgressDialog progressDialog;
    private PageManager pageManager;

    public ProgressSubscriber() {

    }

    public ProgressSubscriber(AppCompatActivity activity , int showProgressType, String loadingMessage) {
        init(activity, showProgressType, loadingMessage);
    }



    public ProgressSubscriber(AppCompatActivity activity , View view , String loadingMessage,Runnable runnable) {
        this.pageManagerView =view;
        this.pageManagerRunable=runnable;
        init(activity,TYPE_PROFRESS_PAGEMANAGER,loadingMessage);
    }
    private void init(AppCompatActivity activity, int showProgressType, String loadingMessage) {
        this.showProgressType = showProgressType;
        this.loadingMessage = loadingMessage;
        this.activity =activity;
    }
    @Override
    public void onCompleted() {
        _onCompleted();
    }

    @Override
    public void onStart() {
        super.onStart();
        _onStart();
        switch (showProgressType) {
            case TYPE_PROFRESS_NONE:
                break;
            case TYPE_PROGRESS_DIALOG:
                if (progressDialog!= null) {
                    progressDialog = DialogUitls.showProgressDialog(activity, loadingMessage);
                }else {
                    progressDialog.setMessage(loadingMessage);
                }
                progressDialog.show();
                break;
            case TYPE_PROFRESS_PAGEMANAGER:
                if (pageManager==null) {
                    pageManager = PageManager.init(pageManagerView, loadingMessage, pageManagerRunable);
                }
                pageManager.showLoading();
                break;
        }
    }

    @Override
    public void onError(Throwable e) {
        if (pageManager!=null)pageManager.showError();
        _onError(ErrorManager.handleError(new DefaultErrorBundle((Exception) e)));

    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    public void _onStart() {

    }

    public abstract void _onError(String message);

    public abstract void _onNext(T t);

    public abstract void _onCompleted();
}
