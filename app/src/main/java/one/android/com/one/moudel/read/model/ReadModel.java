package one.android.com.one.moudel.read.model;

import java.util.List;

import one.android.com.one.base.BaseModel;
import one.android.com.one.bean.MusicListInfo;
import one.android.com.one.http.HttpMethods;
import one.android.com.one.http.RxJavaHttpHelper;
import one.android.com.one.http.rxschedulers.RxSchedulersHelper;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/10.
 */

public class ReadModel implements BaseModel {

    //获得阅读数据  用的是music数据
    public Observable<List<MusicListInfo>> getReadData(){
        return HttpMethods.getInstance()
                .apiService.getReadList()
                .compose(RxJavaHttpHelper.<List<MusicListInfo>>handleResult())
                .compose(RxSchedulersHelper.<List<MusicListInfo>>applyIoTransformer());
    }
}
