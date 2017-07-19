package one.android.com.one.utils;

import com.alibaba.fastjson.JSONArray;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class SPControler {
   public static class DayId {
        public static List<String> getDayIdList() {
            String dayIdString = SPUtils.getString("DayId", "");
            List<String> dayIdList = JSONArray.parseArray(dayIdString, String.class);
            return dayIdList;
        }

        public static void saveDayIdList(String data) {
            Logger.d(data);
            SPUtils.putString("DayId", data);
        }
    }
}
