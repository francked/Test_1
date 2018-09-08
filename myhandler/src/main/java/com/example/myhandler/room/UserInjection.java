package com.example.myhandler.room;

import android.content.Context;

/**
 * Created by ryan on 18-9-7.
 */

public class UserInjection {
    public static UserRepository getInstance(Context context){
        UserDatabase userDatabase = UserDatabase.getInstance(context);
        return UserRepository.getInstance(RemoteUserDataSource.getInstance(new AppExecutor(),userDatabase.getUserDao()));
    }
}
