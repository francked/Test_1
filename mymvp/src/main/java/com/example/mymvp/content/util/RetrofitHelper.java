package com.example.mymvp.content.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ryan on 18-8-30.
 */

public class RetrofitHelper {
    private static final String TAG = "RetrofitHelper";

    private static OkHttpClient mOkHttpClient;

    private static Gson mGson;

    private static void init(){
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .serializeNulls()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = OkHttpProvider.getCacheOkHttpClient();
    }

    static Retrofit newRetrofit(String baseUrl){
        if (mOkHttpClient == null || mGson == null){
            init();
        }
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .build();
    }

}
