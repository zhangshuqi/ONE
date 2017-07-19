package one.android.com.one.moudel.splash.model;


import java.util.List;

import one.android.com.one.base.BaseModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.http.HttpMethods;
import one.android.com.one.http.RxJavaHttpHelper;
import one.android.com.one.http.rxschedulers.RxSchedulersHelper;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public class SplashModel implements BaseModel {

     public Observable<List<MusicListInfo>> getDayIdList(){
       return   HttpMethods.getInstance()
               .apiService.getDayIdList()
               .compose(RxJavaHttpHelper.<List<MusicListInfo>>handleResult())
               .compose(RxSchedulersHelper.<List<MusicListInfo>>applyIoTransformer());
     }
}
