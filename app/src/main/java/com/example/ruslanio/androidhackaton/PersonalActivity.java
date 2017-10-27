package com.example.ruslanio.androidhackaton;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;

import java.util.Calendar;

import butterknife.BindView;

public class PersonalActivity extends BaseActivity {

    public static final int DIALOG_DATE = 1;

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private Calendar selectedDate;

    @BindView(R.id.et_birth_place)
    TextInputEditText birthplace;

    @BindView(R.id.birthday)
    TextView birthday;

    @BindView(R.id.et_citizenship)
    TextInputEditText citizenship;

    @BindView(R.id.et_experience)
    TextInputEditText experience;

    @BindView(R.id.et_inn)
    TextInputEditText inn;

    @BindView(R.id.et_licence_number)
    TextInputEditText licenceNumber;

    @BindView(R.id.et_licence_serial)
    TextInputEditText licenceSerial;

    @BindView(R.id.et_pass_serial)
    TextInputEditText passSerial;

    @BindView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onInit() {
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDay = calendar.get(Calendar.DATE);
        selectedDate = Calendar.getInstance();

        birthday.setOnClickListener(v -> {
            showDialog(DIALOG_DATE);
        });


        btnSave.setOnClickListener(v -> {
            Intent goToAuto = new Intent(getApplicationContext(), MainActivity.class); //TODO change activity
            startActivity(goToAuto);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_personal;
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, currentYear, currentMonth, currentDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = (view, year, monthOfYear, dayOfMonth) -> {
        currentYear = year;
        currentMonth = monthOfYear;
        currentDay = dayOfMonth;
        selectedDate.set(year, monthOfYear, dayOfMonth);
        birthday.setText("Your birthday is " + currentDay + "/" + (currentMonth + 1) + "/" + currentYear);
    };
}
