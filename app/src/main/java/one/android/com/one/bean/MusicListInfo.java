package one.android.com.one.bean;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class MusicListInfo  extends BaseObservable{

    /**
     * ad_closetime :
     * ad_id : 0
     * ad_linkurl :
     * ad_makettime :
     * ad_pvurl :
     * ad_pvurl_vendor :
     * ad_share_cnt :
     * ad_type : 0
     * audio_platform : 2
     * audio_url :
     * author : {"desc":"台湾歌手","fans_total":"76","is_settled":"0","settled_type":"0","summary":"台湾歌手","user_id":"7286085","user_name":"张悬","wb_name":"","web_url":"http://image.wufazhuce.com/FuROkfjxzJ1uAlD4l-cSoWpfBioW"}
     * category : 4
     * content_bgcolor : #FFFFFF
     * content_id : 2217
     * content_type : 4
     * display_category : 1
     * forward : 我就是那种双重标准的人，对自己格外严厉，但对喜欢的人呢，我觉得他不管做什么都好。
     * id : 12456
     * img_url : http://image.wufazhuce.com/FhZKDq0NQ4tt-aTxYyh6NjbfTdPr
     * item_id : 2217
     * last_update_date : 2017-07-07 16:16:50
     * like_count : 210
     * movie_story_id : 0
     * number : 0
     * pic_info :
     * post_date : 2017-07-09 19:00:00
     * serial_id : 0
     * serial_list : []
     * share_info : {"content":"","image":"http://image.wufazhuce.com/FhZKDq0NQ4tt-aTxYyh6NjbfTdPr","title":"「一个」音乐: 张悬 喜欢","url":"http://h.xiami.com/one-share.html?id=1795448142"}
     * share_list : {"qq":{"audio":"","desc":"我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=qq","title":"所有人事已非的景色里，我最喜欢你"},"weibo":{"audio":"","desc":"","imgUrl":"","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=weibo","title":"ONE一个《音乐 | 所有人事已非的景色里，我最喜欢你》 文/汤川： 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。 阅读全文：http://h.xiami.com/one-share.html?id=1795448142&channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874"},"wx":{"audio":"","desc":"文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=singlemessage","title":"音乐 | 所有人事已非的景色里，我最喜欢你"},"wx_timeline":{"audio":"","desc":"文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=timeline","title":"音乐 | 所有人事已非的景色里，我最喜欢你"}}
     * share_url : http://h.xiami.com/one-share.html?id=1795448142
     * start_video :
     * subtitle : 专辑:Original
     * tag_list : []
     * title : 所有人事已非的景色里，我最喜欢你
     * video_url :
     * volume : 0
     * words_info :
     */

    public String ad_closetime;
    public int ad_id;
    public String ad_linkurl;
    public String ad_makettime;
    public String ad_pvurl;
    public String ad_pvurl_vendor;
    public String ad_share_cnt;
    public int ad_type;
    public int audio_platform;
    public String audio_url;
    public AuthorBean author;
    public String category;
    public String content_bgcolor;
    public String content_id;
    public String content_type;
    public String display_category;
    public String forward;
    public String id;
    public String img_url;
    public String item_id;
    public String last_update_date;
    public int like_count;
    public int movie_story_id;
    public int number;
    public String pic_info;
    public String post_date;
    public int serial_id;
    public ShareInfoBean share_info;
    public ShareListBean share_list;
    public String share_url;
    public String start_video;
    public String subtitle;
    public String title;
    public String video_url;
    public int volume;
    public String words_info;
    public List<?> serial_list;
    public List<?> tag_list;

    public static class AuthorBean {
        /**
         * desc : 台湾歌手
         * fans_total : 76
         * is_settled : 0
         * settled_type : 0
         * summary : 台湾歌手
         * user_id : 7286085
         * user_name : 张悬
         * wb_name :
         * web_url : http://image.wufazhuce.com/FuROkfjxzJ1uAlD4l-cSoWpfBioW
         */

        public String desc;
        public String fans_total;
        public String is_settled;
        public String settled_type;
        public String summary;
        public String user_id;
        public String user_name;
        public String wb_name;
        public String web_url;
    }

    public static class ShareInfoBean {
        /**
         * content :
         * image : http://image.wufazhuce.com/FhZKDq0NQ4tt-aTxYyh6NjbfTdPr
         * title : 「一个」音乐: 张悬 喜欢
         * url : http://h.xiami.com/one-share.html?id=1795448142
         */

        public String content;
        public String image;
        public String title;
        public String url;
    }

    public static class ShareListBean {
        /**
         * qq : {"audio":"","desc":"我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=qq","title":"所有人事已非的景色里，我最喜欢你"}
         * weibo : {"audio":"","desc":"","imgUrl":"","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=weibo","title":"ONE一个《音乐 | 所有人事已非的景色里，我最喜欢你》 文/汤川： 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。 阅读全文：http://h.xiami.com/one-share.html?id=1795448142&channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874"}
         * wx : {"audio":"","desc":"文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=singlemessage","title":"音乐 | 所有人事已非的景色里，我最喜欢你"}
         * wx_timeline : {"audio":"","desc":"文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。","imgUrl":"http://image.wufazhuce.com/ONE_logo_120_square.png","link":"http://h.xiami.com/one-share.html?id=1795448142&channel=timeline","title":"音乐 | 所有人事已非的景色里，我最喜欢你"}
         */

        public QqBean qq;
        public WeiboBean weibo;
        public WxBean wx;
        public WxTimelineBean wx_timeline;

        public static class QqBean {
            /**
             * audio :
             * desc : 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。
             * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
             * link : http://h.xiami.com/one-share.html?id=1795448142&channel=qq
             * title : 所有人事已非的景色里，我最喜欢你
             */

            public String audio;
            public String desc;
            public String imgUrl;
            public String link;
            public String title;
        }

        public static class WeiboBean {
            /**
             * audio :
             * desc :
             * imgUrl :
             * link : http://h.xiami.com/one-share.html?id=1795448142&channel=weibo
             * title : ONE一个《音乐 | 所有人事已非的景色里，我最喜欢你》 文/汤川： 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。 阅读全文：http://h.xiami.com/one-share.html?id=1795448142&channel=weibo 下载ONE一个APP:http://weibo.com/p/100404157874
             */

            public String audio;
            public String desc;
            public String imgUrl;
            public String link;
            public String title;
        }

        public static class WxBean {
            /**
             * audio :
             * desc : 文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。
             * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
             * link : http://h.xiami.com/one-share.html?id=1795448142&channel=singlemessage
             * title : 音乐 | 所有人事已非的景色里，我最喜欢你
             */

            public String audio;
            public String desc;
            public String imgUrl;
            public String link;
            public String title;
        }

        public static class WxTimelineBean {
            /**
             * audio :
             * desc : 文/汤川 我就是双重标准的人，对自己格外严厉，但对喜欢的人呢，他不管做什么都好。
             * imgUrl : http://image.wufazhuce.com/ONE_logo_120_square.png
             * link : http://h.xiami.com/one-share.html?id=1795448142&channel=timeline
             * title : 音乐 | 所有人事已非的景色里，我最喜欢你
             */

            public String audio;
            public String desc;
            public String imgUrl;
            public String link;
            public String title;
        }
    }
}
