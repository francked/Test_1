package com.example.mymvp.login.presenter;

import android.content.Context;

import com.example.mymvp.login.model.Imodel;
import com.example.mymvp.login.model.LModel;
import com.example.mymvp.login.view.ILoginView;
import com.example.mymvp.login.view.IRegisterView;
import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 18-8-28.
 */

public class LoginPresenter implements IPresenter {

    private Imodel imodel;
    private ILoginView iView;
    private Context context;

    public LoginPresenter(Context context, ILoginView iView) {
        this.iView = iView;
        this.context = context;
        imodel = new LModel();
    }


    @Override
    public void onDestroy() {
        iView = null;
        System.gc();

    }

    @Override
    public void login() {
        imodel.login(iView.getName(), iView.getPass(), new Imodel.OnLoginListener() {
            @Override
            public void success(String msg) {
                Logger.e("成功");
                iView.success(msg);
            }

            @Override
            public void error(String msg) {
                Logger.e("失败");

                iView.error(msg);
            }
        });
    }


    @Override
    public void register() {

    }
}
