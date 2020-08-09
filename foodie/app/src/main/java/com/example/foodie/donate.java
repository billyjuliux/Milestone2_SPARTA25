package com.example.foodie;

//import java.util.ArrayList;
//import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
//import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class donate extends Activity {

    private Spinner choose_loc, choose_food;
    private Button btnDonate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate);

        btnDonate = (Button) findViewById(R.id.submit_donate);
        btnDonate.setOnClickListener(resetBtn);
    }

    View.OnClickListener resetBtn = new View.OnClickListener() {
        public void onClick(View view) {
            choose_food.setSelection(0);
            choose_loc.setSelection(1);
        }
    };
}