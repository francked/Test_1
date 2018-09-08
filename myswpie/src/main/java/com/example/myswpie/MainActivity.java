package com.example.myswpie;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private List<String> list = new ArrayList<>();
    private SwipeRefreshLayout layout;
    private RecyclerView recyclerView;
    private MyRecyclerView adapter;
    private LinearLayoutManager layoutManager;

    private static final int DROP_DOWN_REFRESH = 0x12;


    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case DROP_DOWN_REFRESH:
                    layout.setRefreshing(false);
                    break;

            }


            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(i));
        }


        recyclerView = findViewById(R.id.recyclerView);
        layout = findViewById(R.id.swipeRefresh);

        layout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));

        adapter = new MyRecyclerView(this,list);
        layoutManager = new LinearLayoutManager(this);

        layout.setSize(SwipeRefreshLayout.LARGE);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        layout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh: ");

                Log.d(TAG, "isRefreshing: " + layout.isRefreshing());

                if (layout.isRefreshing()){
                    handler.sendEmptyMessageDelayed(DROP_DOWN_REFRESH,2000);
                }

//                list.add("下拉刷新出来的item");
//                adapter.notifyDataSetChanged();
               List<String> headDatas = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    headDatas.add("headData Item" + i );
                }
                adapter.AddHeaderItem(headDatas);
            }
        });


        initLoadMoreListener();


        adapter.setOnItemClickListener(new MyRecyclerView.OnItemClickLinstener() {
            @Override
            public void onClick(View view, int position) {
                Log.d(TAG, "onClick: " + list.get(position));
                Log.d(TAG, "onClick: " + position);
                EventBus.getDefault().post(new MessageEvent("我第 " + position +"二次发送事件"));

            }
        });

    }






        private void initLoadMoreListener() {
            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                int lastVisibleItem ;

                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    //判断RecyclerView的状态 是空闲时，同时，是最后一个可见的ITEM时才加载
                    if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {

                        //设置正在加载更多
                        adapter.changeMoreStatus(adapter.LOADING_MORE);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                List<String> footerDatas = new ArrayList<String>();
                                for (int i = 0; i < 10; i++) {

                                    footerDatas.add("footer  item" + i);
                                }
                                adapter.AddFooterItem(footerDatas);
                                //设置回到上拉加载更多
                                adapter.changeMoreStatus(adapter.PULLUP_LOAD_MORE);
                                Toast.makeText(MainActivity.this, "更新了 " + footerDatas.size() + " 条目数据", Toast.LENGTH_SHORT).show();
                            }
                        }, 3000);
                    }
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    //最后一个可见的ITEM
                    lastVisibleItem=layoutManager.findLastVisibleItemPosition();
                }
            });
        }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        EventBus.getDefault().unregister(this);
    }
}
