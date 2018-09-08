package com.example.myhandler.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by ryan on 18-9-7.
 */
@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DB_NAME = "UserDatabase.db";

    private static volatile UserDatabase instance;

    static synchronized UserDatabase getInstance(Context context) {
        if (instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static UserDatabase create(final Context context){
        return Room.databaseBuilder(
                context,
                UserDatabase.class,
                DB_NAME
            ).build();
    }
    public abstract UserDao getUserDao();
}
