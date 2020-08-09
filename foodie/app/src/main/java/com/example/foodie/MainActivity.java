package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
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
                    ItemAdapter itemAdapter= new ItemAdapter(context, foodNames, foodTimes, counter);
                    yourfoodListView.setAdapter(itemAdapter);
                }
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

        final Button donatenav = (Button) findViewById(R.id.button3);
        donatenav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDonateLayout = new Intent(getApplicationContext(), donate.class);
                startActivity(toDonateLayout);
            }
        });

        final Button recipesNav = (Button) findViewById(R.id.recipesNav);
        recipesNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesLayout = new Intent(getApplicationContext(), Recipes.class);
                startActivity(toRecipesLayout);
            }
        });

        Resources res = getResources();
        yourfoodListView = (ListView) findViewById(R.id.yourfoodListView);
        foodNames = res.getStringArray(R.array.foodNames);
        foodTimes = res.getStringArray(R.array.foodTimes);

        ItemAdapter itemAdapter= new ItemAdapter(this, foodNames, foodTimes, counter);
        yourfoodListView.setAdapter(itemAdapter);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });

    }


}