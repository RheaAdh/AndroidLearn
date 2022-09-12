package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    String TAG="First.LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnSubmit = findViewById(R.id.loginbtn);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName = findViewById(R.id.inp1);
                EditText etPass = findViewById(R.id.inp2);
                String username = etName.getText().toString();
                String password = etPass.getText().toString();

                Toast.makeText(LoginActivity.this, username + "has logged in!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });


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