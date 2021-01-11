package com.example.soldierapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddVacation extends AppCompatActivity {

    private EditText name_vaca;
    private Button btn_yes1, btn_no1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacation);

        name_vaca = (EditText)findViewById(R.id.name_vaca);
        btn_yes1 = (Button)findViewById(R.id.btn_yes1);
        btn_no1 = (Button)findViewById(R.id.btn_no1);

        btn_yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VacaDate date = new VacaDate();
                date.setName(name_vaca.getText().toString());
                date.setUse(0);
                date.setLest(0);
                MainActivity.list.add(date);
                MainActivity.amount_vaca += 1;
                Toast toast = Toast.makeText(AddVacation.this, "추가했습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

        btn_no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(AddVacation.this, "취소했습니다.", Toast.LENGTH_SHORT);
                toast.show();
                finish();
            }
        });

    }

}
