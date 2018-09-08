package com.example.mydatabase.ormlite;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ryan on 18-8-28.
 */

@DatabaseTable(tableName = "tb_class")
public class Class_1 {

    //班级编号
    @DatabaseField(generatedId = true)
    private int ClassId;

    //班级名称
    @DatabaseField
    private String className;


    //学生信息集合
    @ForeignCollectionField
    /**
     * 这里需要注意的是：属性类型只能是ForeignCollection<T>或者Collection<T>
     * 如果需要懒加载（延迟加载）可以在@ForeignCollectionField加上参数eager=false
     * 这个属性也就说明一个部门对应着多个用户
     */

    private ForeignCollection<Student> students;

    public Class_1() {
    }

    public Class_1(int classId, String className) {
        ClassId = classId;
        this.className = className;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ForeignCollection<Student> getStudents() {
        return students;
    }

    public void setStudents(ForeignCollection<Student> students) {
        this.students = students;
    }
}
