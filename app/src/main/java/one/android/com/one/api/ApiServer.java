package one.android.com.one.api;


import java.util.List;

import one.android.com.one.base.BaseRequestData;
import one.android.com.one.bean.MusicListInfo;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public interface ApiServer {
    @GET(Url.MUSIC_LIST)
    Observable<BaseRequestData<List<MusicListInfo>>> getMusicList();
}
