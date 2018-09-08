package com.example.mycalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragAndDropPermissions;
import android.view.MotionEvent;
import android.widget.Button;

import com.necer.ncalendar.calendar.MonthCalendar;
import com.necer.ncalendar.listener.OnMonthCalendarChangedListener;
import com.necer.ncalendar.utils.MyLog;

import org.joda.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private Button calendar;
    private MonthCalendar monthCalendar;
    private String dateString = "初始值为null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = findViewById(R.id.btn_calendar);

        monthCalendar = findViewById(R.id.monthcalendar);


        monthCalendar.setOnMonthCalendarChangedListener(new OnMonthCalendarChangedListener() {
            @Override
            public void onMonthCalendarChanged(LocalDate date) {
                if (!dateString.equals(date.toString())) {
                    dateString = date.toString();
                    MyLog.d(date.toString());

                }
            }
        });



    }
}
