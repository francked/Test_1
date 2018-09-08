package com.example.mymvp.content.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.example.mymvp.content.RetrofitListener;
import com.example.mymvp.content.util.GanHuoEntity;
import com.example.mymvp.content.util.GankController;
import com.example.mymvp.content.util.LogUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by dasu on 2017/4/21.
 *
 * CategoryFragment对应的Controller
 */

public class CategoryFController {

    private static final String TAG = CategoryFController.class.getSimpleName();

    private Context mContext;
    private CategroyFragment mCategoryFragment;
    private String mCategoryType;

    public CategoryFController(Fragment fragment) {
        if (!(fragment instanceof CategroyFragment)) {
            LogUtils.e(TAG, TAG + "绑定错误的Fragment");
            throw new UnsupportedOperationException(TAG + "绑定错误的Fragment");
        }
        mContext = fragment.getContext();
        mCategoryFragment = (CategroyFragment) fragment;
        mCategoryType = mCategoryFragment.getCategoryType();
        if (TextUtils.isEmpty(mCategoryType)) {
            LogUtils.e(TAG, "CategoryFragment 必须实现ICategoryType接口，指定返回某一type类型");
            throw new UnsupportedOperationException("CategoryFragment 必须实现ICategoryType接口，指定返回某一type类型");
        }
    }

    public void loadBaseData() {
        mCategoryPage = 1;
        GankController.getSpecifyGanHuo(mCategoryType, 1, new RetrofitListener<List<GanHuoEntity>>() {
            @Override
            public void onSuccess(List<GanHuoEntity> data) {
                mCategoryFragment.updateGanHuo(data);
                Logger.e(data.toString());
            }

            @Override
            public void onError(String description) {
                mCategoryFragment.onLoadFailed();
            }
        });
    }

    private static final int STATE_REFRESH_END = 1;
    private static final int STATE_REFRESHING = 2;

    private int mRefreshState = STATE_REFRESH_END;
    private int mCategoryPage = 1;

    public void startPullUpRefresh() {
        if (mRefreshState == STATE_REFRESHING) {
            return;
        }
        mRefreshState = STATE_REFRESHING;
        GankController.getSpecifyGanHuo(mCategoryType, ++mCategoryPage, new RetrofitListener<List<GanHuoEntity>>() {
            @Override
            public void onSuccess(List<GanHuoEntity> data) {
                mRefreshState = STATE_REFRESH_END;
                if (data != null && data.size() > 0) {
                    mCategoryFragment.refreshData(data);
                } else {
                    mCategoryFragment.onLoadFailed();
                }
            }

            @Override
            public void onError(String description) {
                mRefreshState = STATE_REFRESH_END;
                mCategoryFragment.onLoadFailed();
            }
        });
    }

}
