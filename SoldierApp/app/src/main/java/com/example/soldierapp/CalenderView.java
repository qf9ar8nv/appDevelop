package com.example.soldierapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalenderView extends AppCompatActivity {

    private CalendarView cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_view);

        cv = (CalendarView)findViewById(R.id.cv);
        Intent intent = getIntent();
        final int kind = intent.getIntExtra("kind",0);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if(kind == 1){
                    MainActivity.year1 = year;
                    MainActivity.month1 = month;
                    MainActivity.day1 = dayOfMonth;
                    MainActivity.inday_setting = true;
                    finish();
                }else if(kind == 2){
                    MainActivity.year2 = year;
                    MainActivity.month2 = month;
                    MainActivity.day2 = dayOfMonth;
                    MainActivity.outday_setting = true;
                    finish();
                }else{
                    finish();
                }
            }
        });


    }
}
