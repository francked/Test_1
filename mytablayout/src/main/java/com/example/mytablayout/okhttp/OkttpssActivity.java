package com.example.mytablayout.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mytablayout.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkttpssActivity extends AppCompatActivity {
    private static final String TAG = "OkttpssActivity";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okttpss);
        tv = findViewById(R.id.text);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());
        findViewById(R.id.get_bnt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGet();
            }
        });

    }

    private void getGet(){
        Request.Builder requestbuilder = new Request.Builder().url("http://blog.csdn.net/itachi85");
        requestbuilder.method("GET",null);
        Request request = requestbuilder.build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s  = response.body().string();
                Log.d(TAG, "onResponse: " + s);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(s);

                    }
                });
            }
        });
    }
}
