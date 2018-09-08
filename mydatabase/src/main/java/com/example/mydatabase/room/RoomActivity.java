package com.example.mydatabase.room;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydatabase.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity implements View.OnClickListener {

    private Button query;
    private TextView tv;
    private List<User> users;

    public static final int INSTER_1 = 1;
    public static final int QUERY_2 = 2;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case INSTER_1:
                    users = new ArrayList<>();
                    User user = new User();
                    user.setName("张三");
                    user.setAge(12);
                    users.add(user);
                    UserDatabase.getInstance(getBaseContext())
                                    .getUserDao()
                                    .insert(users);
                    break;

                case QUERY_2:
                    users = UserDatabase.getInstance(getBaseContext()).getUserDao().getAllUsers();

                    for (User use: users) {
                        String name = use.getName();
                        int age = use.getAge();
                        Logger.e("age : " + age + " name : " +name,"");
                    }

                    tv.setText(users.get(0).getName() + " + " + users.get(0).getAge());


                    break;

                default:
                    break;


            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        initView();



    }

    private void initView() {
        query = findViewById(R.id.query);
        tv = findViewById(R.id.tv);
        query.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.query:
                break;
        }
    }
}
