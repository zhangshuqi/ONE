package one.android.com.one.utils;

import android.content.SharedPreferences;

import com.orhanobut.logger.Logger;

import one.android.com.one.base.BaseApplication;

/**
 * SharedPreferences 工具类
 * Created by 刘晓彬 on 2017/3/19.
 */

public class SPUtils {



    private static SharedPreferences getSP() {
        Logger.d("----------------------------"+UIUtils. getContext());
        return UIUtils. getContext().getSharedPreferences(
               "TheOneSpData",  BaseApplication.MODE_PRIVATE);
    }


    public static void putString(String key, String value) {
        SharedPreferences.Editor editor = getSP().edit();
        editor.putString(key, value);
        editor.apply();
    }


    public static void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = getSP().edit();
        editor.putBoolean(key, value);
        editor.apply();
    }


    public static void putInt(String key, int value) {
        SharedPreferences.Editor editor = getSP().edit();
        editor.putInt(key, value);
        editor.apply();
    }


    public static String getString(String key, String defValue) {
        return getSP().getString(key, defValue);
    }


    public static boolean getBoolean(String key, boolean defValue) {
        return getSP().getBoolean(key, defValue);
    }


    public static int getInt(String key, int defValue) {
        return getSP().getInt(key, defValue);
    }
}
