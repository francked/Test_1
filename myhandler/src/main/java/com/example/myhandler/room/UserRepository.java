package com.example.myhandler.room;

/**
 * Created by ryan on 18-9-7.
 */

public class UserRepository implements UserDataSource {

    private static UserRepository INSTANCE = null;

    private RemoteUserDataSource mRemoteUserDataSource;

    public UserRepository(RemoteUserDataSource remoteUserDataSource) {
        mRemoteUserDataSource = remoteUserDataSource;
    }


    public static UserRepository getInstance(RemoteUserDataSource remoteUserDataSource) {

        if (INSTANCE == null){
            INSTANCE = new UserRepository(remoteUserDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void addUser(User user) {
        mRemoteUserDataSource.addUser(user);
    }

    @Override
    public void getUsers(LoadUserListCallback callback) {
        mRemoteUserDataSource.getUsers(callback);
    }

    @Override
    public void getUser(String name, LoadUserCallback callback) {
        mRemoteUserDataSource.getUser(name,callback);
    }

    @Override
    public void deleteUsers() {
        mRemoteUserDataSource.deleteUsers();
    }

    @Override
    public void deleteUser(String name) {
        mRemoteUserDataSource.deleteUser(name);
    }
}
