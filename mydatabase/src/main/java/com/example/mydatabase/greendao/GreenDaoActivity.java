package com.example.mydatabase.greendao;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.mydatabase.R;
import com.example.mydatabase.TextAppcation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "GreenDaoActivity";
    private UserDao userDao;
    private PhotoDao photoDao;
    private EditText name_edit;
    private EditText age_edit;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private Button b1;
    private Button b2;
    private String name;
    private String age;

    //图片总数
    private int photoCount = 4;

    int[] ints = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);

        userDao = TextAppcation.getInstance().getmDaoSession().getUserDao();
        photoDao = TextAppcation.getInstance().getmDaoSession().getPhotoDao();

        //增加商品
        initView();




    }

    private void initView() {


        name_edit = findViewById(R.id.edit_name);
        age_edit = findViewById(R.id.edit_age);
        imageView1 = findViewById(R.id.image_1);
        imageView2 = findViewById(R.id.image_2);
        imageView3 = findViewById(R.id.image_3);
        imageView4 = findViewById(R.id.image_4);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);



        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                name = name_edit.getText().toString().trim();
                age = age_edit.getText().toString().trim();
                    if (isNumeric(age)){
                        User user = new User(null,name,Integer.parseInt(age));
                        userDao.insert(user);
                        for (int i = 0; i < photoCount ; i++) {
                            Photo photo = new Photo();
                            photo.setCardId(user.getId());
                            photo.setDrawable(ints[i]);
                            photoDao.insert(photo);
                        }
                    }else {
                        Toast.makeText(this, "年龄为数字", Toast.LENGTH_SHORT).show();
                    }

                break;
            case R.id.button2:

                showImage();



                break;
        }
    }

    private void showImage() {

        List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).build().list();
        Log.d(TAG, "showImage: " + userList.get(0).getName());

        List<Photo> photoList = userList.get(0).getPhotoList();

        Log.d(TAG, "showImage: " + photoList.get(0).getDrawable());

        Resources resources = getBaseContext().getResources();



        Drawable drawable1 = resources.getDrawable(photoList.get(0).getDrawable());
        Drawable drawable2 = resources.getDrawable(photoList.get(1).getDrawable());
        Drawable drawable3 = resources.getDrawable(photoList.get(2).getDrawable());
        Drawable drawable4 = resources.getDrawable(photoList.get(3).getDrawable());


        imageView1.setImageDrawable(drawable1);
        imageView2.setImageDrawable(drawable2);
        imageView3.setImageDrawable(drawable3);
        imageView4.setImageDrawable(drawable4);

    }


    //判断字符串是否为数字
    private boolean isNumeric(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()){
            return false;
        }
        return true;
    }
}
