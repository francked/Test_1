package com.example.mydatabase.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ryan on 18-8-24.
 *  创建Dao 代表数据访问对象 是告诉我们的数据库如何操作数据的一种方式
 *
 * */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insert(List<User> users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

}
