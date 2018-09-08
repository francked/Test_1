package com.example.mydatabase;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mydatabase.greendao.DaoMaster;
import com.example.mydatabase.greendao.DaoSession;
import com.orhanobut.logger.AndroidLogAdapter;

/**
 * Created by ryan on 18-8-23.
 */

public class TextAppcation extends Application {
    private Context context;
    private static TextAppcation instances;
    private SQLiteDatabase db;
    private DaoSession mDaoSession;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster mDaoMaster;

    public TextAppcation() {
        this.context = getBaseContext();
        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
    }


    public static TextAppcation getInstance(){
        return instances;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
        setDatabaseGoods();
    }

    private void setDatabaseGoods() {
        helper = new DaoMaster.DevOpenHelper(this,"Photo_1-db",null);

        db = helper.getWritableDatabase();

        mDaoMaster = new DaoMaster(db);

        mDaoSession = mDaoMaster.newSession();
    }

    public void setDatabase(){
        helper = new DaoMaster.DevOpenHelper(this,"Users_1-db",null);

        db = helper.getWritableDatabase();

        mDaoMaster = new DaoMaster(db);

        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession(){
        return mDaoSession;
    }

    public SQLiteDatabase getDb(){
        return db;
    }


}
