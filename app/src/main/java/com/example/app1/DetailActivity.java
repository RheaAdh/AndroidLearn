package com.example.app1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;

public class DetailActivity extends AppCompatActivity {
    String TAG="First.DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart:");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume:");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause:");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop:");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy:");
    }
}