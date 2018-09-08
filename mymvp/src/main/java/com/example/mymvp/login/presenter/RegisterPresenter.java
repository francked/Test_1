package com.example.mymvp.login.presenter;

import android.content.Context;

import com.example.mymvp.TextAppcation;
import com.example.mymvp.login.greendao.UserDao;
import com.example.mymvp.login.model.Imodel;
import com.example.mymvp.login.model.LModel;
import com.example.mymvp.login.view.IRegisterView;
import com.orhanobut.logger.Logger;


/**
 * Created by ryan on 18-8-29.
 */

public class RegisterPresenter implements IPresenter {

    private Imodel imodel;
    private IRegisterView iRegisterView;
    private Context context;


    public RegisterPresenter(IRegisterView iRegisterView, Context context) {
        this.iRegisterView = iRegisterView;
        this.context = context;
        imodel = new LModel();
    }

    @Override
    public void onDestroy() {
        iRegisterView = null;
        System.gc();
    }

    @Override
    public void login() {

    }

    @Override
    public void register() {
        imodel.register(iRegisterView.getName(), iRegisterView.getPass(),iRegisterView.age(), new Imodel.OnRegisterListener() {
            @Override
            public void success(String msg) {
                Logger.e("成功");
                iRegisterView.success(msg);
            }

            @Override
            public void error(String msg) {
                Logger.e("失败");

                iRegisterView.error(msg);
            }
        });
    }
}
