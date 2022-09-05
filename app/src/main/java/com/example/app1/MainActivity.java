package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TAG="First.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username= getIntent().getStringExtra("username");
        TextView err = (TextView) findViewById(R.id.fullname);
        err.setText(username);
        Button btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, LinearActivity.class);
                startActivity(intent);
        }
        });


        Log.d(TAG,"onCreate:");
        Spinner spCountries = findViewById(R.id.spCountries);
        ListView lvCountries=findViewById(R.id.lvCountries);
//        String []countries={"India","USA","Pakistan","China","Switzerland","Canada","Mexico"};
        String []countries=getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,countries);
        spCountries.setAdapter(adapter);
        lvCountries.setAdapter(adapter);
        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"position"+lvCountries.getSelectedItem(),Toast.LENGTH_SHORT).show();
            }
        });

        spCountries.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(MainActivity.this, "position" + spCountries.getSelectedItem(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }




}