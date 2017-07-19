package one.android.com.one.moudel.main.model;

import java.util.List;

import one.android.com.one.base.BaseModel;
import one.android.com.one.http.HttpMethods;
import one.android.com.one.http.RxJavaHttpHelper;
import one.android.com.one.http.rxschedulers.RxSchedulersHelper;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/19.
 */

public class HomeContentModel implements BaseModel {

  public Observable<List<Object>> getDayDataList (String dayId){
      return   HttpMethods.getInstance()
              .apiService.getDayDataList(dayId)
              .compose(RxJavaHttpHelper.<List<Object>>handleResult())
              .compose(RxSchedulersHelper.<List<Object>>applyIoTransformer());
  }
}
