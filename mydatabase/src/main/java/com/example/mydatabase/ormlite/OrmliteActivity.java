package com.example.mydatabase.ormlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mydatabase.R;

public class OrmliteActivity extends AppCompatActivity implements View.OnClickListener {

    private Button add;
    private Button query;
    private Button update;
    private Button delete;
    private StudentDao studentDao;
    private EditText edit_name;
    private TextView show;
    private Student student3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ormlite);

        //实例 StudentDao 对象

        studentDao = new StudentDao(this);


        //initView 初始化控件

        initView();

        listener();
        student3 = new Student();
        student3.setName("李四");
        studentDao.add(student3);

    }

    private void listener() {
        add.setOnClickListener(this);
        query.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    private void initView() {
        add = findViewById(R.id.add);
        query = findViewById(R.id.query);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        edit_name = findViewById(R.id.edit_name);
        show = findViewById(R.id.show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:

                Student student = new Student();
                student.setName(edit_name.getText().toString().trim());
                studentDao.add(student);
                break;
            case R.id.query:
                Student student1 = studentDao.query(1);
                show.setText(student1.toString());
                break;
            case R.id.update:
                Student student2 = studentDao.query(2);
                student2.setName(edit_name.getText().toString().trim());
                studentDao.update(student2);
                show.setText(student2.toString());
                break;
            case R.id.delete:
                studentDao.delete(student3.getId());
                break;
        }
    }
}
