package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView yourfoodListView;
    String[] foodNames, foodTimes;
    BroadcastReceiver minuteUpdateReceiver;
    int counter;

    public void startMinuteUpdater(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        minuteUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (counter<8) {
                    counter++;
                }
                ItemAdapter itemAdapter= new ItemAdapter(context, foodNames, foodTimes, counter);
                yourfoodListView.setAdapter(itemAdapter);
            }
        };
        registerReceiver(minuteUpdateReceiver, intentFilter);
    }

    protected void onResume(){
        super.onResume();
        startMinuteUpdater();
    }

    protected void onPause(){
        super.onPause();
        unregisterReceiver(minuteUpdateReceiver);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        yourfoodListView = (ListView) findViewById(R.id.yourfoodListView);
        foodNames = res.getStringArray(R.array.foodNames);
        foodTimes = res.getStringArray(R.array.foodTimes);



    }


}