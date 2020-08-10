package com.example.foodie;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView yourfoodListView;
    ArrayList<Food> foodList;
    BroadcastReceiver minuteUpdateReceiver;
    EditText eAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Food carrot = new Food("Carrot", 0);
        Food milk = new Food("Milk", 3);
        Food potato = new Food("Potato", 1);

        foodList = new ArrayList<Food>();
        foodList.add(carrot);
        foodList.add(milk);
        foodList.add(potato);

        yourfoodListView = (ListView) findViewById(R.id.yourfoodListView);
        FoodAdapter adapter = new FoodAdapter(this, R.layout.listview_detail, foodList);
        yourfoodListView.setAdapter(adapter);

        yourfoodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int indexFood, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("Delete this Food from list?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            foodList.remove(indexFood);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        FoodAdapter adapter = new FoodAdapter(MainActivity.this, R.layout.listview_detail, foodList);
                        yourfoodListView.setAdapter(adapter);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });


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

        eAdd = (EditText) findViewById(R.id.eAdd);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getInput = eAdd.getText().toString();
                if(getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getBaseContext(), "Input Field is Empty", Toast.LENGTH_LONG).show();
                }
                else{
                    Food newFood = new Food (getInput, 0);
                    foodList.add(newFood);

                    FoodAdapter adapter = new FoodAdapter(MainActivity.this, R.layout.listview_detail, foodList);
                    yourfoodListView.setAdapter(adapter);

                    eAdd.setText("");
                }
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
                    if (foodList.get(i).getAge()<7) {
                        foodList.get(i).setAge(foodList.get(i).getAge()+1);
                    }
                }

                FoodAdapter adapter = new FoodAdapter(context, R.layout.listview_detail, foodList);
                yourfoodListView.setAdapter(adapter);

            }
        };
        registerReceiver(minuteUpdateReceiver, intentFilter);

        Button button2 = (Button) findViewById(R.id.btn1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

        if (getIntent().hasExtra("com.example.foodie.SOMETHING")) {
            String input1 = getIntent().getExtras().getString("com.example.foodie.SOMETHING");

            Food nFood = new Food(input1, 0);
            foodList.add(nFood);

            FoodAdapter adapter1 = new FoodAdapter(MainActivity.this, R.layout.listview_detail, foodList);
            yourfoodListView.setAdapter(adapter1);

            eAdd.setText("");
        }
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