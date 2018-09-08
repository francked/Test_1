package com.example.myinterceptor;

/**
 * Created by ryan on 18-8-31.
 */

public interface RetorfitListener<T> {
    //成功是回调
    void onSuccess(T data);


    //失败时 回调
    void onError(String description);
}
