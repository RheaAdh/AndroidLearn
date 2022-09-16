package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSave = findViewById(R.id.btn1);
        etName = findViewById(R.id.etName);
        preferences=getSharedPreferences(
                "CollegeApp", Context.MODE_PRIVATE
        );
        btnSave.setOnClickListener((view -> {
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("name", etName.getText().toString());
            editor.commit();
        }));
        Button btnRetrieve = findViewById(R.id.btn2);

        btnRetrieve.setOnClickListener((view -> {
            etName.setText(preferences.getString("name",""));
        }));
    }


}