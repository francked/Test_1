package com.example.mytablayout.volley;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mytablayout.R;

public class VolleyssActivity extends AppCompatActivity {
    private static final String TAG = "VolleyssActivity";
    private TextView volley_text;
    private Button button;
    private ImageView volley_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        button = findViewById(R.id.volley_bnt);
        volley_text = findViewById(R.id.volley_text);
        volley_image = findViewById(R.id.volley_image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //volleyGet();
                //volleyImage();
                volleyImageloader();
            }
        });

    }

    //volley GET 百度

    public void volleyGet(){
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
                volley_text.setText(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.getMessage());
            }
        });

        mQueue.add(stringRequest);
    }


    //图片

    public void volleyImage(){
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());
        ImageRequest imageRequest = new ImageRequest("https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                volley_image.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volley_image.setImageResource(R.drawable.mao);
            }
        }

        );
        mQueue.add(imageRequest);
    }

    //加载图片
    public void volleyImageloader(){
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        ImageLoader imageLoader = new ImageLoader(mQueue,new LruImageCache());

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(volley_image,R.drawable.mao,R.drawable.mao);

        imageLoader.get("https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg",listener);


    }




}
