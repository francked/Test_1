package com.example.mymvp.content;

import com.example.mymvp.content.util.GanHuo;
import com.example.mymvp.content.util.GanHuoEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ryan on 18-8-29.
 */

public interface GankApi {


    /**
     * 获取指定类型数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     */

    @GET("data/{type}/{count}/{pageNum}")
    Call<GanHuo> getSpecifyGanHuo(
                                @Path("type")String type,
                                @Path("count") int count,
                                @Path("pageNum") int pageNum
    );

}

