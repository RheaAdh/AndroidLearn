package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app3.helpers.CollegeDbAdapter;

public class MainActivity extends AppCompatActivity {
//    SharedPreferences preferences;
    EditText etName;
    CollegeDbAdapter collegeDbAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSave = findViewById(R.id.btn1);
        etName = findViewById(R.id.etName);
//        preferences=getSharedPreferences(
//                "CollegeApp", Context.MODE_PRIVATE
//        );
        collegeDbAdapter = new CollegeDbAdapter(this);
        btnSave.setOnClickListener((view -> {
//            SharedPreferences.Editor editor=preferences.edit();
//            editor.putString("name", etName.getText().toString());
//            editor.commit();
            collegeDbAdapter.InsertStudent(etName.getText().toString());

            String message="";
//            if(collegeDbAdapter.InsertStudent(etName.getText().toString())>0){
//                message="Saved successfully!";
//            }
//            else{
//                message="blah";
//            }
//            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }));
        Button btnRetrieve = findViewById(R.id.btn2);

        btnRetrieve.setOnClickListener((view -> {
//            etName.setText(preferences.getString("name",""));
            etName.setText(collegeDbAdapter.getStudents());
        }));
    }

    @Override
    protected void onStart() {
        super.onStart();
        collegeDbAdapter.Open();
    }

    @Override
    protected void onStop() {
        super.onStop();
        collegeDbAdapter.Close();
    }
}