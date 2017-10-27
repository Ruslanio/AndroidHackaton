package com.example.ruslanio.androidhackaton.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslanio.androidhackaton.R;
import com.example.ruslanio.androidhackaton.api.authorization.pojo.cars.ResponseDatum;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class CarAdapter extends RecyclerView.Adapter {

    private List<ResponseDatum> mCars = Collections.emptyList();

    public void setCars(List<ResponseDatum> cars) {
        mCars = cars;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,parent,false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CarViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        if (mCars == null)
            return 0;
        else
            return mCars.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_car_model)
        TextView mModel;
        @BindView(R.id.tv_car_mark)
        TextView mMark;
        @BindView(R.id.tv_car_number)
        TextView mRegNumber;
        @BindView(R.id.tv_car_release_year)
        TextView mReleaseYear;
        @BindView(R.id.tv_car_horse_power)
        TextView mHorsePower;
        @BindView(R.id.tv_car_insuranse_policy_number)
        TextView mInsuranceNumber;
        @BindView(R.id.tv_car_insuranse_policy_serial)
        TextView mInsuranceSerial;
        @BindView(R.id.tv_car_pts_number)
        TextView mPtsNumber;
        @BindView(R.id.tv_car_pts_serial)
        TextView mPtsSerial;
        @BindView(R.id.tv_car_vin_number)
        TextView mVinNumber;
        @BindView(R.id.tv_car_pts_by_who)
        TextView mPtsByWho;

        public CarViewHolder(View itemView) {
            super(itemView);
        }

        void bind(int position){
            ResponseDatum car = mCars.get(position);
            mMark.setText(car.getCarMark());
            mModel.setText(car.getCarModel());
            mRegNumber.setText(car.getCarNumber());
            mReleaseYear.setText(car.getCarYearOfBuilding());
            mHorsePower.setText(car.getHorsePower());
            mInsuranceNumber.setText(car.getInsurancePolicyNumber());
            mInsuranceSerial.setText(car.getInsurancePolicySerial());
            mPtsNumber.setText(car.getPtsNumber());
            mPtsSerial.setText(car.getPtsSerialNumber());
            mVinNumber.setText(car.getVinNumber());
            mPtsByWho.setText(car.getWhoGivedPts());

        }
    }
}
