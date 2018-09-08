package com.example.myinterceptor;

import android.text.TextUtils;
import android.util.Log;

import com.example.myinterceptor.ToastUtil.LogUtils;
import com.example.myinterceptor.ToastUtil.NetworkUtils;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ryan on 18-8-31.
 */

public class OkHttpProvider {
    private static final String TAG = "OkHttpProvider";
    //最大连接时间
    private static final long  DEFAULT_CONNECT_TIMEOUT = 10;
    private static final long DEFAULT_WRITE_TIMEOUT = 15;
    private static final long DEFAULT_READ_TIMEOUT = 15;

    public static OkHttpClient getCacheOkHttpClient(){
        return getOkHttpClient(new CacheControlInterceptor());
    }
    private static OkHttpClient getOkHttpClient(Interceptor cacheControl){
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS);
        //设置缓存
        File httpCacheDirectory = new File(FileUtil.getAppRootDirectoryPath(),"OkHttpCache");
        httpClientBuilder.cache(new Cache(httpCacheDirectory,100*1024*1024));
        //设置拦截器
        httpClientBuilder.addInterceptor(new LoggingInterceptor());
        httpClientBuilder.addInterceptor(cacheControl);
        return httpClientBuilder.build();
    }
    /**
     * 没有网络的情况下就从缓存中取
     * 有网络的情况则从网络获取
     */
    private static class CacheControlInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();

            if (!NetworkUtils.isConnected(GankAppcation.getmInstance())){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (NetworkUtils.isConnected(GankAppcation.getmInstance())){
                int maxAge = 60 * 60 * 2;//默认缓存2个小时
                String cacheControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(cacheControl)){
                    cacheControl = "public,max-age=" + maxAge;
                }
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control",cacheControl)
                        .build();
             }else {
                int maxStale = 60 * 60  * 24 * 30;
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public,only-is-cached, max-stale="+maxStale)
                        .build();
            }
            return response;
        }
    }


    private static class LoggingInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();

            LogUtils.d(TAG,String.format(Locale.CHINA,"发送 request %s on %s%n%s",request.url(),chain.connection(),request.headers()));
            Response response = chain.proceed(request);
            long t2 = System.nanoTime();
            LogUtils.d(TAG, String.format(Locale.CHINA, "收到 response for %s in %.1fms ，数据来自%s%n",
                    response.request().url(), (t2 - t1) / 1e6d, (response.cacheResponse() != null ? "缓存" : "网络")));
            Log.d(TAG, "intercept: "+ response.cacheResponse());
            return response;
        }
    }
}
