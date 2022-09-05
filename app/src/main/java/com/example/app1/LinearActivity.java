package com.example.app1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LinearActivity extends AppCompatActivity {
    String TAG="First.LinearActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }
}
