package com.example.foodie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    ListView yourfoodListView;
    String[] foodNames, foodTimes;
    int index;

    public ItemAdapter (Context c, String[] n, String[] t, int  i){
        foodNames = n;
        foodTimes = t;
        index = i;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return foodNames.length;
    }

    @Override
    public Object getItem(int i) {
        return foodNames[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.listview_detail, null);
        TextView namesTV = (TextView) v.findViewById(R.id.namesTV);
        TextView timesTV = (TextView) v.findViewById(R.id.timesTV);

        String name = foodNames[i];
        String time = foodTimes[index];

        namesTV.setText(name);
        timesTV.setText(time);


        return v;
    }
}
