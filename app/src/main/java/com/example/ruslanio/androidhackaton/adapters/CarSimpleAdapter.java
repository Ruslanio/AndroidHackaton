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
 * Created by Ruslanio on 28.10.2017.
 */

public class CarSimpleAdapter extends RecyclerView.Adapter {

    private List<ResponseDatum> mCars = Collections.emptyList();
    private OnSimpleCarClickListener mOnSimpleCarClickListener;

    public void setCars(List<ResponseDatum> cars) {
        mCars = cars;
        notifyDataSetChanged();
    }

    public void setOnSimpleCarClickListener(OnSimpleCarClickListener onSimpleCarClickListener) {
        mOnSimpleCarClickListener = onSimpleCarClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinple_car,parent,false);
        return new CarSimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CarSimpleViewHolder) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    class CarSimpleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_car_mark)
        TextView mMark;
        @BindView(R.id.tv_car_model)
        TextView mModel;
        @BindView(R.id.tv_reg_number)
        TextView mRegNumber;

        public CarSimpleViewHolder(View itemView) {
            super(itemView);
        }

        void bind(int position){
            ResponseDatum car = mCars.get(position);
            mMark.setText(car.getCarMark().toString());
            mModel.setText(car.getCarModel().toString());
            mRegNumber.setText(car.getCarNumber());

            itemView.setOnClickListener(itemView -> {
                if (mOnSimpleCarClickListener != null)
                    mOnSimpleCarClickListener.onCarClick(car);
            });
        }
    }

    public interface OnSimpleCarClickListener {
        void onCarClick(ResponseDatum car);
    }
}
