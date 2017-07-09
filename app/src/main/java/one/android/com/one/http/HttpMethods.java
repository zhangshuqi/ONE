package one.android.com.one.http;


import android.util.Log;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import one.android.com.one.api.ApiServer;
import one.android.com.one.api.Url;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class HttpMethods {

    public ApiServer apiService;
    private Retrofit retrofit;


    private static class SingleHttpMethods {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance() {
        return SingleHttpMethods.INSTANCE;
    }

    private HttpMethods() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder .connectTimeout(60, TimeUnit.SECONDS)       //设置连接超时
                .readTimeout(60, TimeUnit.SECONDS)          //设置读超时
                .writeTimeout(60, TimeUnit.SECONDS)          //设置写超时
                .retryOnConnectionFailure(true) ;        //是否自动重连
      //  httpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Url.BASE_URL)
                .client(getOkHttpClient())
                .build();
        apiService = retrofit.create(ApiServer.class);
    }

    private OkHttpClient getOkHttpClient() {
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
               // Log.d("zcb","OkHttp====Message:"+message);
                Log.d("ONE NET =====", message);
            }
        });
        loggingInterceptor.setLevel(level);
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder();
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();
    }
    public RequestBody toTextRequestBody(String s) {
        return RequestBody.create(MediaType.parse("text/plain"), s);
    }

    public RequestBody toImageRequestBody(File file) {
        return RequestBody.create(MediaType.parse("image/jpg"), file);
    }
}
