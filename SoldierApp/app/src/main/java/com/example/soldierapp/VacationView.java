package com.example.soldierapp;

import android.widget.EditText;
import android.widget.TextView;

public class VacationView {

    private String tv_vaca;
    private int et_use_vaca;
    private int et_lest_vaca;

    public String getTv_vaca() {
        return tv_vaca;
    }

    public void setTv_vaca(String tv_vaca) {
        this.tv_vaca = tv_vaca;
    }

    public int getEt_use_vaca() {
        return et_use_vaca;
    }

    public void setEt_use_vaca(int et_use_vaca) {
        this.et_use_vaca = et_use_vaca;
    }

    public int getEt_lest_vaca() {
        return et_lest_vaca;
    }

    public void setEt_lest_vaca(int et_lest_vaca) {
        this.et_lest_vaca = et_lest_vaca;
    }

    public VacationView(String tv_vaca, int et_use_vaca, int et_lest_vaca) {
        this.tv_vaca = tv_vaca;
        this.et_use_vaca = et_use_vaca;
        this.et_lest_vaca = et_lest_vaca;
    }
}
