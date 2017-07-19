package one.android.com.one.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import one.android.com.one.moudel.main.activity.MainActivity;

/**
 * Created by Administrator on 2017/7/20 0020.
 */

public class IntentUtils {
    public static  void toMainActivity(AppCompatActivity appCompatActivity ){
        Intent intent = new Intent(appCompatActivity,MainActivity.class);
        appCompatActivity.startActivity(intent);
    }
}
