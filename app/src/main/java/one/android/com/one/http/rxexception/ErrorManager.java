package one.android.com.one.http.rxexception;


import java.net.ConnectException;
import java.net.SocketTimeoutException;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class ErrorManager {

    public static void setCode(int code) {
        ErrorManager.code = code;
    }

    private static int code=0;

    public ErrorManager() {
    }

    /**
     * 对错误数据进行处理，返回对应字符串提示信息
     *
     * @param e 错误数据接口
     * @return 返回对应错误提示信息
     */
    public static String handleError(ErrorBundle e) {
        e.getException().printStackTrace();
        String message;
       // if (!NetUtils.isNetworkConnected()) {
        if (!true) {
            message = "网络错误";
        } else if (e.getException() instanceof SocketTimeoutException) {
            message =   "服务器异常";
        } else if (e.getException() instanceof ConnectException) {
            message = "连接异常";
        } else if (e.getException() instanceof NetworkConnectionException) {
            message = "网络异常";
        } else if (e.getException() instanceof ServerException) {
            code = ((ServerException) e.getException()).getCode();
            //在这里你可以获取code来判断是什么类型，进行相应处理，比如token失效了可以实现跳转到登录页面
            message = e.getMessage();

        } else {
            message = "未知错误";
        }
        return message;
    }
}
