package com.example.mydatabase.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by ryan on 18-8-24.
 * 注解该类并添加了表名、数据库版本（每当我们改变数据库中的内容时它都会增加），所以这里使用exportSchema = false
 *
 */

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {


    private static final String DB_NAME = "UserDatabase.db";
    private static volatile UserDatabase instance;


    public static synchronized UserDatabase getInstance(Context context){
        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    public static UserDatabase create(Context context){
        return Room.databaseBuilder(context,UserDatabase.class,DB_NAME).build();
    }

    public abstract UserDao getUserDao();



}
