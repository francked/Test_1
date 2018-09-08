package com.example.mymvp.presenter;

import com.example.mymvp.model.IMainModel;
import com.example.mymvp.model.MainModelImpl;
import com.example.mymvp.view.IMainView;

/**
 * Created by ryan on 18-8-28.
 */

public class MainPresenter implements IMainPresenter {

    private IMainModel iMainModel;
    private IMainView iMainView;

    public MainPresenter( IMainView iMainView) {
        iMainModel = new MainModelImpl();
        this.iMainView = iMainView;
    }

    @Override
    public void fetch() {
        iMainView.showLoading();
        iMainModel.loadData(new IMainModel.OnLoadCompleteListener() {
            @Override
            public void onComplete(String data) {
                iMainView.showData(data);
            }
        });
    }


    @Override
    public void onDestroy() {
        iMainView = null;
        System.gc();
    }
}
