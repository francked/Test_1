package com.example.myhandler.room;

import java.util.List;

/**
 * Created by ryan on 18-9-7.
 */

public class RemoteUserDataSource implements UserDataSource {

    private static volatile RemoteUserDataSource INSTANCE = null;

    private UserDao userDao;

    private List<User> users;

    private User user;

    private AppExecutor appExecutor;

    public RemoteUserDataSource(AppExecutor appExecutor,UserDao userDao) {
        this.userDao = userDao;
        this.appExecutor = appExecutor;
    }

    public static RemoteUserDataSource getInstance(AppExecutor appExecutor, UserDao userDao) {

        if (INSTANCE == null){
            synchronized (RemoteUserDataSource.class){
                INSTANCE = new RemoteUserDataSource(appExecutor,userDao);
            }
        }
        return INSTANCE;
    }

    @Override
    public void addUser(final User user) {
        appExecutor.getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.insert(user);
            }
        });
    }




    @Override
    public void getUsers(final LoadUserListCallback callback) {
        appExecutor.getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                users = userDao.getAllUsers();
                appExecutor.getmDiskIO().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (users.isEmpty()){
                            if (callback != null){
                                callback.onDataNotAvailable();
                            }
                        }else {
                            if (callback != null){
                                callback.onUserLoaded(users);
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public void getUser(final String name , final LoadUserCallback callback) {
        appExecutor.getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                user = userDao.getUser(name);
                appExecutor.getmMainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (user != null){
                            if (callback != null){
                                callback.onUserLoaded(user);
                            }
                        }else {
                            if (callback != null){
                                callback.onDataNotAvailable();
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public void deleteUsers() {
        appExecutor.getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.deletes();
            }
        });
    }

    @Override
    public void deleteUser(final String name) {
        appExecutor.getmDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                userDao.delete(name);
            }
        });
    }
}
