package com.example.soldierapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_percent, tv_pfday, tv_lfday, tv_pfvaca, tv_lfvaca;
    private TextView textView3, textView7;
    private TextView tv_calvaca, tv_setting;
    private String shared = "file";

    public static int amount_vaca = 0;
    public static ArrayList<VacaDate> list = new ArrayList<>();
    public static int year1 = -1;
    public static int month1 = -1;
    public static int day1 = -1;
    public static int year2 = -1;
    public static int month2 = -1;
    public static int day2 = -1;
    public static boolean inday_setting = false;
    public static boolean outday_setting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences(shared, MODE_PRIVATE);
        int list_size = sp.getInt("list_size", 0);
        for(int i=0; i<list_size; i++){
            String name = sp.getString("name_"+i, "");
            int use_vaca = sp.getInt("use_"+i, 0);
            int lest_vaca = sp.getInt("lest_"+i, 0);
            VacaDate vacaDate = new VacaDate();
            vacaDate.setName(name);
            vacaDate.setLest(lest_vaca);
        vacaDate.setUse(use_vaca);
        list.add(vacaDate);
    }
    amount_vaca = sp.getInt("amount_vaca", 0);
    year1 = sp.getInt("year1", -1);
    month1 = sp.getInt("month1", -1);
    day1 = sp.getInt("day1", -1);
    year2 = sp.getInt("year2", -1);
    month2 = sp.getInt("month2", -1);
    day2 = sp.getInt("day2", -1);
        inday_setting = sp.getBoolean("inday_setting", false);
        outday_setting = sp.getBoolean("outday_setting", false);

        if(amount_vaca == 0){
            VacaDate vacaDate1 = new VacaDate();
            vacaDate1.setName("연가");
            vacaDate1.setLest(0);
            vacaDate1.setUse(0);
            list.add(vacaDate1);
            VacaDate vacaDate2 = new VacaDate();
            vacaDate2.setName("보상휴가");
            vacaDate2.setLest(0);
            vacaDate2.setUse(0);
            list.add(vacaDate2);
            VacaDate vacaDate3 = new VacaDate();
            vacaDate3.setName("포상휴가");
            vacaDate3.setLest(0);
            vacaDate3.setUse(0);
            list.add(vacaDate3);
            amount_vaca = 3;
        }

        tv_percent = (TextView)findViewById(R.id.tv_percent);
        tv_pfday = (TextView)findViewById(R.id.tv_pfday);
        tv_lfday = (TextView)findViewById(R.id.tv_lfday);
        tv_pfvaca = (TextView)findViewById(R.id.tv_pfvaca);
        tv_lfvaca = (TextView)findViewById(R.id.tv_lfvaca);

        tv_calvaca = (TextView)findViewById(R.id.tv_calvaca);
        tv_setting = (TextView)findViewById(R.id.tv_setting);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView7 = (TextView)findViewById(R.id.textView7);

        if(inday_setting == false || outday_setting == false){
            Intent intent = new Intent(MainActivity.this, SettingScreen.class);
            startActivity(intent);
            Toast toast = Toast.makeText(MainActivity.this, "날짜를 설정해주세요", Toast.LENGTH_SHORT);
            toast.show();
        }

        tv_calvaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalVacation.class);
                startActivity(intent);
            }
        });

        tv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingScreen.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        Calendar today = Calendar.getInstance();
        Calendar in_day = Calendar.getInstance();
        Calendar out_day = Calendar.getInstance();
        DecimalFormat form = new DecimalFormat("#.##");
        int lest_vaca = 0, use_vaca = 0;

        if(inday_setting == true){
            in_day.set(year1, month1, day1);
        }
        if(outday_setting == true){
            out_day.set(year2, month2, day2);
        }
        if(inday_setting == true && outday_setting == true) {
            long o_day = out_day.getTimeInMillis() / (24 * 60 * 60 * 1000);
            long i_day = in_day.getTimeInMillis() / (24 * 60 * 60 * 1000);
            long t_day = today.getTimeInMillis() / (24 * 60 * 60 * 1000);

            int lest_day = (int) (o_day - t_day);
            int do_day = (int) (t_day - i_day);
            int all_day = (int)(o_day - i_day);
            float p_day = (float)do_day/all_day*100;

            textView3.setText(String.valueOf(do_day));
            textView7.setText(String.valueOf(lest_day));

            StringBuilder str = new StringBuilder(form.format(p_day));
            str.append("%");
            tv_percent.setText(str);
        }
        for(int i=0; i<list.size(); i++){
            lest_vaca += list.get(i).getLest();
        }
        for(int i=0; i<list.size(); i++){
            use_vaca += list.get(i).getUse();
        }
        StringBuilder sb1 = new StringBuilder(form.format(use_vaca));
        sb1.append("일");
        tv_pfvaca.setText(sb1);
        StringBuilder sb2 = new StringBuilder(form.format(lest_vaca));
        sb2.append("일");
        tv_lfvaca.setText(sb2);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sp = getSharedPreferences(shared, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putInt("list_size", list.size());
        for(int i=0; i<list.size(); i++){
            editor.putString("name_"+i, list.get(i).getName());
            editor.putInt("use_"+i, list.get(i).getUse());
            editor.putInt("lest_"+i, list.get(i).getLest());
        }
        list.clear();

        editor.putInt("amount_vaca", amount_vaca);
        editor.putInt("year1", year1);
        editor.putInt("month1", month1);
        editor.putInt("day1", day1);
        editor.putInt("year2", year2);
        editor.putInt("month2", month2);
        editor.putInt("day2", day2);
        editor.putBoolean("inday_setting", inday_setting);
        editor.putBoolean("outday_setting", outday_setting);
        editor.apply();
    }
}
