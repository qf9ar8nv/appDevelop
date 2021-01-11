package com.example.soldierapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CalVacation extends AppCompatActivity {

    private Button btn_addvaca, btn_delvaca;
    private String list_vaca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_vacation);

        btn_addvaca = (Button)findViewById(R.id.btn_addvaca);
        btn_delvaca = (Button)findViewById(R.id.btn_delvaca);


        btn_addvaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalVacation.this, AddVacation.class);
                startActivity(intent);
            }
        });

        btn_delvaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalVacation.this, SubtractVacation.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.vaca_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        VacationAdapter adapter = new VacationAdapter(MainActivity.list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = findViewById(R.id.vaca_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        VacationAdapter adapter = new VacationAdapter(MainActivity.list);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();

        RecyclerView recyclerView = findViewById(R.id.vaca_recycler);
        for(int i=0; i<MainActivity.list.size(); i++){
            View view = recyclerView.getLayoutManager().findViewByPosition(i);
            if(view != null){
                int use, lest;
                VacaDate vacaDate = new VacaDate();
                TextView tv_vaca = (TextView)view.findViewById(R.id.tv_vaca);
                EditText et_use_vaca = (EditText)view.findViewById(R.id.et_use_vaca);
                EditText et_lest_vaca = (EditText)view.findViewById(R.id.et_lest_vaca);
                vacaDate.setName(tv_vaca.getText().toString());
                vacaDate.setUse(use = Integer.parseInt(et_use_vaca.getText().toString()));
                vacaDate.setLest(lest = Integer.parseInt(et_lest_vaca.getText().toString()));
                MainActivity.list.set(i, vacaDate);
            }
        }

    }
}
