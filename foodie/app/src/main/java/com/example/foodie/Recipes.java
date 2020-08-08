package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        //Fungsi untuk pergi ke layout donate
        final Button donateNav = (Button) findViewById(R.id.donatenav5);
        donateNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDonateLayout = new Intent(getApplicationContext(), donate.class);
                startActivity(toDonateLayout);
            }
        });

        //Fungsi untuk pergi ke layout yourfood
        final Button main = (Button) findViewById(R.id.yourfoodnav7);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainLayout = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMainLayout);
            }
        });

}}