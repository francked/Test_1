package com.example.mymvp;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mymvp.login.greendao.DaoMaster;
import com.example.mymvp.login.greendao.DaoSession;
import com.orhanobut.logger.AndroidLogAdapter;

/**
 * Created by ryan on 18-8-23.
 */

public class TextAppcation extends Application {
    private Context context;
    private SQLiteDatabase db;
    private static TextAppcation instances;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private DaoMaster.OpenHelper helper;

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
    }

    private void setDatabase() {
        helper = new DaoMaster.DevOpenHelper(this,"user_1111-db",null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getmDaoSession(){
        return daoSession;
    }
    public SQLiteDatabase getDb(){
        return db;
    }

}
