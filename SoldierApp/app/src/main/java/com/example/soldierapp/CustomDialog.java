package com.example.soldierapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialog {

    private Context context;

    public CustomDialog(Context context){
        this.context = context;
    }

    public void callDialog(){
        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();

        final EditText sort_vaca = (EditText)dialog.findViewById(R.id.sort_vaca);
        final Button btn_yes = (Button)dialog.findViewById(R.id.btn_yes);
        final Button btn_no = (Button)dialog.findViewById(R.id.btn_no);


        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "추가했습니다.", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "취소했습니다.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }

}
