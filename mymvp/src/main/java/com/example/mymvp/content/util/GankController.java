package com.example.mymvp.content.util;

import com.example.mymvp.BuildConfig;
import com.example.mymvp.content.GankApi;
import com.example.mymvp.content.RetrofitListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ryan on 18-8-30.
 */

public class GankController {
    private static final String TAG = "GankController";
    public static final String TYPE_ANDROID = "Android";
    public static final String TYPE_WEB = "前端";
    public static final String TYPE_RECOMMENT = "瞎推荐";
    public static final String TYPE_IOS = "iOS";
    public static final String TYPE_APP = "App";
    public static final String TYPE_OTHER = "拓展资源";


    //默认每次只加载10个数据
    private static final int DEFAULT_LOAD_COUNTS = 10;

    private static Gson sGson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:SS")
            .serializeNulls()
            .create();

    private static GankApi getGankApi(){
        return GankApiSingleton.mInstance;
    }

    private static class GankApiSingleton{
        private static GankApi mInstance = RetrofitHelper.newRetrofit(BuildConfig.GANK_SERVICE).create(GankApi.class);
    }

    public static void getSpecifyGanHuo(final String type, int page, final RetrofitListener<List<GanHuoEntity>> callback){


        getGankApi().getSpecifyGanHuo(type,DEFAULT_LOAD_COUNTS,page).enqueue(new Callback<GanHuo>() {
            @Override
            public void onResponse(Call<GanHuo> call, Response<GanHuo> response) {
                if (response.isSuccessful()){
                    LogUtils.d(TAG, type + "干货下载成功： " + response.body().toString());
                    Object results = response.body().getResults();
                    Type t = new TypeToken<List<GanHuoEntity>>() {}.getType();
                    List<GanHuoEntity> data = sGson.fromJson(sGson.toJson(results), t);
                    callback.onSuccess(data);
                }
            }

            @Override
            public void onFailure(Call<GanHuo> call, Throwable t) {
                LogUtils.e(TAG,type + "干货下载失败", t);
                callback.onError(t.getMessage());
            }
        });
    }

}


