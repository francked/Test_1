package com.example.mydatabase.ormlite;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.sql.SQLException;

/**
 * Created by ryan on 18-8-28.
 */

public class StudentDao {

    private Dao<Student,Integer> dao;

    public StudentDao(Context context) {
        try {
            dao = DBHelper.getInstance(context).getDao(Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int add(Student student){
        try {
            return dao.create(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Student query(int id){

        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(Student student){

        try {
            return dao.update(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int delete(int id){
        try {
            return dao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
