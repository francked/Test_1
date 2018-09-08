package com.example.mysnackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout activity_main;
    private Button bt_sanckBar;
    private EditText username;
    private EditText password;
    private Button login_bt;
    private static final String TAG = "MainActivity";

    private static final String EMALL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$]";
    private Pattern pattern = Pattern.compile(EMALL_PATTERN);
    private TextInputLayout tl_username;
    private TextInputLayout tl_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        bt_sanckBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(activity_main,"标题",Snackbar.LENGTH_LONG)
                        .setAction("点击事件", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                            }
                        }).setDuration(Snackbar.LENGTH_LONG).show();
            }
        });

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString().trim();
                String pass_word = password.getText().toString().trim();
                String user_name1 = tl_username.getEditText().getText().toString().trim();
                String pass_word1 = tl_password.getEditText().getText().toString().trim();
                login(user_name1,pass_word1);
                Log.d(TAG, "userName: " + user_name1);
                Log.d(TAG, "passWord: " + pass_word1);
            }
        });

    }

    private void initView() {
        activity_main = findViewById(R.id.activity_main);
        bt_sanckBar = findViewById(R.id.snackBar_text);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);

        tl_username = findViewById(R.id.tl_username);
        tl_password = findViewById(R.id.tl_password);


        login_bt = findViewById(R.id.login);


    }

    private void login(String username,String password){
        if (!validateUserName_1(username)){
            tl_username.setErrorEnabled(true);
            tl_username.setError("请输入正确的邮箱地址");
        }else if (!validatePassWord(password)){
            tl_password.setErrorEnabled(true);
            tl_password.setError("密码字数过少");

        }else {
            tl_username.setErrorEnabled(false);
            tl_password.setErrorEnabled(true);
            tl_password.setError("登录成功");
//            tl_password.setBackgroundColor(Color.BLUE);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        }
    }


    //验证用户名是否为邮箱格式
    private boolean validateUserName(String username){
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    //验证用户名是否为邮箱格式
    private boolean validateUserName_1(String username){

        return username.length() > 6 && username.length() < 12;
    }

    //密码长度
    private boolean validatePassWord(String password){
        return password.length() > 6 && password.length() < 12;
    }



}
