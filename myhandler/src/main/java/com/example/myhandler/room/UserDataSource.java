package com.example.myhandler.room;

import java.util.List;

/**
 * Created by ryan on 18-9-7.
 */

public interface UserDataSource {

    interface LoadUserListCallback{
        void onUserLoaded(List<User> users);
        void onDataNotAvailable();
    }

    interface LoadUserCallback{
        void onUserLoaded(User user);
        void onDataNotAvailable();

    }

    void addUser(User user);

    void getUsers(LoadUserListCallback callback);

    void getUser(String name,LoadUserCallback callback);

    void deleteUsers();

    void deleteUser(String name);

}
