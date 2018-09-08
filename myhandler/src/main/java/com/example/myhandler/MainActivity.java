package com.example.myhandler;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myhandler.room.User;
import com.example.myhandler.room.UserDao;
import com.example.myhandler.room.UserDataSource;
import com.example.myhandler.room.UserDatabase;
import com.example.myhandler.room.UserInjection;
import com.example.myhandler.room.UserRepository;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userRepository = UserInjection.getInstance(this);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setName("张1");
                user.setPassword("张1");
                user.setAge(12);
                userRepository.addUser(user);
            }
        });
        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRepository.getUser("张1", new UserDataSource.LoadUserCallback() {
                    @Override
                    public void onUserLoaded(User user) {
                        Log.d(TAG, "onUserLoaded: " + user.toString());
                    }

                    @Override
                    public void onDataNotAvailable() {
                        Log.d(TAG, "onDataNotAvailable: 失败");
                    }
                });
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRepository.deleteUser("张1");
            }
        });



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                databaseOpen();
//            }
//        }).start();

    }

//    private void databaseOpen() {
//        UserDatabase userDatabase = Room.databaseBuilder(getApplicationContext(),UserDatabase.class,"users").build();
//        UserDao userDao = userDatabase.getUserDao();
//        //写数据
//        Log.d(TAG, "databaseOpen: ");
//        addUser(userDao);
//    }
//
//    //增加user
//    private void addUser(UserDao dao){
//        User user = new User();
//        user.setName("张三");
//        user.setPassword("123456");
//        user.setAge(24);
//
//        dao.insert(user);
//    }
}
