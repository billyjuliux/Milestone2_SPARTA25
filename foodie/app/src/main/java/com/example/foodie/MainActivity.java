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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView yourfoodListView;
    BroadcastReceiver minuteUpdateReceiver;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Food carrot = new Food("Carrot" , 0);
        Food milk = new Food("Milk" , 3);
        Food potato = new Food("Potato" , 1);

        foodList = new ArrayList<Food>();
        foodList.add(carrot);
        foodList.add(milk);
        foodList.add(potato);

        yourfoodListView = (ListView) findViewById(R.id.yourfoodListView);
        FoodAdapter adapter = new FoodAdapter(this, R.layout.listview_detail, foodList);
        yourfoodListView.setAdapter(adapter);


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


        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void startMinuteUpdater(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        minuteUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                for (int i=0 ; i<foodList.size() ; i++){
                    if (foodList.get(i).getAge()<8) {
                        foodList.get(i).setAge(foodList.get(i).getAge()+1);
                    }
                }

                FoodAdapter adapter = new FoodAdapter(context, R.layout.listview_detail, foodList);
                yourfoodListView.setAdapter(adapter);

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

}