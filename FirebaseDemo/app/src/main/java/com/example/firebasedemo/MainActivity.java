package com.example.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.firebasedemo.datamodel.Student;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=FirebaseFirestore.getInstance();
        Button btnSave=findViewById(R.id.btnSave);
        btnSave.setOnClickListener(view->{
            Student s =new Student(1,"Rhea","CSE");
            db.collection("students")
                    .add(s)
                    .addOnSuccessListener(r->{
                        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(r->{
                        Toast.makeText(this,"couldn't add",Toast.LENGTH_SHORT).show();
                    });
        });
    }
}