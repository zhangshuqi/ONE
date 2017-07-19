package one.android.com.one.moudel.splash.model;


import java.util.List;

import one.android.com.one.base.BaseModel;
import one.android.com.one.http.HttpMethods;
import one.android.com.one.http.RxJavaHttpHelper;
import one.android.com.one.http.rxschedulers.RxSchedulersHelper;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class SplashModel implements BaseModel {

     public Observable<List<String>> getDayIdList(){
       return   HttpMethods.getInstance()
               .apiService.getDayIdList()
               .compose(RxJavaHttpHelper.<List<String>>handleResult())
               .compose(RxSchedulersHelper.<List<String>>applyIoTransformer());
     }
}
