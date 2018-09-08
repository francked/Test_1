package com.example.mydatabase.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ryan on 18-8-28.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static final String DB_NAME = "clientmsg.db";
    private static final int DB_VERSION = 1;

//    //Y用来存放Dao 的键值对集合
//    private Map<String,Dao> daos = new HashMap<>();

    private static DBHelper instance;


    private Dao<Student , Integer> studentdao = null;
    private Dao<Class_1 , Integer> classdao = null;

    private RuntimeExceptionDao<Student ,Integer> simpleRuntimestudentdao = null;
    private RuntimeExceptionDao<Class_1 ,Integer> simpleRuntimeclassdao = null;





//    private static SPUtil spUtil;

//    private static DBHelper getInstance(Context context,SPUtil spNewUtil){
    public static DBHelper getInstance(Context context){
        if (instance == null){
            synchronized (DBHelper.class){
                if (instance == null){
                    instance = new DBHelper(context.getApplicationContext());
//                    spUtil = spNewUtil;
                }
            }
        }
        return instance;
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
//            TableUtils.createTableIfNotExists(connectionSource,Author.class);
//            TableUtils.createTableIfNotExists(connectionSource,Note.class);
            TableUtils.createTableIfNotExists(connectionSource,Student.class);
            TableUtils.createTableIfNotExists(connectionSource,Class_1.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
//            TableUtils.dropTable(connectionSource,Author.class,true);
//            TableUtils.dropTable(connectionSource,Note.class,true);
//            spUtil.setAuthorOnline(false);
            TableUtils.dropTable(connectionSource,Student.class,true);
            TableUtils.dropTable(connectionSource,Class_1.class,true);
            onCreate(database,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void close(){
//        super.close();
//        for (String key: daos.keySet()) {
//            Dao dao = daos.get(key);
//            dao = null;
//        }
//    }
    public Dao getDao(Class clazz) throws SQLException {
        return super.getDao(clazz);
    }


    public Dao<Student,Integer> getDaoStudent(Class clazz) throws SQLException {

        if (studentdao == null){
            studentdao = getDaoStudent(Student.class);
        }
        return studentdao;
    }



    //插入一条数据
    public  void insert (Student student){
        RuntimeExceptionDao<Student ,Integer> dao = getSimpleDataUserDao();

        int returnValue = dao.create(student);


    }

    //查询所有信息
    public List<Student> findAllStudent(){
        RuntimeExceptionDao<Student , Integer> dao = getSimpleDataUserDao();
        return dao.queryForAll();
    }


    public RuntimeExceptionDao<Student, Integer> getSimpleDataUserDao() {
        if (simpleRuntimestudentdao == null) {
            simpleRuntimestudentdao = getRuntimeExceptionDao(Student.class);
        }
        Log.i("test", "simpleRuntimeDao ======= "+simpleRuntimestudentdao);
        return simpleRuntimestudentdao;
    }


    public Dao<Class_1, Integer> getDeptDao(Class clazz) throws SQLException {
        if (classdao == null) {
            classdao = getDao(Class_1.class);
        }
        return classdao;
    }

    public RuntimeExceptionDao<Class_1, Integer> getSimpleDataDeptDao() {
        if (simpleRuntimeclassdao == null) {
            simpleRuntimeclassdao = getRuntimeExceptionDao(Class_1.class);
        }
        Log.i("test", "simpleRuntimeDaodeptdept ======= "+simpleRuntimeclassdao);
        return simpleRuntimeclassdao;
    }

    /**
     * 插入一条部门数据
     */
    public void insertDept(Class_1 class1){
        RuntimeExceptionDao<Class_1, Integer> dao = getSimpleDataDeptDao();
        //通过实体对象创建在数据库中创建一条数据，成功返回1，说明插入了一条数据
        Log.i("test", "dao = " + dao+"  dept= "+class1.getClassName());
        int returnValue = dao.create(class1);
        Log.i("test", "插入数据后返回值："+returnValue);
    }

    /**
     * 查询所有的部门信息
     * @return
     */
    public List<Class_1> findAllDept(){
        RuntimeExceptionDao<Class_1, Integer> dao = getSimpleDataDeptDao();
        return dao.queryForAll();
    }

    public Class_1 findByDeptId(int classId){
        RuntimeExceptionDao<Class_1, Integer> dao = getSimpleDataDeptDao();
        return dao.queryForId(classId);
    }

}



