package com.example.mytablayout;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;

import java.util.logging.Logger;

/**
 * Created by ryan on 18-8-23.
 */

public class TextAppcation extends Application {
    private Context context;

    public TextAppcation() {
        this.context = getBaseContext();
        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
