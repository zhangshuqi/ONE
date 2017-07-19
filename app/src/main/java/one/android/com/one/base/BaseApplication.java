package one.android.com.one.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/7/10 0010.
 */

public class BaseApplication extends Application {
    public static final boolean DEBUG = true;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context =getApplicationContext();
        initLogger();
        Logger.d("----------------------------"+context);
    }

    private void initLogger() {
        if (DEBUG) {
            Logger.init("ONE")         // default PRETTYLOGGER or use just init()
                    .methodCount(4)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.FULL);      // default LogLevel.FULL
        } else {
            Logger.init("ONE")         // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.NONE);      // default LogLevel.FULL
        }
    }
}
