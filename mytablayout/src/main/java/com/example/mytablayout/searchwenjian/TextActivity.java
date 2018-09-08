package com.example.mytablayout.searchwenjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.mytablayout.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView textView = findViewById(R.id.txt);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        File file = new File(getIntent().getStringExtra("lujing"));

        try {
            FileReader in = new FileReader(file);

            char byt[] = new char[102400];
            int len = in.read(byt);
            textView.setText(new String(byt,0,len));
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
