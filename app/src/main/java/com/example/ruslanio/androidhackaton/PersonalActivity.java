package com.example.ruslanio.androidhackaton;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.abstracts.BaseActivity;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.models.PostPersonalDataRequest;

import java.util.Calendar;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class PersonalActivity extends BaseActivity {

    public static final int DIALOG_BIRTHDAY = 1;
    public static final int DIALOG_PASS_GETTING_DATE = 2;

    SharedPreferences preferences;

    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private Calendar selectedBirthday;
    private Calendar selectedPassGettingDate;

    @BindView(R.id.et_birth_place)
    TextInputEditText birthplace;

    @BindView(R.id.birthday)
    TextView birthday;

    @BindView(R.id.et_citizenship)
    TextInputEditText citizenship;

    @BindView(R.id.et_experience)
    TextInputEditText experience;

    @BindView(R.id.gender_male)
    RadioButton male;

    @BindView(R.id.gender_female)
    RadioButton female;

    @BindView(R.id.et_inn)
    TextInputEditText inn;

    @BindView(R.id.et_licence_number)
    TextInputEditText licenceNumber;

    @BindView(R.id.et_licence_serial)
    TextInputEditText licenceSerial;

    @BindView(R.id.et_pass_getting_date)
    TextView passGettingDate;

    @BindView(R.id.et_pass_serial)
    TextInputEditText passSerial;

    @BindView(R.id.et_pass_number)
    TextInputEditText passNumber;

    @BindView(R.id.et_who_gave_pass)
    TextInputEditText whoGavePass;

    @BindView(R.id.et_registration_address)
    TextInputEditText registrationAddress;

    @BindView(R.id.et_snils)
    TextInputEditText snils;

    @BindView(R.id.btn_save)
    Button btnSave;

    @Override
    protected void onInit() {
        preferences = getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        if (preferences.getBoolean(IS_PERSONAL, false)) {
            goToAuto();
        }

        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        currentDay = calendar.get(Calendar.DATE);

        selectedBirthday = Calendar.getInstance();
        selectedPassGettingDate = Calendar.getInstance();

        birthday.setOnClickListener(v -> {
            showDialog(DIALOG_BIRTHDAY);
        });

        passGettingDate.setOnClickListener(v -> {
            showDialog(DIALOG_PASS_GETTING_DATE);
        });

        male.setChecked(true);


        btnSave.setOnClickListener(v -> {
            NetworkManager manager = new NetworkManager();
            manager.addPersonal(preferences.getString(NetworkManager.KEY_TOKEN, ""), getFilledRequest())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                        if (response.getError() != null) {
                            showSnackbar(response.getError());
                        } else {
                            setIsPersonal();
                            goToAuto();
                        }
                    }, Throwable::printStackTrace);
        });
    }

    private void setIsPersonal() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_PERSONAL, true);
        editor.commit();
    }

    private void goToAuto() {
        Intent goToAuto = new Intent(getApplicationContext(), MainActivity.class); //TODO change activity
        startActivity(goToAuto);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_personal;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_BIRTHDAY) {
            DatePickerDialog tpd = new DatePickerDialog(this, birthdayChangeListener, currentYear, currentMonth, currentDay);
            return tpd;
        }
        if (id == DIALOG_PASS_GETTING_DATE) {
            DatePickerDialog pickerDialog = new DatePickerDialog(this, passGettingDateChangeListener, currentYear, currentMonth, currentDay);
            return pickerDialog;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener birthdayChangeListener = (view, year, monthOfYear, dayOfMonth) -> {
        selectedBirthday.set(year, monthOfYear, dayOfMonth);
        birthday.setText("Дата рождения:  " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
    };

    DatePickerDialog.OnDateSetListener passGettingDateChangeListener = (view, year, monthOfYear, dayOfMonth) -> {
        selectedPassGettingDate.set(year, monthOfYear, dayOfMonth);
        passGettingDate.setText("Дата выдачи паспорта: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
    };

    private PostPersonalDataRequest getFilledRequest() {
        PostPersonalDataRequest request = new PostPersonalDataRequest();
        //request.setBirthday(selectedBirthday.getTime());
        request.setBirthPlace(birthplace.getText().toString());
        request.setCitizenship(citizenship.getText().toString());
        request.setDrivingExperience(experience.getText().toString());
        request.setInn(inn.getText().toString());
        request.setLicenseNumber(licenceNumber.getText().toString());
        request.setLicenseSerial(licenceSerial.getText().toString());
        //request.setPassGettingDate(selectedPassGettingDate.getTime());
        request.setPassNumber(passNumber.getText().toString());
        request.setPassSeria(passSerial.getText().toString());
        request.setRegistrationAdress(registrationAddress.getText().toString());
        request.setSnils(snils.getText().toString());
        request.setWhoGivedPass(whoGavePass.getText().toString());
        request.setGender(male.isChecked() ? "male" : "female");
        return request;
    }
}
