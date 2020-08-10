package com.example.foodie;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class donate extends AppCompatActivity {

    Spinner choose_loc, choose_food;
    Button btnDonate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        choose_loc = (Spinner) findViewById(R.id.donate_spinner);
        choose_food = (Spinner) findViewById(R.id.food_spinner);
        btnDonate = (Button) findViewById(R.id.submit_donate);

        // Ubah target activity MainActivity -> AddActivity
        Button addButton = (Button) findViewById(R.id.addbutton);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAddFood = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(toAddFood);
            }
        });

        // Link ke recipes activity
        Button toRecipes = (Button) findViewById(R.id.recipesnav);
        toRecipes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRecipes = new Intent(getApplicationContext(), Recipes.class);
                startActivity(toRecipes);
            }
        });

        // Link ke main activity -> your food
        Button toyourFood = (Button) findViewById(R.id.yourfoodnav);
        toyourFood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toYourFood = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toYourFood);
            }
        });

        btnDonate.setOnClickListener(resetBtn);
        }

    View.OnClickListener resetBtn = new View.OnClickListener() {
        public void onClick(View view) {
            int food_spinner = choose_food.getSelectedItemPosition();
            int loc_spinner = choose_loc.getSelectedItemPosition();
            if (loc_spinner != 0) {
                choose_food.setSelection(0);
                choose_loc.setSelection(0);
                Toast.makeText(donate.this,
                    "Thank you for donating!", Toast.LENGTH_SHORT).show();
                }
            else {
                Toast.makeText(donate.this, "Please make your choice", Toast.LENGTH_SHORT).show();
            }
        }
    };
}