package com.example.mymvp.content;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mymvp.R;
import com.example.mymvp.content.fragment.CategroyFragment;
import com.example.mymvp.content.fragment.OnSwipeRefreshListener;
import com.example.mymvp.content.util.CategoryAController;


public class ContentActivity extends AppCompatActivity implements OnSwipeRefreshListener {

    private ViewPager viewPager;
    private static final String TAG = "ContentActivity";
    private Toolbar toolbar;
    private TabLayout tabLayout;

    private CategoryAController categoryAController;
    private FragmentAdapter fragmentAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initVariable();
        initView();
        initViewPager();
    }

    private void initVariable() {
        categoryAController = new CategoryAController(this);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), categoryAController.getCategoryList());
    }


    private void initView() {
        viewPager = findViewById(R.id.viewpager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabs);
        swipeRefreshLayout = findViewById(R.id.layout_category_content);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.colorPrimary));
        swipeRefreshLayout.setOnRefreshListener(onPullDownRefresh());
    }

    private SwipeRefreshLayout.OnRefreshListener onPullDownRefresh() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCurRefreshFragment().retryLoadData();
            }
        };
    }

    private void initViewPager() {
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        getCurRefreshFragment();
    }

    private CategroyFragment getCurRefreshFragment() {
        return (CategroyFragment) fragmentAdapter.getmCurFragment();
    }

    @Override
    public void onRefreshing() {
        if (swipeRefreshLayout != null && !swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void onRefreshFinish() {
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

}

