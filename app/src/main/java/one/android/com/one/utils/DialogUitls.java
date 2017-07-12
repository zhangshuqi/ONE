package one.android.com.one.utils;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by Administrator on 2017/7/12 0012.
 */

public class DialogUitls {
    public static ProgressDialog showProgressDialog(Activity activity, String text) {
        ProgressDialog loginDialog = new ProgressDialog(activity);
        loginDialog.setMessage(text);
        return loginDialog;
    }
}
