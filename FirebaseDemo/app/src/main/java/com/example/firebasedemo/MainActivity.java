package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasedemo.datamodel.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

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
                        Log.d("here","");
                        Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(r->{
                        Toast.makeText(this,"couldn't add",Toast.LENGTH_SHORT).show();
                    });
        });
        Button retrieveBtn=findViewById(R.id.btnRetrieve);
        retrieveBtn.setOnClickListener(view -> {
            db.collection("students")
                    .whereEqualTo("departmentName","CSE")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                Log.d("SUCCESSFUL RETRIEVE","");
                                TextView tvResult =findViewById(R.id.tvResult);
                                String name="";
                                for(QueryDocumentSnapshot document : task.getResult()){
                                    Student s=document.toObject(Student.class);
                                    name+=s.getName()+"\n";
                                }
                                tvResult.setText(name);
                            }
                            else{
                                Log.w("TAG","Error",task.getException());
                            }
                        }
                    });
        });
    }
}