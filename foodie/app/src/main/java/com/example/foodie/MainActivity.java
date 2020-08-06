package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView yourfoodListView;
    String[] foodNames, foodTimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        yourfoodListView = (ListView) findViewById(R.id.yourfoodListView);
        foodNames = res.getStringArray(R.array.foodNames);
        foodTimes = res.getStringArray(R.array.foodTimes);

        ItemAdapter itemAdapter= new ItemAdapter(this, foodNames, foodTimes);
        yourfoodListView.setAdapter(itemAdapter);

    }
}