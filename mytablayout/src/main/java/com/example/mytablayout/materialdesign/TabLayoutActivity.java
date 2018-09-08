package com.example.mytablayout.materialdesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mytablayout.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private static final String TAG = "TabLayoutActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.dl_main_drawer);
        viewPager = findViewById(R.id.viewpager);
        NavigationView navigationView = findViewById(R.id.nv_main_navigation);
        if (navigationView != null){
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   // item.setChecked(true);
                    //String title = item.getTitle().toString();
                    //Toast.makeText(TabLayoutActivity.this, title, Toast.LENGTH_SHORT).show();
                    //关闭导航栏
                    switch (item.getItemId()){
                        case R.id.nav_discussion:
                            Toast.makeText(TabLayoutActivity.this, "你点击了消息", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TabLayoutActivity.this,CoordinatorActivity.class));
                            break;
                        case R.id.nav_friends:
                            Toast.makeText(TabLayoutActivity.this, "你点击了音乐", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TabLayoutActivity.this,CollpsingToolbarActivity.class));
                            break;
                    }
                    drawerLayout.closeDrawers();

                    return true;
                }
            });
        }
        initViewpager();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViewpager() {
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
