package com.example.mymvp.content.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymvp.R;
import com.example.mymvp.content.BaseFragment;
import com.example.mymvp.content.MyRecyclerView;
import com.example.mymvp.content.RetrofitListener;
import com.example.mymvp.content.recyclerview.LoadMoreRecycleAdapter;
import com.example.mymvp.content.recyclerview.LoadMoreRecyclerView;
import com.example.mymvp.content.util.CategoryAController;
import com.example.mymvp.content.util.GanHuoEntity;
import com.example.mymvp.content.util.GankController;
import com.example.mymvp.content.util.ToastUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-8-30.
 */

public class CategroyFragment extends BaseFragment implements ICategoryController {

    private static final String TAG = "CategroyFragment";
    private Context mContext;
    private List<GanHuoEntity> mGanHuoList = new ArrayList<>();

    //刷新的状态
    private static final int STATE_REFRESHING = 1;
    private static final int STATE_REFRESH_FINISH = 2;
    private int mRefreshState = STATE_REFRESH_FINISH;

    private CategoryFController mCategoryController;
    private OnSwipeRefreshListener mRefreshListener;
    private CategoryRecycleAdapter adapter;

    public CategroyFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnSwipeRefreshListener) {
            mRefreshListener = (OnSwipeRefreshListener) context;
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        initView(view);
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    public CategroyFragment setArguments(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("_type", type);
        setArguments(bundle);
        return this;
    }

    private void initView(View view){
        LoadMoreRecyclerView recyclerView = view.findViewById(R.id.rv_category_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        recyclerView.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL));
        Log.d(TAG, "initView: " + mGanHuoList.toString());
        adapter = new CategoryRecycleAdapter(mGanHuoList);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnPullUpRefreshListener(onPullUpRefresh());
    }


    @Override
    public String getCategoryType() {
        Bundle bundle = getArguments();
        return bundle.getString("_type", "");
    }


    private void notifyDataSetChanged() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
    @Override
    public void updateGanHuo(List<GanHuoEntity> data) {
        mRefreshState = STATE_REFRESH_FINISH;
        mRefreshListener.onRefreshFinish();
        if (data == null || data.size() == 0) {
            return;
        }
        if (mGanHuoList == null) {
            mGanHuoList = new ArrayList<>();
        }
        mGanHuoList.clear();
        mGanHuoList.addAll(data);
        Log.d(TAG, "updateGanHuo: " + mGanHuoList.toString());
        if (isFragmentVisible()) {
            Log.d(TAG, "isFragmentVisible: " + isFragmentVisible());
            notifyDataSetChanged();
        }
    }





    private OnPullUpRefreshListener onPullUpRefresh() {
        return new OnPullUpRefreshListener() {
            @Override
            public void onPullUpRefresh() {
                //正在刷新的话，就不加载下拉刷新了
                if (mRefreshState == STATE_REFRESHING) {
                    return;
                }
                mRefreshState = STATE_REFRESHING;
                mRefreshListener.onRefreshing();
                mCategoryController.startPullUpRefresh();
            }
        };
    }

    public void refreshData(List<GanHuoEntity> data) {
        mRefreshState = STATE_REFRESH_FINISH;
        mRefreshListener.onRefreshFinish();
        if (mGanHuoList == null) {
            mGanHuoList = new ArrayList<>();
        }
        int oldSize = mGanHuoList.size();
        mGanHuoList.addAll(data);
        adapter.notifyItemRangeInserted(oldSize, data.size());
        ToastUtils.show(mContext, "加载成功，新增" + data.size() + "项干货哦！");
    }

    @Override
    public void onLoadFailed() {
        ToastUtils.show(mContext, "数据加载失败，请重试");
    }


    @Override
    protected void onFragmentFirstVisible() {
        mCategoryController = new CategoryFController(this);
        mRefreshState = STATE_REFRESHING;
        Logger.e("onFragmentFirstVisible");
        mCategoryController.loadBaseData();
    }


    /**
     * 重新加载数据
     */
    public void retryLoadData() {
        mRefreshState = STATE_REFRESHING;
        mCategoryController.loadBaseData();
    }
}
