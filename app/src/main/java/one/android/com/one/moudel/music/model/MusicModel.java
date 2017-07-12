package one.android.com.one.moudel.music.model;


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

public class MusicModel implements BaseModel {

     public Observable<List<MusicListInfo>> getMusicListData(){
       return   HttpMethods.getInstance()
               .apiService.getMusicList()
               .compose(RxJavaHttpHelper.<List<MusicListInfo>>handleResult())
               .compose(RxSchedulersHelper.<List<MusicListInfo>>applyIoTransformer());
     }
}
