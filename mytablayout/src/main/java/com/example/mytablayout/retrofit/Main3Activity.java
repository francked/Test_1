package com.example.mytablayout.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.mytablayout.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {
    private static final String TAG = "Main3Activity";
    private List<Integer> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //Logger.addLogAdapter(new AndroidLogAdapter());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("豆瓣文学");
        findViewById(R.id.retrofit_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://gank.io/";

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IService iService = retrofit.create(IService.class);

                Call<GanHuo> call = iService.getToDay();

                call.enqueue(new Callback<GanHuo>() {
                    @Override
                    public void onResponse(Call<GanHuo> call, Response<GanHuo> response) {

                        String s = response.body().toString();
                        Logger.d(TAG, "onResponse: ");
                        Logger.i(s, "onResponse: ");

                    }

                    @Override
                    public void onFailure(Call<GanHuo> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+ t.getMessage());
                    }
                });
            }
        });

        findViewById(R.id.retrofit_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://fy.iciba.com/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IService iService = retrofit.create(IService.class);
                Call<Translation> call = iService.getCall();
                call.enqueue(new Callback<Translation>() {
                    @Override
                    public void onResponse(Call<Translation> call, Response<Translation> response) {
                        String s = response.body().getContent().toString();

                        Logger.i(s,"retrofit_2");


                    }

                    @Override
                    public void onFailure(Call<Translation> call, Throwable t) {

                    }
                });



            }
        });
        findViewById(R.id.retrofit_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = "1000001";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.douban.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IService service = retrofit.create(IService.class);

                Call<DouBan> call = service.getDuoBan(id);
                call.enqueue(new Callback<DouBan>() {
                    @Override
                    public void onResponse(Call<DouBan> call, Response<DouBan> response) {
                        DouBan douBan = response.body();
                        Logger.e(douBan.getImages().getLarge(),"");



                    }

                    @Override
                    public void onFailure(Call<DouBan> call, Throwable t) {

                    }
                });

            }
        });

    //显示豆瓣 列表
        showDouBan();



    }

    private void showDouBan() {

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        RecyclerView recyclerView = findViewById(R.id.recycler_view_dou_ban);
        DouBanAdapter adapter = new DouBanAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

    }


}
