package com.example.myinterceptor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ryan on 18-8-31.
 */

public interface GankApi {
    @GET("data/{type}/{count}/{page}")
    Call<GankResEntity> getGanHuo(@Path("type") String type,
                           @Path("count") int count,
                           @Path("page") int page);
}
