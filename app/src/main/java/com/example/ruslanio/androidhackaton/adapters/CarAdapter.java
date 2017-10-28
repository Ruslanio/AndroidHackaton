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
import butterknife.ButterKnife;

/**
 * Created by Ruslanio on 27.10.2017.
 */

public class CarAdapter extends RecyclerView.Adapter {

    private List<ResponseDatum> mCars = Collections.emptyList();
    private OnCarClickListener mOnCarClickListener;

    public void setCars(List<ResponseDatum> cars) {
        mCars = cars;
        notifyDataSetChanged();
    }

    public void setOnCarClickListener(OnCarClickListener onCarClickListener) {
        mOnCarClickListener = onCarClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CarViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
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
            ButterKnife.bind(this, itemView);
        }

        void bind(int position) {
            ResponseDatum car = mCars.get(position);

            System.out.println("PTSSERIALNUMBER = " + car.getPtsSerialNumber());
            mMark.setText(car.getCarMark().toString());
            mModel.setText(car.getCarModel().toString());
            mRegNumber.setText(car.getCarNumber().toString());
            mReleaseYear.setText(car.getCarYearOfBuilding().toString());
            mHorsePower.setText(car.getHorsePower().toString());
            mInsuranceNumber.setText(car.getInsurancePolicyNumber().toString());
            mInsuranceSerial.setText(car.getInsurancePolicySerial().toString());
            mPtsNumber.setText(car.getPtsNumber().toString());
            mPtsSerial.setText(car.getPtsSerialNumber().toString());
            mVinNumber.setText(car.getVinNumber().toString());
            mPtsByWho.setText(car.getWhoGivedPts().toString());

            itemView.setOnClickListener(item -> {
                if (mOnCarClickListener != null)
                    mOnCarClickListener.onCarClick(mCars.get(position));
            });

        }
    }

    public interface OnCarClickListener{
        void onCarClick(ResponseDatum car);
    }
}
