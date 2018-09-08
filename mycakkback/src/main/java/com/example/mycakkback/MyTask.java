package com.example.mycakkback;

import android.os.AsyncTask;

/**
 * Created by ryan on 18-9-5.
 */

public class MyTask extends AsyncTask<String,Void,String> {


    private ChangTitle changTitle;

    public MyTask(ChangTitle changTitle) {
        this.changTitle = changTitle;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (strings[0] != null){
            changTitle.onChangeTitle(strings[0]);
        }
        return null;
    }
}
