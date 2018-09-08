package com.example.myinterceptor;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.myinterceptor.ToastUtil.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class MeiZhiActivity extends AppCompatActivity {
    private static final String TAG = "MeiZhiActivity";
    List<GanHuo> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private Meizhi_1Adapter adapter;
    private SwipeRefreshLayout refreshLayout;

    int page = 1;
    private StaggeredGridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mei_zhi);
        initView();


    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        adapter = new Meizhi_1Adapter(this,list);
        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);


        refreshLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorAccent,R.color.colorPrimaryDark);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: " + refreshLayout.isRefreshing());

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        update();
                        refreshLayout.setRefreshing(false);

                    }
                },2000);


            }


        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        ininLastFoot();
    }

    public void update(){
        GankPresenter.getSpecifyGanHuo("福利", ++page, new RetorfitListener<List<GanHuo>>() {
            @Override
            public void onSuccess(List<GanHuo> data) {
                list.addAll(data);
                Log.d(TAG, "onSuccess: " + list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String description) {
                Log.d(TAG, "onError: ");
            }
        });
        ToastUtil.show(this,"更新了数据");
    }


    private void ininLastFoot(){
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int LastvisibleItem;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == recyclerView.SCROLL_STATE_IDLE && LastvisibleItem + 1 == adapter.getItemCount()){
                    adapter.setLoadStatus(Meizhi_1Adapter.LoadStatus.LOADING_MORE);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                                Log.d(TAG, "run: 上啦");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int[] into = layoutManager.findLastVisibleItemPositions(null);
                LastvisibleItem = -1;
                for (int v : into) {
                    if (LastvisibleItem < v) {
                        LastvisibleItem = v;
                    }
                }



            }
        });
    }

}
