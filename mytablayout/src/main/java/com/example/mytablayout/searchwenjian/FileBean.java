package com.example.mytablayout.searchwenjian;

/**
 * Created by ryan on 18-8-17.
 */

public class FileBean {
    private String name;
    private String path;

    public FileBean(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
