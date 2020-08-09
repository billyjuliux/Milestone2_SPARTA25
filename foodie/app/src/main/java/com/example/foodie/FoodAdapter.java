package com.example.foodie;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {
    private Context mContext;
    int mResource;
    String[] foodTimes;

    public FoodAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Food> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        Integer age = getItem(position).getAge();

        Food food = new Food(name,age);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent , false);

        TextView namesTV = (TextView) convertView.findViewById(R.id.namesTV);
        TextView timesTV = (TextView) convertView.findViewById(R.id.timesTV);

        Resources res = mContext.getResources();
        foodTimes = res.getStringArray(R.array.foodTimes);

        namesTV.setText(name);
        timesTV.setText(foodTimes[age]);

        return convertView;
    }
}
