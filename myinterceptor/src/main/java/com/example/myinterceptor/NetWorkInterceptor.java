package com.example.myinterceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ryan on 18-9-1.
 */

public class NetWorkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        //无论有没有网路 都添加缓存

        Request request = chain.request();
        Response response = chain.proceed(request);

        int maxAge = 60;




        return response.newBuilder()
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                .addHeader("name","shone")
                .header("Cache-Control","public,max-age="+ maxAge)
                .build();
    }
}
