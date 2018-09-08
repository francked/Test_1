package com.example.ryan.test_1;

import android.content.DialogInterface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list;
    private MyRecyclerView myRecyclerView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        myRecyclerView = new MyRecyclerView(list,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        MyDividerItemDecoration dividerItemDecoration = new MyDividerItemDecoration(this,MyDividerItemDecoration.VERTICAL_LIST);

        ColorDividerItemDecoration colorDividerItemDecoration = new ColorDividerItemDecoration(ColorDividerItemDecoration.VERTICAL_LIST);
        recyclerView.addItemDecoration(colorDividerItemDecoration);
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(myRecyclerView);

        myRecyclerView.setOnItemClickLinstener(new MyRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点击第" + (position + 1) + "条", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("确认删除吗？")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myRecyclerView.removeData(position);
                            }
                        }).show();
            }
        });

    }

    public void init(){
        list = new ArrayList<>();
        TextView tv_close = this.findViewById(R.id.tv_close);

        Toolbar mToolbar = findViewById(R.id.toolbar);

        mToolbar.setTitle("Toolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_background);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ab_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.ab_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }


                return true;
            }
        });


        mDrawerLayout = findViewById(R.id.id_drawerlayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,mToolbar, R.string.drawer_open,R.string.drawer_close);

        mDrawerToggle.syncState();

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });


        for (int i = 0; i <100 ; i++) {
            list.add("第 " + i + " 个 String");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
}
