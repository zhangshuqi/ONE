package one.android.com.one.api;

/**
 * Created by Administrator on 2017/7/9 0009.
 */

public interface Url {
    String BASE_URL = "http://v3.wufazhuce.com:8000/api/";

    //获取最新 idlist(返回的字段用于下个接口获取某一天的onelist,一共10个返回值,也就是10天的数据)
    String ID_LIST = "onelist/idlist/";
    //获取某天的 onelist
    String ONE_LIST = "onelist/";

    //阅读列表
    String READ_LIST = "channel/reading/more/0";
    //音乐列表
    String MUSIC_LIST = "channel/music/more/0";
    //影视列表
    String MOVIE_LIST = "channel/movie/more/0";

    //阅读相关详情
    String READ_DETAIL = "essay/";
    //阅读详情（问答）
    String READ_QUESTION = "question/itemId";
    //音乐详情
    String MUSIC_DETAIL = "music/detail/";
    //影视详情
    String MOVIE_DETAIL = "movie/itemId/story/1/0";
    //影视详情（图片和视频）
    String MOVIE_DETAIL_PIC = "movie/detail/itemId";

    //阅读评论
    String READ_COMMENT = "comment/praiseandtime/essay/";
    //音乐评论
    String MUSIC_COMMENT = "comment/praiseandtime/music/";
    //影视评论
    String MOVIE_COMMENT = "comment/praiseandtime/movie/itemId/0";

    //http://v3.wufazhuce.com:8000/api/praise/add?channel=update&source_id=9598&source=summary&version=4.0.7&
    //uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android

    // 点赞
    String MUSIC_PRAISE = "praise/add";
}
