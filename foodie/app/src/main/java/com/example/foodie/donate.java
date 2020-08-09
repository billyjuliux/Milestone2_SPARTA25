package com.example.foodie;

//import java.util.ArrayList;
//import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class donate extends AppCompatActivity {

    private Spinner choose_loc, choose_food;
    private Button btnDonate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);
        
        addListenerOnSpinnerItemSelection();
    }

    public void addListenerOnSpinnerItemSelection() {
        choose_loc = (Spinner) findViewById(R.id.donate_spinner);
        choose_food = (Spinner) findViewById(R.id.food_spinner);
        choose_loc.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        choose_food.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
}