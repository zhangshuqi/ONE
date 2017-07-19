package one.android.com.one.api;


import java.util.List;
import java.util.Map;

import one.android.com.one.base.BaseRequestData;
import one.android.com.one.bean.MusicListInfo;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public interface ApiServer {
    @GET(Url.MUSIC_LIST)
    Observable<BaseRequestData<List<MusicListInfo>>> getMusicList();

    @GET(Url.READ_LIST)
    Observable<BaseRequestData<List<MusicListInfo>>> getReadList();
    //http://v3.wufazhuce.com:8000/api/praise/add?channel=update&source_id=9598&source=summary&version=4.0.7&
    //uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    @FormUrlEncoded
    @POST()
    Observable<BaseRequestData<Object>> praiseMusic(@retrofit2.http.Url String url ,@FieldMap Map<String,String>  map);
    
}
