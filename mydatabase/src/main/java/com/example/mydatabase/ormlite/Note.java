package com.example.mydatabase.ormlite;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

/**
 * Created by ryan on 18-8-28.
 */

public class Note implements Serializable{

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String title;

    @DatabaseField
    private String content;

    @DatabaseField
    private String lastTime;

    //笔记类别
    @DatabaseField
    private int categroy;


    //外部对象字段 确定关系的字段
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    public Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public int getCategroy() {
        return categroy;
    }

    public void setCategroy(int categroy) {
        this.categroy = categroy;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
