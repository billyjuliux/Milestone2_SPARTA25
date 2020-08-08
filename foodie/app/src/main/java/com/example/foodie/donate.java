package com.example.foodie;

//import androidx.appcompat.app.AppCompatActivity;
//import java.util.ArrayList;
//import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class donate extends AppCompatActivity {

    private Spinner choose_loc;
    private Button btnDonate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        Button toRecipes = (Button) findViewById(R.id.recipesnav);
        toRecipes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRecipes = new Intent(getApplicationContext(), Recipes.class);
                startActivity(toRecipes);
            }
        });

        Button toYourFood = (Button) findViewById(R.id.yourfoodnav);
        toYourFood.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toYourFood = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toYourFood);
            }
        });
    }

    public void addListenerOnSpinnerItemSelection() {
        choose_loc = (Spinner) findViewById(R.id.donate_spinner);
        choose_loc.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //get the selected dropdown list value
    public void addListenerOnButton() {
        choose_loc = (Spinner) findViewById(R.id.donate_spinner);
        btnDonate = (Button) findViewById(R.id.submit_donate);

        btnDonate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(donate.this,
                        "OnClickListener : " +
                                "\ndonate_spinner : "+ String.valueOf(choose_loc.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

