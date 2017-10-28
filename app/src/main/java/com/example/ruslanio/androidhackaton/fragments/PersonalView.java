package com.example.ruslanio.androidhackaton.fragments;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.abstracts.BaseFragment;
import com.example.ruslanio.androidhackaton.api.authorization.NetworkManager;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.user.ResponseData;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class PersonalView extends BaseFragment {
    private NetworkManager mNetworkManager;
    private SharedPreferences mPreferences;


    @BindView(R.id.tv_last_name)
    TextView mLastName;
    @BindView(R.id.tv_first_name)
    TextView mFirstName;
    @BindView(R.id.tv_middle_name)
    TextView mMiddleName;
    @BindView(R.id.tv_user_birth_date)
    TextView mBirthDate;
    @BindView(R.id.tv_user_birth_place)
    TextView mBirthPlace;
    @BindView(R.id.tv_user_citizinship)
    TextView mCitizenShip;
    @BindView(R.id.tv_user_drive_expirience)
    TextView mDriveExperience;
    @BindView(R.id.tv_user_pass_number)
    TextView mPassNumber;
    @BindView(R.id.tv_user_pass_serial)
    TextView mPassSerial;
    @BindView(R.id.tv_user_pass_date)
    TextView mPassDate;
    @BindView(R.id.tv_user_pass_who)
    TextView mPassWho;
    @BindView(R.id.tv_user_snils)
    TextView mSnils;
    @BindView(R.id.tv_user_inn)
    TextView mInn;
    @BindView(R.id.tv_user_phone)
    TextView mPhone;
    @BindView(R.id.tv_user_license_number)
    TextView mLicenseNumber;
    @BindView(R.id.tv_user_license_serial)
    TextView mLicenseSerial;

    @Override
    protected int getLayout() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void onInit() {
        super.onInit();
        mNetworkManager = new NetworkManager();
        mNetworkManager.getUser(getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .map(response -> response.getResponseData())
                .subscribe(
                        user -> fillFields(user)
                );

    }

    private String getToken() {
        mPreferences = getContext().getSharedPreferences(MAIN_PREF_NAME, MODE_PRIVATE);
        String token = mPreferences.getString(NetworkManager.KEY_TOKEN, "no token");
        return token;
    }


    private void fillFields(ResponseData user) {
        mLastName.setText(user.getLastName().toString());
        mFirstName.setText(user.getFirstName().toString());
        if (user.getMiddleName() != null)
            mMiddleName.setText(user.getMiddleName().toString());
        if (user.getBirthday() != null)
            mBirthDate.setText(user.getBirthday().toString());
        if (user.getBirthPlace() != null)
            mBirthPlace.setText(user.getBirthPlace().toString());
        if (user.getCitizenship() != null)
            mCitizenShip.setText(user.getCitizenship().toString());
        if (user.getDrivingExperience() != null)
            mDriveExperience.setText(user.getDrivingExperience().toString());
        if (user.getInn() != null)
            mInn.setText(user.getInn().toString());
        if (user.getPassGettingDate() != null)
            mPassDate.setText(user.getPassGettingDate().toString());
        if (user.getPassNumber() != null)
            mPassNumber.setText(user.getPassNumber().toString());
        if (user.getPassSeria() != null)
            mPassSerial.setText(user.getPassSeria().toString());
        if (user.getWhoGivedPass() != null)
            mPassWho.setText(user.getWhoGivedPass().toString());
        if (user.getSnils() != null)
            mSnils.setText(user.getSnils().toString());
        if (user.getLicenseNumber() != null)
            mLicenseNumber.setText(user.getLicenseNumber().toString());
        if (user.getLicenseSerial() != null)
            mLicenseSerial.setText(user.getLicenseSerial().toString());
        if (user.getPhone() != null)
            mPhone.setText(user.getPhone().toString());

    }

    public static PersonalView getInstance() {
        return new PersonalView();
    }
}
