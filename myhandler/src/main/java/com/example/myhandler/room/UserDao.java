package com.example.myhandler.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ryan on 18-9-7.
 */

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("SELECT * FROM user where name like :name")
    User getUser(String name);

    @Insert
    void insert(User... users);



    @Query("delete from User")
    void deletes();

    @Query("delete from User where name like:name")
    void delete(String name);
}
