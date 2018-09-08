package com.example.mytablayout.searchwenjian;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytablayout.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchWenJianActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView content;
    private Button search_bt;
    private EditText search_edit;
    private File file;
    private String key;
    private String path;
    private static final String TAG = "SearchWenJianActivity";
    private Button search_all;
    private Button showfile;

    private List<FileBean> fileBeanList;
    private RecyclerView recyclerView;
    private SearchRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_wen_jian);

        initView();

        //实例化搜索文件适配器
        adapter = new SearchRecyclerView(fileBeanList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //searchFile_all(file);

        adapter.setOnItemClickListener(new SearchRecyclerView.OnFileClickListener() {
            @Override
            public void onFileClick(View view, int position) {
                Toast.makeText(SearchWenJianActivity.this, fileBeanList.get(position).getPath(), Toast.LENGTH_SHORT).show();
                File file1 = new File(fileBeanList.get(position).getPath());
                if (file1.isDirectory()){
                    File[] files = file1.listFiles();
                    for (File f: files) {
                        Log.d(TAG, "getName : " + f.getName() + "getPath : " + f.getPath());
                    }
                }

            }
        });
    }

    private void initView() {
        content = findViewById(R.id.content);
        search_bt = findViewById(R.id.search_bt);
        search_edit = findViewById(R.id.search_edit);
        search_all = findViewById(R.id.search_all_file_bt);
        recyclerView = findViewById(R.id.recycler_view);
        showfile = findViewById(R.id.showFile);
        file = new File("/sdcard/");
        fileBeanList = new ArrayList<>();
        search_bt.setOnClickListener(this);
        showfile.setOnClickListener(this);

        //查找所有文件 暂时值显示txt
        search_all.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_bt:
                path = "";
                content.setText("");
                key = search_edit.getText().toString();
                Log.d(TAG, "onClick: " + key);
                BrowserFile(file);
                break;
            case R.id.search_all_file_bt:
                searchFile_all(file);
                recyclerView.setAdapter(adapter);
                break;
            case R.id.showFile:
                startActivity(new Intent(SearchWenJianActivity.this,FileActivity.class));
                break;
        }

    }

    private void searchFile_all(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (!file1.isDirectory()) {
                if (file1.getName().contains(".jpg")) {
                    Log.d(TAG, " 文件名: " + file1.getName() + " 文件路径： " + file1.getPath());
                    FileBean file_jpg = new FileBean(file1.getName(),file1.getPath());
                    fileBeanList.add(file_jpg);

                } else if (file1.getName().contains(".fig")) {
                    FileBean file_fig = new FileBean(file1.getName(),file1.getPath());
                    fileBeanList.add(file_fig);
//                    Log.d(TAG, " 文件名: " + file1.getName() + " 文件路径： " + file1.getPath());

                } else if (file1.getName().contains(".mp4")) {
                    FileBean file_mp4 = new FileBean(file1.getName(),file1.getPath());
                    fileBeanList.add(file_mp4);
//                    Log.d(TAG, " 文件名: " + file1.getName() + " 文件路径： " + file1.getPath());

                }

            }
            else {
                FileBean fileBean = new FileBean(file1.getName(),file1.getPath());
                fileBeanList.add(fileBean);
            }

        }

    }

    private void BrowserFile(File file) {
        if (key.equals("")){
            Toast.makeText(this, "请输入搜索内容", Toast.LENGTH_SHORT).show();
        }else {
            searchFile(file);
            if (content.getText().toString().equals("")){
                Toast.makeText(this, "未搜索到文件", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void searchFile(File file) {
        File[] files = file.listFiles();
        if (files.length > 0){
            for (int i = 0; i < files.length; i++) {
                if (!files[i].isDirectory()){
                    if (files[i].getName().indexOf(key) > -1){
                        path += "n" + files[i].getPath();
                        content.setText(path);
                    }
                } else{
                    searchFile(files[i]);
                }
            }
        }
    }
}
