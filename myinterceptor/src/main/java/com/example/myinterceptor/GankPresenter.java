package com.example.myinterceptor;

import com.example.myinterceptor.ToastUtil.LogUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ryan on 18-8-31.
 */

public class GankPresenter {
    private static final String TAG = "GankPresenter";
    //干货类型
    public static final String TYPE_ANDROID = "Android";
    public static final String TYPE_WEB = "前端";
    public static final String TYPE_RECOMMENT = "瞎推荐";
    public static final String TYPE_IOS = "iOS";
    public static final String TYPE_VIDEO = "休息视频";
    public static final String TYPE_MEIZI = "福利";
    public static final String TYPE_APP = "App";
    public static final String TYPE_OTHER = "拓展资源";

    //默认每次只能加载 10个数据

    private static final int DEFAULT_LOAD_COUNTS = 10;

    private static Gson sGson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:SS")
            .serializeNulls()
            .create();

    private static GankApi getGankApi(){
        return GankSingletion.mInstance;
    }

    public static void getSpecifyGanHuo(final String type, int page , final RetorfitListener<List<GanHuo>> callback){
        getGankApi().getGanHuo(type,DEFAULT_LOAD_COUNTS,page).enqueue(new Callback<GankResEntity>() {
            @Override
            public void onResponse(Call<GankResEntity> call, Response<GankResEntity> response) {
                if (response.isSuccessful()){
                    LogUtils.d(TAG, type + "干货下载成功： " + response.body().toString());
                    Object results = response.body().getResults();
                    Type t = new TypeToken<List<GanHuo>>() {
                    }.getType();
                    List<GanHuo> data = sGson.fromJson(sGson.toJson(results), t);
                    callback.onSuccess(data);
                }else {
                    LogUtils.e(TAG, type + "干货下载失败，code： " + response.code());
                    callback.onError("请求失败，code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<GankResEntity> call, Throwable t) {
                LogUtils.e(TAG,type + "干货下载失败", t);
                callback.onError(t.getMessage());

            }
        });
    }

    private static class GankSingletion{
        private static GankApi mInstance = RetrofitHelper.newRetorfit(BuildConfig.GANK_SERVICE).create(GankApi.class);
    }

}
