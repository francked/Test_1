package com.example.mydatabase.ormlite;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.io.Serializable;

/**
 * Created by ryan on 18-8-28.
 */

public class Author implements Serializable{

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String pwd;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public ForeignCollection<Note> getNotes() {
        return notes;
    }

    public void setNotes(ForeignCollection<Note> notes) {
        this.notes = notes;
    }
}
