package com.example.soldierapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class SettingScreen extends AppCompatActivity {

    private TextView tv_inday;
    private TextView tv_outday;
    private Button btn_inday;
    private Button btn_outday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        tv_inday = (TextView)findViewById(R.id.tv_inday);
        tv_outday = (TextView)findViewById(R.id.tv_outday);
        btn_inday = (Button)findViewById(R.id.btn_inday);
        btn_outday = (Button)findViewById(R.id.btn_outday);

        btn_inday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingScreen.this, CalenderView.class);
                intent.putExtra("kind", 1);
                startActivity(intent);
            }
        });

        btn_outday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingScreen.this, CalenderView.class);
                intent.putExtra("kind", 2);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if(MainActivity.inday_setting == true){
            StringBuilder str = new StringBuilder("");
            str.append(MainActivity.year1);
            str.append("/");
            str.append(MainActivity.month1 + 1);
            str.append("/");
            str.append(MainActivity.day1);
            tv_inday.setText(str);
        }
        if(MainActivity.outday_setting == true){
            StringBuilder str = new StringBuilder("");
            str.append(MainActivity.year2);
            str.append("/");
            str.append(MainActivity.month2 + 1);
            str.append("/");
            str.append(MainActivity.day2);
            tv_outday.setText(str);
        }
    }
}
