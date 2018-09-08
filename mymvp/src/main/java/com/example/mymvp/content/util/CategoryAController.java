package com.example.mymvp.content.util;

import android.content.Context;
import android.util.Log;

import com.example.mymvp.content.ContentActivity;
import com.example.mymvp.content.RetrofitListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-8-30.
 */

public class CategoryAController {
    private static final String TAG = "CategoryAController";

    private Context mContext;
    private ContentActivity mContentActivity;

    private List<String> mCategoryList;

    public CategoryAController(Context context) {

        if (!(context instanceof ContentActivity)){
            Log.d(TAG, "绑定错误的Activity");
        }
        mContext = context;
        mContentActivity = (ContentActivity) context;
        initVariable();
    }

    private void initVariable() {

        mCategoryList = new ArrayList<>();
        mCategoryList.add(GankController.TYPE_ANDROID);
        mCategoryList.add(GankController.TYPE_IOS);
        mCategoryList.add(GankController.TYPE_APP);
        mCategoryList.add(GankController.TYPE_WEB);
        mCategoryList.add(GankController.TYPE_RECOMMENT);
        mCategoryList.add(GankController.TYPE_OTHER);
    }
    public List<String> getCategoryList() {
        if (mCategoryList == null) {
            mCategoryList = new ArrayList<>();
        }
        return mCategoryList;
    }

}
