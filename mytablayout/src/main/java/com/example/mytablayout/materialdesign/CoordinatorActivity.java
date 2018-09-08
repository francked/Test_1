package com.example.mytablayout.materialdesign;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.mytablayout.R;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private static final String TAG = "CoordinatorActivity";
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewpager);

        FloatingActionButton floatingActionButton = findViewById(R.id.checkin);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"点击成功",Snackbar.LENGTH_SHORT).show();

            }
        });


        initViewPager();

    }

    private void initViewPager() {
        tabLayout = findViewById(R.id.tabs);

        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("巴萨");
        titles.add("购物");
        titles.add("明星");
        titles.add("视频");
        titles.add("健康");
        titles.add("励志");
        titles.add("图文");
        titles.add("本地");
        titles.add("动漫");
        titles.add("搞笑");
        titles.add("精选");
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            Log.d(TAG, "titles: ");
            fragments.add(new ListFragment());

            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }


//        for (int i = 0; i < titles.size(); i++) {
//            Log.d(TAG, "fragments: ");
//        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager() , fragments , titles);

        viewPager.setAdapter(fragmentAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);

    }

}
