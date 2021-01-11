package com.example.soldierapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class SubtractVacation extends AppCompatActivity {

    private Button btn_yes2, btn_no2;
    private Spinner st_spinner;
    private int ps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtract_vacation);
        ArrayList<String> miniList = new ArrayList<>();
        for(int i=0; i<MainActivity.list.size(); i++){
            miniList.add(MainActivity.list.get(i).getName());
        }

        btn_yes2 = (Button)findViewById(R.id.btn_yes2);
        btn_no2 = (Button)findViewById(R.id.btn_no2);
        st_spinner = (Spinner)findViewById(R.id.st_spinner);

        ArrayAdapter spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, miniList);
        st_spinner.setAdapter(spinnerAdapter);

        st_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ps = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.list.remove(ps);
                MainActivity.amount_vaca -= 1;
                Toast toast = Toast.makeText(SubtractVacation.this, "삭제했습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        btn_no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(SubtractVacation.this, "취소했습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });
    }
}
