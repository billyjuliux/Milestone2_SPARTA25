package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        //Function to go to donate layout
        final Button donateNav = (Button) findViewById(R.id.donatenav5);
        donateNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDonateLayout = new Intent(getApplicationContext(), donate.class);
                startActivity(toDonateLayout);
            }
        });

        //Function to go to main layout
        final Button main = (Button) findViewById(R.id.yourfoodNav);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainLayout = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMainLayout);
            }
        });

        //Function to go to RecipesDetails - Recommended layout
        final ImageView details1 = (ImageView) findViewById(R.id.recommendedRecipes1);
        details1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesDetails = new Intent(getApplicationContext(), RecipesDetails.class);
                startActivity(toRecipesDetails);
            }
        });

        final ImageView details2 = (ImageView) findViewById(R.id.recommendedRecipes2);
        details2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesDetails = new Intent(getApplicationContext(), RecipesDetails.class);
                startActivity(toRecipesDetails);
            }
        });

        final ImageView details3 = (ImageView) findViewById(R.id.recommendedRecipes3);
        details3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesDetails = new Intent(getApplicationContext(), RecipesDetails.class);
                startActivity(toRecipesDetails);
            }
        });

        //Function to go to RecipesDetails - Popular layout
        final ImageView popularRecipes1 = (ImageView) findViewById(R.id.popularRecipes1);
        popularRecipes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesDetails1 = new Intent(getApplicationContext(), RecipesDetails1.class);
                startActivity(toRecipesDetails1);
            }
        });

        final ImageView popularRecipes2 = (ImageView) findViewById(R.id.popularRecipes2);
        popularRecipes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesDetails1 = new Intent(getApplicationContext(), RecipesDetails1.class);
                startActivity(toRecipesDetails1);
            }
        });

    }}