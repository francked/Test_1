package com.example.mytablayout.viewpager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytablayout.R;
import com.example.mytablayout.viewpager.fragment.Fragment1;
import com.example.mytablayout.viewpager.fragment.Fragment2;
import com.example.mytablayout.viewpager.fragment.Fragment3;
import com.example.mytablayout.viewpager.fragment.Fragment4;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {
    List<Fragment> fragments = new ArrayList<>();
    private static final String TAG = "ViewPagerActivity";
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ViewPager viewPager;
    private int p = 1;
    private static final int ONE = 1;
    private int position_1 = 1;
    private boolean flag = true;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case ONE:
                    if (position_1 < 5){
                        viewPager.setCurrentItem(position_1,false);
                        position_1++;
                    }else {
                        position_1 = 1;
                        viewPager.setCurrentItem(position_1,false);
                        position_1++;
                    }
                    break;
                default:
                    break;
            }
        }
    };
    private ImageView oneCircle;
    private ImageView twoCircle;
    private ImageView threeCircle;
    private ImageView fourCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initView();
        fragments.add(new Fragment4());
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment1());

        //设置起始位置
        position_1 = 1;

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(position_1);
        tv1.setBackgroundColor(Color.RED);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d(TAG, "onPageScrolled: ");
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
                position_1 = position;
                if (position_1 == fragments.size() - 1){
                    //如果滑动到最后一个，和第一张相同时，就设置当前值为1
                    position_1 = 1;
                    tv1.setBackgroundColor(Color.RED);
                    tv2.setBackgroundColor(Color.WHITE);
                    tv3.setBackgroundColor(Color.WHITE);
                    tv4.setBackgroundColor(Color.WHITE);

                }else if (position_1 == 0){
                    position_1 = fragments.size() -2;
                    tv1.setBackgroundColor(Color.WHITE);
                    tv2.setBackgroundColor(Color.WHITE);
                    tv3.setBackgroundColor(Color.WHITE);
                    tv4.setBackgroundColor(Color.RED);
                }else {
                    position_1 = position;
                    switch (position_1){
                        case 1:
                            tv1.setBackgroundColor(Color.RED);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv3.setBackgroundColor(Color.WHITE);
                            tv4.setBackgroundColor(Color.WHITE);
                            oneCircle.setBackgroundResource(R.drawable.bigcircle);
                            twoCircle.setBackgroundResource(R.drawable.smallcircle);
                            threeCircle.setBackgroundResource(R.drawable.smallcircle);
                            fourCircle.setBackgroundResource(R.drawable.smallcircle);
                            break;
                        case 2:
                            tv1.setBackgroundColor(Color.WHITE);
                            tv2.setBackgroundColor(Color.RED);
                            tv3.setBackgroundColor(Color.WHITE);
                            tv4.setBackgroundColor(Color.WHITE);

                            oneCircle.setBackgroundResource(R.drawable.smallcircle);
                            twoCircle.setBackgroundResource(R.drawable.bigcircle);
                            threeCircle.setBackgroundResource(R.drawable.smallcircle);
                            fourCircle.setBackgroundResource(R.drawable.smallcircle);
                            break;
                        case 3:
                            tv1.setBackgroundColor(Color.WHITE);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv3.setBackgroundColor(Color.RED);
                            tv4.setBackgroundColor(Color.WHITE);
                            oneCircle.setBackgroundResource(R.drawable.smallcircle);
                            twoCircle.setBackgroundResource(R.drawable.smallcircle);
                            threeCircle.setBackgroundResource(R.drawable.bigcircle);
                            fourCircle.setBackgroundResource(R.drawable.smallcircle);
                            break;
                        case 4:
                            tv1.setBackgroundColor(Color.WHITE);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv3.setBackgroundColor(Color.WHITE);
                            tv4.setBackgroundColor(Color.RED);

                            oneCircle.setBackgroundResource(R.drawable.smallcircle);
                            twoCircle.setBackgroundResource(R.drawable.smallcircle);
                            threeCircle.setBackgroundResource(R.drawable.smallcircle);
                            fourCircle.setBackgroundResource(R.drawable.bigcircle);
                            break;
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d(TAG, "onPageScrollStateChanged: ");
                if (state == ViewPager.SCROLL_STATE_IDLE){
                    viewPager.setCurrentItem(position_1,false);
                }
            }
        });

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                while (flag) {
                    try {
                        Thread.sleep(500);
                        Message message = new Message();
                        message.what = ONE;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        timer.schedule(timerTask,0);


    }

    private void initView() {

        //TextView 控件
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        //圆形控件
        oneCircle = findViewById(R.id.one_circle);
        twoCircle = findViewById(R.id.two_circle);
        threeCircle = findViewById(R.id.three_circle);
        fourCircle = findViewById(R.id.four_circle);


        viewPager = findViewById(R.id.viewpager);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                viewPager.setCurrentItem(1);
                tv1.setBackgroundColor(Color.RED);
                tv2.setBackgroundColor(Color.WHITE);
                tv3.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.WHITE);
                Log.d(TAG, "onClick: tv1");
                break;
            case R.id.tv2:
                viewPager.setCurrentItem(2);
                tv1.setBackgroundColor(Color.WHITE);
                tv2.setBackgroundColor(Color.RED);
                tv3.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.WHITE);
                Log.d(TAG, "onClick: tv2");

                break;
            case R.id.tv3:
                viewPager.setCurrentItem(3);
                tv1.setBackgroundColor(Color.WHITE);
                tv2.setBackgroundColor(Color.WHITE);
                tv3.setBackgroundColor(Color.RED);
                tv4.setBackgroundColor(Color.WHITE);
                Log.d(TAG, "onClick: tv3");
                break;
            case R.id.tv4:
                viewPager.setCurrentItem(4);
                tv1.setBackgroundColor(Color.WHITE);
                tv2.setBackgroundColor(Color.WHITE);
                tv3.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.RED);
                Log.d(TAG, "onClick: tv4");

                break;

        }
    }



}
