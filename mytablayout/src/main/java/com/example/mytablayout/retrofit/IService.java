package com.example.mytablayout.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ryan on 18-8-21.
 */

public interface IService {

    @GET("api/today")
    Call<GanHuo> getToDay();

    @GET("ajax.php?a=fy&f=auto&t=auto&w=你好")
    Call<Translation> getCall();

    @GET("v2/book/{id}")
    Call<DouBan> getDuoBan(@Path("id") String id);
}
