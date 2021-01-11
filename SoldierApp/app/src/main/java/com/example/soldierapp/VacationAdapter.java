package com.example.soldierapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VacationAdapter extends RecyclerView.Adapter<VacationAdapter.ViewHolder> {

    private ArrayList<VacaDate> vaca_date = null;

    @NonNull
    @Override
    public VacationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.vacation_list_view, parent, false);
        VacationAdapter.ViewHolder vh = new VacationAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VacaDate date = vaca_date.get(position);
        holder.setName(date.getName());
        holder.setUse(date.getUse());
        holder.setLest(date.getLest());
    }

    @Override
    public int getItemCount() {
        return vaca_date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_vaca;
        EditText et_use_vaca, et_lest_vaca;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_vaca = itemView.findViewById(R.id.tv_vaca);
            et_use_vaca = itemView.findViewById(R.id.et_use_vaca);
            et_lest_vaca = itemView.findViewById(R.id.et_lest_vaca);
        }
        public int getLest(){
            return Integer.parseInt(et_lest_vaca.getText().toString());
        }
        public void setUse(int num){
            et_use_vaca.setText(String.valueOf(num));
        }
        public int getUse(){
            return Integer.parseInt(et_use_vaca.getText().toString());
        }
        public void setLest(int num){
            et_lest_vaca.setText(String.valueOf(num));
        }
        public void setName(String value){
            tv_vaca.setText(value);
        }

    }

    VacationAdapter(ArrayList<VacaDate> list) {
        vaca_date = list;
    }

}
