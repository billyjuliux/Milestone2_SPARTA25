package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecipesDetails1 extends AppCompatActivity {


    ListView contentTextView;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_details1);

        //Function to go to donate layout
        final Button back = (Button) findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toRecipesLayout = new Intent(getApplicationContext(), Recipes.class);
                startActivity(toRecipesLayout);
            }
        });

    }}